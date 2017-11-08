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

	// 获取一个演示用的组合数据集对象
	private static CategoryDataset barDataAdapter() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(41, "1", "普通动物学");
		dataset.addValue(50, "1", "生物学");
		dataset.addValue(65, "2", "动物解剖学");
		dataset.addValue(78, "3", "生物理论课");
		dataset.addValue(80, "3", "动物理论课");
		return dataset;
	}

	@RequestMapping(value = "/getBarChart")
	public String getBarChart(HttpServletRequest request, ModelMap model) {
		// 获得数据集合
		CategoryDataset dataset = barDataAdapter();
		// 创建柱状图
		JFreeChart chart = ChartFactory.createBarChart3D("学生对教师授课满意度", // 图表标题
				"课程名", // 目录轴的显示标签
				"百分比", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
				);
		// 设置图表样式
		settingBarStyle(chart);

		// 解决乱码问题
		settingBarFont(chart);

		// 6. 将图形转换为图片，传到前台
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

	// 设置图表样式
	private void settingBarStyle(JFreeChart chart) {
		// 设置整个柱状图的颜色和文字（char对象的设置是针对整个图形的设置）
		chart.setBackgroundPaint(ChartColor.WHITE); // 设置总的背景颜色
		// 获得图形对象，并通过此对象对图形的颜色文字进行设置
		CategoryPlot p = chart.getCategoryPlot();// 获得图表对象
		p.setBackgroundPaint(ChartColor.GREEN);// 图形背景颜色
		p.setRangeGridlinePaint(ChartColor.BLACK);// 图形表格颜色
		// 得到柱子对象
		BarRenderer renderer = (BarRenderer) p.getRenderer();
		// 设置柱子宽度
		renderer.setMaximumBarWidth(0.05);
		//设置柱子顶端上显示具体的数值
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());//显示每个柱的数值 
		renderer.setBaseItemLabelsVisible(true); 
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition( 
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER)); 
		renderer.setItemLabelAnchorOffset(10D);// 设置柱形图上的文字偏离值 
	}

	// 设置文字样式
	private void settingBarFont(JFreeChart chart) {
		// 1. 图形标题文字设置
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("宋体", Font.BOLD, 20));

		// 2. 图形X轴坐标文字的设置
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		CategoryAxis axis = plot.getDomainAxis();
		axis.setLabelFont(new Font("宋体", Font.BOLD, 22)); // 设置X轴坐标上标题的文字
		axis.setTickLabelFont(new Font("宋体", Font.BOLD, 15)); // 设置X轴坐标上的文字

		// 2. 图形Y轴坐标文字的设置
		ValueAxis valueAxis = plot.getRangeAxis();
		valueAxis.setLabelFont(new Font("宋体", Font.BOLD, 15)); // 设置Y轴坐标上标题的文字
		valueAxis.setTickLabelFont(new Font("sans-serif", Font.BOLD, 12));// 设置Y轴坐标上的文字
	}

	private DefaultPieDataset pieDataAdapter() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("管理人员", 25);
		dataset.setValue("市场人员", 35);
		dataset.setValue("开发人员", 20);
		dataset.setValue("后勤人员", 5);
		dataset.setValue("财务人员", 15);
		return dataset;
	}

	@RequestMapping(value = "/getPieChart")
	public String getPieChart(HttpServletRequest request, ModelMap model) {
		// 加载饼状图数据
		DefaultPieDataset dataset = pieDataAdapter();
		// 得到饼状图
		JFreeChart chart = ChartFactory.createPieChart3D("公司组织架构图", dataset,
				false, false, false);
		// 设置饼状图样式
		settingPieStyle(chart);
		// 设置饼状图字体
		settingPieFont(chart);

		// 6. 将图形转换为图片，传到前台
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

	// 设置饼状图字体
	private void settingPieFont(JFreeChart chart) {
		// 设置饼状图标题字体
		TextTitle title = chart.getTitle();
		title.setFont(new Font("宋体", Font.BOLD, 20));
		// 得到饼状图对象
		PiePlot3D p = (PiePlot3D) chart.getPlot();
		p.setLabelFont(new Font("宋体", Font.BOLD, 14));
		// // 得到图例说明对象
		// LegendTitle legend = chart.getLegend();
		// // 设置图例说明字体
		// legend.setItemFont(new Font("宋体", Font.PLAIN, 30));

	}

	// 设置饼状图样式
	private void settingPieStyle(JFreeChart chart) {
		// 设置饼状图背景色
		chart.setBorderPaint(ChartColor.WHITE);
		// 得到饼状图对象
		PiePlot3D p = (PiePlot3D) chart.getPlot();
		// 设置饼状图边框颜色
		p.setBaseSectionOutlinePaint(ChartColor.BLACK);
		// 设置边框粗细
		p.setBaseSectionOutlineStroke(new BasicStroke(1.0f));
		// 设置饼状图的透明度
		p.setForegroundAlpha(0.5f);
		// 设置饼状图的形状：圆形(false)还椭圆形(true)
		p.setCircular(false);
		// 设置第一个扇区的开始位置默认为12点钟方向
		p.setStartAngle(360);
		// 设置鼠标悬停提示
		p.setToolTipGenerator(new StandardPieToolTipGenerator());
		// 设置突出显示的数据块
		p.setExplodePercent("one", 0.1D);
		// 设置分饼颜色
		p.setSectionPaint("one", new Color(244, 194, 144));
		// 设置分饼上的数值
		p.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} {2}",
				NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
	}
}
