package example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import sammwy.jlogger.Colors;
import sammwy.jlogger.JLogger;

public class Main {
	
	JLogger logger = new JLogger();
	
	public Main () {
		logger.setLoggerFilePath("logs.txt");
		logger.createSaveInterval(200);
		Runnable runnable = new Runnable() {
		    public void run() {
		        System.out.println(Colors.RED + "Hello world");
		    }
		};
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(runnable, 0, 300, TimeUnit.MILLISECONDS);
	}
	
	public static void main (String[] args) { new Main(); }
	
	

}
