// Copyright (c) Konrad Grzanek
// Created 19.07.19
package koJ;

import org.junit.jupiter.api.Test;

import static koJ.Delay.delayUnchecked;
import static koJ.UncheckedRunnable.unchecked;
import static koJ.UncheckedSupplier.unchecked;

class UtilsTest {

  @Test
  void testUnchecked() {
    unchecked(() -> {
      Thread.sleep(50);
      Thread.sleep(50);
    });

    var s = unchecked(() -> {
      Thread.sleep(100);
      return "www";
    });

    System.out.println(s);
  }

  @Test
  void delay() {
    var value = delayUnchecked(() -> {
      Thread.sleep(100);
      System.out.println("Finished long computations and ready to return");
      return 2;
    });

    System.out.println(value);
    System.out.println(value.deref());
    System.out.println(value);
  }

  @Test
  void dynvar() {
    var s = Dynvar.initially("Aaa");
    System.out.println(s.deref());
    s.binding("Bbb", () -> {
      System.out.println(s.deref());
      s.binding("Ccc", () -> {
        System.out.println(s.deref());
      });
      System.out.println(s.deref());
    });
    System.out.println(s.deref());
  }
}
