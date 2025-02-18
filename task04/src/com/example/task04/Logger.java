package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Logger {
    private final String name;
    private Level level;
    private static Map<String, Logger> loggers = new HashMap<>();

    public Logger(String name, Object... params) {
        this.name = name;
        this.level = Level.INFO;
        loggers.put(name, this);
    }

    public Logger(String name, Level level) {
        this.name = name;
        this.level = level;
        loggers.put(name, this);
    }

    public Level getLevel() {

        return level;
    }

    public String getName() {

        return name;
    }

    public void setLevel(Level level) {

        this.level = level;
    }

    public static Logger getLogger(String name) {
        if(loggers.containsKey(name))
            return loggers.get(name);
        return new Logger(name, new ConsoleHandler(), new RotationFileHandler("logFile-1", ChronoUnit.MINUTES));
    }

    public void info(String message) {

        log(Level.INFO, message);
    }

    public void info(String message, Object... params) {

        log(Level.INFO, message, params);
    }

    public void debug(String message) {

        log(Level.DEBUG, message);
    }

    public void debug(String message, Object... params) {

        log(Level.DEBUG, message, params);
    }

    public void warning(String message) {

        log(Level.WARNING, message);
    }

    public void warning(String message, Object... params) {

        log(Level.WARNING, message, params);
    }

    public void error(String message) {

        log(Level.ERROR, message);
    }

    public void error(String message, Object... params) {

        log(Level.ERROR, message, params);
    }

    public void log(Level level, String message) {
        logMessage(level, message);
    }

    public void log(Level level, String message, Object... params) {
        logMessage(level, message, params);
    }

    private void logMessage(Level level, String message) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format("[{0}] {1} {2} - {3}",
                    level,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")),
                    this.name,
                    message));
        }
    }

    private void logMessage(Level level, String message, Object... params) {
        if (level.ordinal() >= this.level.ordinal()) {
            System.out.println(MessageFormat.format(message, params));
        }
    }
}