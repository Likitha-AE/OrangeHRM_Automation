package generic_utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtils {
	
	public String sysDateTime()
	{
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		String systemDateInFormat = sim.format(date);
		return systemDateInFormat;
	}

}
