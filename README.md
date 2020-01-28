# JLogger
[![](https://jitpack.io/v/sammwyy/JLogger.svg)](https://jitpack.io/#sammwyy/JLogger)
An easy-to-use library to create logs and debug your project in java. Learn more about what your java application is doing in each print and save it in a file for future use.

## Usage
```java
package example;

import sammwy.jlogger.Colors;
import sammwy.jlogger.JLogger;

public class Main {
	JLogger logger = new JLogger();
	
  	public Main () {
		System.out.println("Hello World");
	}
  
  	public static void main (String[] args) { 
    		new Main(); 
  	}
}
```

## Functions
#### Create a log file and save it every x time:
```java
logger.setLoggerFilePath("logs.txt");
logger.createSaveInterval(200);
```

#### Use colors in the console
```java
System.out.println(Colors.RED + "Hello world");
```

#### Edit the output format
```java
JLogger logger = new JLogger("%time% -> %message%");
// or
logger.setEntryFormat("%time% -> %message%");

/* Variables:
  %message% -> return the message content.
  %thread%  -> return the current thread name.
  %type%    -> return the type of message. (To Do)
  %method%  -> return the current method name.
  %class%   -> return the current class name.
  %line%    -> return the current line number.
/*
```

#### Edit the time format
```java
JLogger logger = new JLogger(output_format, "HH:mm:ss");
# or
logger.setTimeFormat("HH:mm:ss");
```

#### Debug mode
For enable the pre-made debug format in prints output, use:
```java
logger.setDebug(boolean);
```

#### Change the debug formato
```java
logger.setDebugFormat(String);
```

#### Get current entry format
```java
logger.getEntryFormat(); // Returns a String
```

#### Get current time format
```java
logger.getTimeFormat(); // Returns a String
```

#### Get current debug format
```java
logger.getDebugFormat(); // Returns a String
```

#### Check is console/terminal support ANSI (For color nodes)
```java
Colors.isAnsiSupport():
```

## Available console colors and styles
A list of available styles in [Colors.java](https://github.com/sammwyy/JLogger/blob/master/src/sammwy/jlogger/Colors.java).  
```java
// Specials
Colors.RESET

// Colors
Colors.BLACK;
Colors.RED;
Colors.GREEN;
Colors.YELLOW;
Colors.BLUE;
Colors.PURPLE;
Colors.CYAN;
Colors.WHITE;

/// Bold Colors (just add _BOLD at the end)
Colors.BLACK_BOLD;
Colors.RED_BOLD;
Colors.GREEN_BOLD;
Colors.YELLOW_BOLD;
Colors.BLUE_BOLD;
Colors.PURPLE_BOLD;
Colors.CYAN_BOLD;
Colors.WHITE_BOLD;

// Underlined Colors (just add _UNDERLINED at the end)
Colors.BLACK_UNDERLINED;
Colors.RED_UNDERLINED;
Colors.GREEN_UNDERLINED;
Colors.YELLOW_UNDERLINED;
Colors.BLUE_UNDERLINED;
Colors.PURPLE_UNDERLINED;
Colors.CYAN_UNDERLINED;
Colors.WHITE_UNDERLINED;

// Backgrounds Colors (just add _BACKGROUND at the end)
Colors.BLACK_BACKGROUND;
Colors.RED_BACKGROUND;
Colors.GREEN_BACKGROUND;
Colors.YELLOW_BACKGROUND;
Colors.BLUE_BACKGROUND;
Colors.PURPLE_BACKGROUND;
Colors.CYAN_BACKGROUND;
Colors.WHITE_BACKGROUND;

// High Intensity Colors (Just add _BRIGHT at the end)
Colors.BLACK_BRIGHT;
Colors.RED_BRIGHT;
Colors.GREEN_BRIGHT;
Colors.YELLOW_BRIGHT;
Colors.BLUE_BRIGHT;
Colors.PURPLE_BRIGHT;
Colors.CYAN_BRIGHT;
Colors.WHITE_BRIGHT;

// High Intensity Bold Colors (Just add _BOLD_BRIGHT at the end)
Colors.BLACK_BOLD_BRIGHT;
Colors.RED_BOLD_BRIGHT;
Colors.GREEN_BOLD_BRIGHT;
Colors.YELLOW_BOLD_BRIGHT;
Colors.BLUE_BOLD_BRIGHT;
Colors.PURPLE_BOLD_BRIGHT;
Colors.CYAN_BOLD_BRIGHT;
Colors.WHITE_BOLD_BRIGHT;

// High Intensity Backgrounds Colors (Just add _BACKGROUND_BRIGHT at the end)
Colors.BLACK_BACKGROUND_BRIGHT;
Colors.RED_BACKGROUND_BRIGHT;
Colors.GREEN_BACKGROUND_BRIGHT;
Colors.YELLOW_BACKGROUND_BRIGHT;
Colors.BLUE_BACKGROUND_BRIGHT;
Colors.PURPLE_BACKGROUND_BRIGHT;
Colors.CYAN_BACKGROUND_BRIGHT;
Colors.WHITE_BACKGROUND_BRIGHT;
```
