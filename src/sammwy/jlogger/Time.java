package sammwy.jlogger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	
	private Date date;
	private SimpleDateFormat formatter;
	private String format;
	
	public Time (String format) {
		this.format = format;
		formatter = new SimpleDateFormat(format);
	}
	
	public String getTime () {
		date = new Date();
		return formatter.format(date);
	}

	public String getFormat () {
		return this.format;
	}
}
