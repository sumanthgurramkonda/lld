package com.logging.logger;

import com.logging.level.LogLevel;
import com.logging.message.LogMessage;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
