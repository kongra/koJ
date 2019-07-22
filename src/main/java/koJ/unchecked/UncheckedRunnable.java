// Copyright (c) Konrad Grzanek
// Created 19.07.19
package koJ.unchecked;

import org.jetbrains.annotations.NotNull;

public interface UncheckedRunnable extends Runnable {

  static void unchecked(@NotNull UncheckedRunnable body) {
    body.run();
  }

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
