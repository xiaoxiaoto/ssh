package org.aoto.webservices.cxf.example.used;

import javax.annotation.Resource;

import org.aoto.webservices.cxf.example.publish.IUserWebServices;
import org.aoto.webservices.entity.User;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * ʹ��WebServices
 * Ҫ���ڹ�����ʹ��wsdl2java��wsdl�ļ����ɵ���Ŀsrc��
 * 
 */
@Controller
@RequestMapping(value="/cxf")
public class WebServicesInstance {
	
	@Value("#{configProperties['userWebservices.address']}")
	private String webServicesURL;
	
	@Resource(name="webServiceManager")
	private IUserWebServices userWebServices;
	
	@RequestMapping(value="/userWebServicesInstance")
	public void usedUserWebServices() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();  
        factory.setServiceClass(IUserWebServices.class);  
        factory.setAddress(webServicesURL);  
        IUserWebServices service = (IUserWebServices) factory.create();  
        User user = service.getUser();  
        System.out.println(user);
	}
	
	@RequestMapping(value="/userWebServicesInstance1th")
	public void usedUserWebServices1th() {
		User user = userWebServices.getUser();
		System.out.println(user);
	}
	
}
