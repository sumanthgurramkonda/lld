package com.logging.logger;

import com.logging.level.LogLevel;
import com.logging.message.LogMessage;

public class WarnigLogger extends AbstractLogger{

    public WarnigLogger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
}
