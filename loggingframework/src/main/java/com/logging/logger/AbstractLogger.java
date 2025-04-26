package com.logging.logger;

import com.logging.appender.LogAppender;
import com.logging.config.LogConfig;
import com.logging.level.LogLevel;
import com.logging.message.LogMessage;

import java.util.List;

public class AbstractLogger {

    protected LogLevel logLevel;
    private AbstractLogger nextLogger;
    static protected LogConfig logConfig;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(LogMessage logMessage, AbstractLogger nextLogger){
        if(logMessage==null){
            throw new NullPointerException("instance logMessage is null ");
        }
        LogLevel logLevel = logMessage.getLogLevel();
        if(this.logLevel!=null && logLevel.ordinal()<=this.logLevel.ordinal()){
            logMessage.setLogLevel(this.logLevel);
            log(logMessage);
        }
        if(this.nextLogger!=null){
            this.nextLogger.logMessage(logMessage,nextLogger);
        }
    }
    protected void setLogConfig(LogConfig logConfig){
        this.logConfig=logConfig;
    }
    protected void log(LogMessage logMessage) {
        logConfig.getLogLevels().forEach(logAppender ->logAppender.append(logMessage));
    }

}
