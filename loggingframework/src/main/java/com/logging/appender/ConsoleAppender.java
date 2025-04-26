package com.logging.appender;

import com.logging.level.LogLevel;
import com.logging.message.LogMessage;

public class ConsoleAppender implements  LogAppender{

    @Override
    public void append(LogMessage logMessage) {
//        if(logMessage.getLogLevel()==LogLevel.ERROR){
//            System.err.println(logMessage.getLogLevel() +" : "+ logMessage.getDate().toString()+"  "+logMessage.getMessage());
//        }
        System.out.println(logMessage.getLogLevel() +" : "+ logMessage.getDate().toString()+"  "+logMessage.getMessage());
    }




}
