package org.example;

import com.logging.appender.FileAppender;
import com.logging.config.LogConfig;
import com.logging.level.LogLevel;
import com.logging.logger.Logger;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getLoggerInstance();
        LogConfig logConfig = new LogConfig();
        logger.setLogConfig(logConfig);

        logger.log(LogLevel.INFO,"in");
        logger.error("error");
        logger.info("info message");
        logger.debug("debug");
    }
}