package io.github.sullis.log4j2.playground;

import org.apache.logging.log4j.core.async.AsyncLogger;
import org.junit.jupiter.api.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static org.assertj.core.api.Assertions.assertThat;

public class LoggingTest {
    static {
        System.setProperty(
                "log4j2.contextSelector",
                "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
    }

    @Test
    void helloWorld() {
        Logger logger = LogManager.getLogger("foobar");
        assertThat(logger).isNotNull();
        assertThat(logger).isInstanceOf(AsyncLogger.class);
    }
}
