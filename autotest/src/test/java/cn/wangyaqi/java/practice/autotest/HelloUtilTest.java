package cn.wangyaqi.java.practice.autotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HelloUtilTest {

  @BeforeEach
  void setUp() {
  }

  @Test
  void calc() {
    assertEquals(3, HelloUtil.calc(1, 2));
  }

  @Test
  void exception() {
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
          HelloUtil.exception("I am crash.");
        }
    );
    assertEquals("I am crash.", exception.getMessage());
  }

  @Test
  void testFailWithTimeout() {
    Assertions.assertTimeout(Duration.ofMillis(10), () -> Thread.sleep(100));
  }
}