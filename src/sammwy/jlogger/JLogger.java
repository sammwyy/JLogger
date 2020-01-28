package sammwy.jlogger;

import java.io.PrintStream;

public class JLogger {
	
	private String format = "[%time% %type%] [%thread%/thread] %message%";
	private String debugFormat = "[%time% %type%] [%thread%/thread] [%method%] (%class%.class:%line%) -> %message%";
	private PrintStream printStream;
	private Time time = new Time("HH:mm:ss");
	private LoggerFile lfile = new LoggerFile();
	private boolean debug = false;
	
	public JLogger () {
		this.updateStream();
	}
	
	public JLogger (String entryFormat) {
		this.format = entryFormat;
		this.updateStream();
	}
	
	public JLogger (String entryFormat, String timeFormat) {
		this.format = entryFormat;
		this.time = new Time(timeFormat);
		this.updateStream();
	}
	
	public void setEntryFormat (String newEntryFormat) {
		this.format = newEntryFormat;
		this.updateStream();
	}
	
	public void setTimeFormat (String timeFormat) {
		this.time = new Time(timeFormat);
		this.updateStream();
	}
	
	public String getEntryFormat () {
		return this.getEntryFormat();
	}
	
	public String getTimeFormat () {
		return this.time.getFormat();
	}
	
	public String getDebugFormat () {
		return this.debugFormat;
	}
	
	public void setDebugFormat (String value) {
		this.debugFormat = value;
		this.updateStream();
	}
	
	public void setDebug (boolean value) {
		this.debug = value;
		updateStream();
	}
	
	public void updateStream () {
		printStream = new PrintStream(System.out) {
		    @Override
		    public void println(String message) {
		    	String output = format;
		    	if (debug) output = debugFormat;
		    	
		    	output = output.replace("%message%", message);
		    	output = output.replace("%thread%", Thread.currentThread().getName());
		    	output = output.replace("%type%", "INFO");
		    	output = output.replace("%time%", time.getTime());
		    	output = output.replace("%method%", new Throwable().getStackTrace()[1].getMethodName());
		    	output = output.replace("%class%", new Throwable().getStackTrace()[1].getClassName());
		    	output = output.replace("%line%", String.valueOf(new Throwable().getStackTrace()[1].getLineNumber()));
		    	
		    	lfile.addLine(output);
		    	
		    	if (Colors.isAnsiSupport())
		    		output = output.concat(Colors.RESET);
		    	
		        super.println(output);
		    }
		    
		};
		
		System.setOut(printStream);
	}
	
	public void setLoggerFilePath (String newPath) {
		this.lfile.setLoggerFilePath(newPath);
	}
	
	public void createSaveInterval (long time) {
		this.lfile.createSaveInterval(time);
	}
}
