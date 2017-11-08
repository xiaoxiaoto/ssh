package org.aoto.tools.arcgis.example;

import javax.annotation.Resource;

import org.aoto.tools.arcgis.ConnectionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.esri.sde.sdk.client.SeConnection;

@Controller
@RequestMapping(value = "/arcgis")
public class ConnectionExample {
	@Resource(name="connectionFactoryBean")
     private ConnectionFactoryBean connectionFactoryBean;
	
	@RequestMapping(value = "/getconn")
	public void getConn(){
		
	
//		SeConnection connection =connectionFactoryBean.getArcSDEServiceConnection();
//		System.out.println(connection.getRelease().getBugFix());
		SeConnection connection1 =connectionFactoryBean.getDirectConnection();
		System.out.println(connection1.getRelease().getBugFix());
	}
}
