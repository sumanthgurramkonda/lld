package com.logging.config;

import com.logging.appender.ConsoleAppender;
import com.logging.appender.FileAppender;
import com.logging.appender.LogAppender;
import com.logging.level.LogLevel;

import java.util.Arrays;
import java.util.List;

public class LogConfig {

    private LogLevel minLogLevel;
    private List<LogAppender> logLevels;

    public LogConfig() {
        this(LogLevel.DEBUG, Arrays.asList(new ConsoleAppender(),new FileAppender()));
    }
    public LogConfig(List<LogAppender> logLevels) {
       this(LogLevel.DEBUG,logLevels);
    }
    public LogConfig(LogLevel minLogLevel, List<LogAppender> logLevels) {
        this.minLogLevel=minLogLevel;
        this.logLevels=logLevels;
    }

    public LogLevel getMinLogLevel() {
        return minLogLevel;
    }

    public void setMinLogLevel(LogLevel minLogLevel) {
        this.minLogLevel = minLogLevel;
    }

    public List<LogAppender> getLogLevels() {
        return logLevels;
    }

    public void setLogLevels(List<LogAppender> logLevels) {
        this.logLevels = logLevels;
    }

}
