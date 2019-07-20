// Copyright (c) Konrad Grzanek
// Created 2019-07-19
package koJ;

import org.junit.jupiter.api.Test;

import static koJ.Delay.delayUnchecked;

class UtilsTest {

  @Test
  void unchecked() {
    var value = delayUnchecked(() -> {
      Thread.sleep(100);
      System.out.println("Finished long computations and ready to return");
      return 2;
    });

    System.out.println(value);
    System.out.println(value.deref());
    System.out.println(value);
  }
}
