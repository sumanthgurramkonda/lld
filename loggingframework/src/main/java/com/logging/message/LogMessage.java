package com.logging.message;

import com.logging.level.LogLevel;

import java.util.Date;


public class LogMessage {

    private LogLevel logLevel;
    private String message;
    private Date date;

    public LogMessage(){

    }
    public LogMessage(LogLevel logLevel, String message) {
        this.logLevel = logLevel;
        this.message = message;
        this.date = new Date();
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "logLevel=" + logLevel +
                ", message='" + message + '\'' +
                ", date=" + date.toString() +
                '}';
    }
}
