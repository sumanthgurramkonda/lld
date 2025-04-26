package com.logging.appender;

import com.logging.level.LogLevel;
import com.logging.message.LogMessage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{

    private StringBuffer logFilePath;

    public FileAppender(){
        this("src/resources/");
    }
    public FileAppender(String logFilePath) {
        this.logFilePath = new StringBuffer(logFilePath);
    }

    private void write(LogMessage logMessage) {
        LogLevel logLevel = logMessage.getLogLevel();
        if(logLevel!=null){
            logFilePath.append(logLevel.toString()).append(".txt");
        }else{
            logFilePath.append("log.txt");
        }
//        try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(String.valueOf(logFilePath))))) {
//            writer.write(logMessage.getLogLevel() +" : "+ logMessage.getDate().toString()+" ; "+logMessage.getMessage());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("File Appender : "+logMessage.getLogLevel() +" : "+ logMessage.getDate().toString()+"  "+logMessage.getMessage());

    }

    @Override
    public void append(LogMessage logMessage) {
        write(logMessage);
    }
}
