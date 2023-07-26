package application.config;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfigDateTime {
private static ConfigDateTime instance;
	
	public static ConfigDateTime getInstance() {
		if(instance == null) {
			instance = new ConfigDateTime();
		}
		return instance;
	}
	
	private final String _patternDate = "yyyy-MM-dd";
    private final String _patternDateView = "dd-MM-yyyy";
    private final String _patternTime = "hh:mm:ss.sss aa";
    public final String _patternDateTime = "yyyy-mm-dd hh:mm:ss.sss aa";
    
    public String DateNow =new SimpleDateFormat(_patternDate).format(new Date());
    public String DateView =new SimpleDateFormat(_patternDateView).format(new Date());
    public String TimeNow =new SimpleDateFormat(_patternTime).format(new Date());
    public String Now = new SimpleDateFormat(_patternDateTime).format(new Date());
    
    
    public String convertStringToDate(String str) throws ParseException {
    	 String rs= null;
    	//convert String to Date
    	Date dat = new SimpleDateFormat().parse(str);
    	
    	//COnvert Date to timestamp
    	Timestamp timestamp = new Timestamp(dat.getTime());
    	
    	//Convert timestamp to Date
    	dat = new Date(timestamp.getTime());
    	
    	//Convert Date to String
    	rs = new SimpleDateFormat().format(dat);
    	
    	return rs;
    }
}
