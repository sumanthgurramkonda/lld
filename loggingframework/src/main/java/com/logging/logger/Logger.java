package com.logging.logger;

import com.logging.config.LogConfig;
import com.logging.level.LogLevel;
import com.logging.message.LogMessage;

import java.util.Date;

public class Logger {

    private static Logger logger=null;
    private static AbstractLogger abstractLogger;
    private Logger(){

    }

    public static Logger getLoggerInstance(){
        if(logger==null){
            synchronized (Logger.class){
                if (logger==null){
                    logger=new Logger();
                    abstractLogger=LoggerManager.doChaing();
                }
            }
        }
        return logger;
    }

    public void setLogConfig(LogConfig logConfig){
        abstractLogger.setLogConfig(logConfig);
    }

    private void log(LogLevel logLevel,String message,AbstractLogger logger){
        LogMessage logMessage = new LogMessage(logLevel,message);
        abstractLogger.logMessage(logMessage,logger);
    }
    public void log(LogLevel logLevel,String message){
        log(logLevel,message,abstractLogger);
    }
    public void info(String message){
        log(LogLevel.INFO,message);
    }
    public void debug(String message){
        log(LogLevel.DEBUG,message);
    }
    public void error(String message){
        log(LogLevel.ERROR,message);
    }
    public void fatal(String message){
        log(LogLevel.FATAL,message);
    }

}
