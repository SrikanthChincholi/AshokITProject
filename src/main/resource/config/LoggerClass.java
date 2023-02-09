package config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerClass {

	public static Logger logger = null;

	public static Logger logger(Class clz) {
		if (logger == null) {
			return LogManager.getLogger(clz.getClass());
		} else {
			return logger;
		}
	}

	
}
