package sammwy.jlogger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoggerFile {
	
	private List<String> lines = new ArrayList<String>();
	private String filePath;
	private Thread intervalThread;
	
	public void addLine (String line) {
		line = removeColorsFromLine(line);
		lines.add(line);
	}
	
	public void saveToFile () {
		
		if (filePath == null) return;
		
		Path file = Paths.get(filePath);
		try {
			Files.write(file, lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setLoggerFilePath (String newPath) {
		this.filePath = newPath;
	}
	
	public void createSaveInterval (long time) {
		intervalThread = new Thread() {
			@Override
			public void run () {
				for (;;) {
					saveToFile();
					try {
						Thread.sleep(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
						this.interrupt();
					}
				}
			}
		};
		
		intervalThread.start();
	}
	
	private String removeColorsFromLine (String line) {
		line = line.replaceAll("\u001B\\[[;\\d]*m", "");
		return line;
	}
}
