package com.logging.logger;

import com.logging.level.LogLevel;
import com.logging.message.LogMessage;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
