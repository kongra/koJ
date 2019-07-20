// Copyright (c) Konrad Grzanek
// Created 2019-07-19
package koJ;

public interface UncheckedRunnable extends Runnable {

  void runThrowing() throws Throwable;

  @Override
  default void run() {
    try {
      runThrowing();
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }

}
