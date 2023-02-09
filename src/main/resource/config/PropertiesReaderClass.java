package config;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesReaderClass {

	static FileReader fr;
	static Properties prop;
	static String filepath = "./src/main/resource/propertiesfiles/Config.properties";

	public static String readValues(String key) throws Exception {
		fr = new FileReader(filepath);
		prop = new Properties();
		prop.load(fr);
		return prop.getProperty(key);

	}

}
