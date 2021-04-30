package cn.wangyaqi.java.practice.autotest;

public class HelloUtil {

  public static int calc(int x, int y) {
    return x + y;
  }

  public static int exception(String msg) {
    throw new IllegalArgumentException(msg);
  }
}
