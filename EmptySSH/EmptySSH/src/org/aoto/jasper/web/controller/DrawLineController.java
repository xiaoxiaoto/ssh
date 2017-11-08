package org.aoto.jasper.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.aoto.jasper.business.IDrawLineBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/jasper")
public class DrawLineController {
	@Resource(name="drawLineBiz")
private IDrawLineBiz drawLineBiz;
	@RequestMapping(value="/drawLine/{type}")
	public ModelAndView getDate(@PathVariable String type){
		Map<String, Object> model = new HashMap<String, Object>();  
		model.put("format", type);
		return new ModelAndView("customerReport",model);
	}
}
