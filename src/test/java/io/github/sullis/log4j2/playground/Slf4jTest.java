package io.github.sullis.log4j2.playground;

import java.lang.reflect.Field;
import org.apache.logging.log4j.core.async.AsyncLogger;
import org.apache.logging.log4j.core.util.ReflectionUtil;
import org.apache.logging.slf4j.Log4jLogger;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class Slf4jTest {
  static {
    System.setProperty(
        "log4j2.contextSelector",
        "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
  }

  @Test
  public void slf4j() throws Exception {
    Logger logger = LoggerFactory.getLogger("hello.slf4j");
    assertThat(logger).isInstanceOf(org.apache.logging.slf4j.Log4jLogger.class);
    Log4jLogger log4jLogger = (Log4jLogger) logger;
    Field field = Log4jLogger.class.getDeclaredField("logger");
    assertThat(field).isNotNull();
    Object object = ReflectionUtil.getFieldValue(field, log4jLogger);
    assertThat(object)
        .isNotNull()
        .isInstanceOf(AsyncLogger.class);
  }
}
