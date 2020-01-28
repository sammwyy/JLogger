# JLogger
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
# or
logger.setEntryFormat("%time% -> %message%");

# Variables:
# %message% -> return the message content.
# %thread%  -> return the current thread name.
# %type%    -> return the type of message. (To Do)
# %method%  -> return the current method name.
# %class%   -> return the current class name.
# %line%    -> return the current line number.
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
