package com.logging.appender;

import com.logging.message.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
}
