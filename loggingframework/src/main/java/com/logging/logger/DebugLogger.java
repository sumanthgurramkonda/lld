package com.logging.logger;

import com.logging.level.LogLevel;
import com.logging.message.LogMessage;

public class DebugLogger extends AbstractLogger{

    public DebugLogger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
