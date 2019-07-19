package koJ;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelayTest {

  @Test
  void doit() {
    assertEquals(Delay.doit(3), 4);
  }
}
