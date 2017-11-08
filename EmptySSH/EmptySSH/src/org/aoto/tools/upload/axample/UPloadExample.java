package org.aoto.tools.upload.axample;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.aoto.tools.upload.IUploadFile;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping(value = "/upload")
public class UPloadExample  implements ServletContextAware{
	@Resource(name = "uploadFile")
	private IUploadFile uploadFile;
	
	
	private ServletContext context;
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public String upload() {
		return "upload";
	}
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public void upload(String name, @RequestParam("file") CommonsMultipartFile file) {
		String path = context.getRealPath("/resources/upload/");
		Boolean result = uploadFile.uploadFile(name, file, path);
		System.err.println(result);
	}

	
	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	
}
