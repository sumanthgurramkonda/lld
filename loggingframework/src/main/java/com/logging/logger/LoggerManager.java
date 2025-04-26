package com.logging.logger;

import com.logging.appender.ConsoleAppender;
import com.logging.appender.FileAppender;
import com.logging.appender.LogAppender;
import com.logging.config.LogConfig;
import com.logging.level.LogLevel;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;

public class LoggerManager {

    public static AbstractLogger doChaing(){

        AbstractLogger debugLogger = new DebugLogger(LogLevel.DEBUG);
        AbstractLogger infoLogger = new InfoLogger(LogLevel.INFO);
        AbstractLogger warningLogger = new WarnigLogger(LogLevel.WARNING);
        AbstractLogger errorLogger = new ErrorLogger(LogLevel.ERROR);
        AbstractLogger fatalLogger = new FatalLogger(LogLevel.FATAL);

        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(warningLogger);
        warningLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(fatalLogger);

        return debugLogger;
    }

}

//DEBUG, INFO, WARNING, ERROR, FATAL