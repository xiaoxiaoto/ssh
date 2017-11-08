package org.aoto.tools.arcgis;

import com.esri.sde.sdk.client.SeConnection;
import com.esri.sde.sdk.client.SeException;

public class ConnectionFactoryBean {

	private static SeConnection connection = null;

	private static String service_server;
	private static int service_instance;
	private static String service_database;
	private static String service_username;
	private static String service_password;

	private static String direct_server;
	private static String direct_instance;
	private static String direct_database;
	private static String direct_username;
	private static String direct_password;

	public SeConnection getArcSDEServiceConnection() {
		if (connection == null) {
			try {
				connection = new SeConnection(service_server, service_instance,
						service_database, service_username, service_password);
			} catch (SeException ex) {
				ex.printStackTrace();
			}
		}
		return connection;
	}

	public SeConnection getDirectConnection() {
		if (connection == null) {
			try {
				connection = new SeConnection(direct_server, direct_instance, direct_database, direct_username,direct_password);
			} catch (SeException ex) {
				ex.printStackTrace();
			}
		}
		return connection;
	}

	public static String getService_server() {
		return service_server;
	}

	public static void setService_server(String service_server) {
		ConnectionFactoryBean.service_server = service_server;
	}

	public static int getService_instance() {
		return service_instance;
	}

	public static void setService_instance(int service_instance) {
		ConnectionFactoryBean.service_instance = service_instance;
	}

	public static String getService_database() {
		return service_database;
	}

	public static void setService_database(String service_database) {
		ConnectionFactoryBean.service_database = service_database;
	}

	public static String getService_username() {
		return service_username;
	}

	public static void setService_username(String service_username) {
		ConnectionFactoryBean.service_username = service_username;
	}

	public static String getService_password() {
		return service_password;
	}

	public static void setService_password(String service_password) {
		ConnectionFactoryBean.service_password = service_password;
	}

	public static String getDirect_server() {
		return direct_server;
	}

	public static void setDirect_server(String direct_server) {
		ConnectionFactoryBean.direct_server = direct_server;
	}

	public static String getDirect_instance() {
		return direct_instance;
	}

	public static void setDirect_instance(String direct_instance) {
		ConnectionFactoryBean.direct_instance = direct_instance;
	}

	public static String getDirect_database() {
		return direct_database;
	}

	public static void setDirect_database(String direct_database) {
		ConnectionFactoryBean.direct_database = direct_database;
	}

	public static String getDirect_username() {
		return direct_username;
	}

	public static void setDirect_username(String direct_username) {
		ConnectionFactoryBean.direct_username = direct_username;
	}

	public static String getDirect_password() {
		return direct_password;
	}

	public static void setDirect_password(String direct_password) {
		ConnectionFactoryBean.direct_password = direct_password;
	}

}
