package generic_utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	
	public String getData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IpathConstants.proFilePath);
		Properties pobj = new Properties();
		
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

}
