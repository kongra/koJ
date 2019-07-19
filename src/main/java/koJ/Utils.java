// Copyright (c) kongra
// Created 2019-07-18
package koJ;

public class Utils {

  public static void unchecked(Runnable body) {
    try {
      body.run();
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }

  private Utils() {
    throw new AssertionError();
  }
}
