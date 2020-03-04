package com.secureauth.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerTrace {
	public static LoggerTrace _instance=null;
	public Logger getLogger(Object o) {
		return Logger.getLogger(o.getClass().getName());
	}
	private LoggerTrace() {
		String userDir = System.getProperty("user.dir");
		String configFile = String.format("%s//%s//%s.properties", userDir, "properties", "log4j");
		PropertyConfigurator.configure(configFile);
	}
	
	public static LoggerTrace getInstance() {
		if(_instance==null) {
			synchronized (LoggerTrace.class) {
				_instance=new LoggerTrace();
			}
		}
		return _instance;
	}
	
}
