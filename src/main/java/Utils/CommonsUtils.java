package Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonsUtils {
	
	
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=10;
	public static final int EXPLICIT_WAIT_BASIC_TIME=20;
	
	public static String getEmailWithTimestamp() {
		
		
		   Date date = new Date();
		
		  DateFormat format = new SimpleDateFormat("ddMMyyyyhhmmss");
		  
		  return "Auto_"+format.format(date)+"@gmail.com"; 
		
		
			/*
			 * Date date = new Date();
			 * 
			 * return "amotoori"+date.toString().replace("","_").replace(":",
			 * "_")+"@gmail.com";
			 */
	}


}
