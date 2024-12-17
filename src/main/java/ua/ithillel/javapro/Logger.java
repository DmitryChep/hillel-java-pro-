package ua.ithillel.javapro;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

public class Logger {
    private static Logger instance;
    private final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final Stack<String> logs = new Stack<>();

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void info(String info) {
        logs.push(date.format(new Date()) + " [INFO] " + info);
    }

    public void debug(String debug) {
        logs.push(date.format(new Date()) + " [DEBUG] " + debug);
    }

    public void showLogs() {
        for (String log : logs) {
            System.out.println(log);
        }
    }
}
