package org.aoto.chart.jfreechart.web.controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JfreeChartController {
	@RequestMapping(value = "/chartpage")
	public String goToChartPage() {
		return "chart";
	}

	// ��ȡһ����ʾ�õ�������ݼ�����
	private static CategoryDataset barDataAdapter() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(41, "1", "��ͨ����ѧ");
		dataset.addValue(50, "1", "����ѧ");
		dataset.addValue(65, "2", "�������ѧ");
		dataset.addValue(78, "3", "�������ۿ�");
		dataset.addValue(80, "3", "�������ۿ�");
		return dataset;
	}

	@RequestMapping(value = "/getBarChart")
	public String getBarChart(HttpServletRequest request, ModelMap model) {
		// ������ݼ���
		CategoryDataset dataset = barDataAdapter();
		// ������״ͼ
		JFreeChart chart = ChartFactory.createBarChart3D("ѧ���Խ�ʦ�ڿ������", // ͼ�����
				"�γ���", // Ŀ¼�����ʾ��ǩ
				"�ٷֱ�", // ��ֵ�����ʾ��ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				false, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
				);
		// ����ͼ����ʽ
		settingBarStyle(chart);

		// �����������
		settingBarFont(chart);

		// 6. ��ͼ��ת��ΪͼƬ������ǰ̨
		String fileName = null;
		try {
			fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400, null,
					request.getSession());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String chartURL = request.getContextPath() + "/chart/bar?filename="
				+ fileName;
		model.put("chartURL", chartURL);
		return "chart";
	}

	// ����ͼ����ʽ
	private void settingBarStyle(JFreeChart chart) {
		// ����������״ͼ����ɫ�����֣�char������������������ͼ�ε����ã�
		chart.setBackgroundPaint(ChartColor.WHITE); // �����ܵı�����ɫ
		// ���ͼ�ζ��󣬲�ͨ���˶����ͼ�ε���ɫ���ֽ�������
		CategoryPlot p = chart.getCategoryPlot();// ���ͼ�����
		p.setBackgroundPaint(ChartColor.GREEN);// ͼ�α�����ɫ
		p.setRangeGridlinePaint(ChartColor.BLACK);// ͼ�α����ɫ
		// �õ����Ӷ���
		BarRenderer renderer = (BarRenderer) p.getRenderer();
		// �������ӿ��
		renderer.setMaximumBarWidth(0.05);
		//�������Ӷ�������ʾ�������ֵ
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());//��ʾÿ��������ֵ 
		renderer.setBaseItemLabelsVisible(true); 
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition( 
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER)); 
		renderer.setItemLabelAnchorOffset(10D);// ��������ͼ�ϵ�����ƫ��ֵ 
	}

	// ����������ʽ
	private void settingBarFont(JFreeChart chart) {
		// 1. ͼ�α�����������
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("����", Font.BOLD, 20));

		// 2. ͼ��X���������ֵ�����
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		CategoryAxis axis = plot.getDomainAxis();
		axis.setLabelFont(new Font("����", Font.BOLD, 22)); // ����X�������ϱ��������
		axis.setTickLabelFont(new Font("����", Font.BOLD, 15)); // ����X�������ϵ�����

		// 2. ͼ��Y���������ֵ�����
		ValueAxis valueAxis = plot.getRangeAxis();
		valueAxis.setLabelFont(new Font("����", Font.BOLD, 15)); // ����Y�������ϱ��������
		valueAxis.setTickLabelFont(new Font("sans-serif", Font.BOLD, 12));// ����Y�������ϵ�����
	}

	private DefaultPieDataset pieDataAdapter() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("������Ա", 25);
		dataset.setValue("�г���Ա", 35);
		dataset.setValue("������Ա", 20);
		dataset.setValue("������Ա", 5);
		dataset.setValue("������Ա", 15);
		return dataset;
	}

	@RequestMapping(value = "/getPieChart")
	public String getPieChart(HttpServletRequest request, ModelMap model) {
		// ���ر�״ͼ����
		DefaultPieDataset dataset = pieDataAdapter();
		// �õ���״ͼ
		JFreeChart chart = ChartFactory.createPieChart3D("��˾��֯�ܹ�ͼ", dataset,
				false, false, false);
		// ���ñ�״ͼ��ʽ
		settingPieStyle(chart);
		// ���ñ�״ͼ����
		settingPieFont(chart);

		// 6. ��ͼ��ת��ΪͼƬ������ǰ̨
		String fileName = null;
		try {
			fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400, null,
					request.getSession());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String chartURL = request.getContextPath() + "/chart/pie?filename="
				+ fileName;
		model.put("pchartURL", chartURL);
		return "chart";
	}

	// ���ñ�״ͼ����
	private void settingPieFont(JFreeChart chart) {
		// ���ñ�״ͼ��������
		TextTitle title = chart.getTitle();
		title.setFont(new Font("����", Font.BOLD, 20));
		// �õ���״ͼ����
		PiePlot3D p = (PiePlot3D) chart.getPlot();
		p.setLabelFont(new Font("����", Font.BOLD, 14));
		// // �õ�ͼ��˵������
		// LegendTitle legend = chart.getLegend();
		// // ����ͼ��˵������
		// legend.setItemFont(new Font("����", Font.PLAIN, 30));

	}

	// ���ñ�״ͼ��ʽ
	private void settingPieStyle(JFreeChart chart) {
		// ���ñ�״ͼ����ɫ
		chart.setBorderPaint(ChartColor.WHITE);
		// �õ���״ͼ����
		PiePlot3D p = (PiePlot3D) chart.getPlot();
		// ���ñ�״ͼ�߿���ɫ
		p.setBaseSectionOutlinePaint(ChartColor.BLACK);
		// ���ñ߿��ϸ
		p.setBaseSectionOutlineStroke(new BasicStroke(1.0f));
		// ���ñ�״ͼ��͸����
		p.setForegroundAlpha(0.5f);
		// ���ñ�״ͼ����״��Բ��(false)����Բ��(true)
		p.setCircular(false);
		// ���õ�һ�������Ŀ�ʼλ��Ĭ��Ϊ12���ӷ���
		p.setStartAngle(360);
		// ���������ͣ��ʾ
		p.setToolTipGenerator(new StandardPieToolTipGenerator());
		// ����ͻ����ʾ�����ݿ�
		p.setExplodePercent("one", 0.1D);
		// ���÷ֱ���ɫ
		p.setSectionPaint("one", new Color(244, 194, 144));
		// ���÷ֱ��ϵ���ֵ
		p.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} {2}",
				NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
	}
}
