package org.aoto.chart.highchart.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HighChartController {
	@RequestMapping(value = "/gethchart")
	public String getHighChart() {
		return "hchart";
	}
}
