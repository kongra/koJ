// Copyright (c) Konrad Grzanek
// Created 19.07.19
package koJ;

import org.junit.jupiter.api.Test;

import static koJ.Delay.delayUnchecked;
import static koJ.UncheckedRunnable.unchecked;
import static koJ.UncheckedSupplier.unchecked;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    assertEquals(s, "www");
  }

  @Test
  void delay() {
    var value = delayUnchecked(() -> {
      Thread.sleep(100);
      return 2;
    });

    assertEquals(value.isPending(), true);
    assertEquals(value.isRealized(), false);
    assertEquals(value.deref(), 2);

    assertEquals(value.isPending(), false);
    assertEquals(value.isRealized(), true);
    assertEquals(value.deref(), 2);
  }

  @Test
  void dynvar() {
    var s = Dynvar.initially("Aaa");
    assertEquals(s.deref(), "Aaa");
    s.binding("Bbb", () -> {
      assertEquals(s.deref(), "Bbb");
      s.binding("Ccc", () -> {
        assertEquals(s.deref(), "Ccc");
      });
      assertEquals(s.deref(), "Bbb");
    });
    assertEquals(s.deref(), "Aaa");
  }
}
