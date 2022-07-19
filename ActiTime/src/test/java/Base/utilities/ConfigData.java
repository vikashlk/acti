package Base.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigData {
	
	public Properties p;
	
	public ConfigData() {
		
		try {
			File src = new File("./configer/config.properties");
			FileInputStream fis = new FileInputStream(src);
			p = new Properties();
			p.load(fis);
		} catch (Exception e) {
			System.out.println("proper data is missing");
		}
		
	}
	
	public String config_Browser() {
		
		return p.getProperty("Browser");
	}
	
	public String config_url() {
		
		return p.getProperty("TestUrl");
	}

}
