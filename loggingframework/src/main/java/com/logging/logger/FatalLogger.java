package com.logging.logger;

import com.logging.level.LogLevel;
import com.logging.message.LogMessage;

public class FatalLogger extends AbstractLogger{

    public FatalLogger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
