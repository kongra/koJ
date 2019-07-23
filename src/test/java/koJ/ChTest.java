package koJ;

import org.junit.jupiter.api.Test;

import static koJ.Ch.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChTest {

  @Test
  void chPos0() {
    chPos(1);
    assertThrows(AssertionError.class, () -> chPos(0));
    assertThrows(AssertionError.class, () -> chPos(-1));
  }

  @Test
  void chPos1() {
    chPos((byte) 1);
    assertThrows(AssertionError.class, () -> chPos((byte) 0));
    assertThrows(AssertionError.class, () -> chPos((byte) -1));
  }

  @Test
  void chPos2() {
    chPos((short) 1);
    assertThrows(AssertionError.class, () -> chPos((short) 0));
    assertThrows(AssertionError.class, () -> chPos((short) -1));
  }

  @Test
  void chPos3() {
    chPos((long) 1);
    assertThrows(AssertionError.class, () -> chPos((long) 0));
    assertThrows(AssertionError.class, () -> chPos((long) -1));
  }

  @Test
  void chNat0() {
    chNat(0);
    chNat(1);
    assertThrows(AssertionError.class, () -> chNat(-1));
    assertThrows(AssertionError.class, () -> chNat(Integer.MIN_VALUE));
  }

  @Test
  void chNat1() {
    chNat((byte) 0);
    chNat((byte) 1);
    assertThrows(AssertionError.class, () -> chNat((byte) -1));
    assertThrows(AssertionError.class, () -> chNat(Byte.MIN_VALUE));
  }

  @Test
  void chNat2() {
    chNat((short) 0);
    chNat((short) 1);
    assertThrows(AssertionError.class, () -> chNat((short) -1));
    assertThrows(AssertionError.class, () -> chNat(Short.MIN_VALUE));
  }

  @Test
  void chNat3() {
    chNat((long) 0);
    chNat((long) 1);
    assertThrows(AssertionError.class, () -> chNat((long) -1));
    assertThrows(AssertionError.class, () -> chNat(Long.MIN_VALUE));
  }

  @Test
  void chRangeInt1() {
    chRange(0, 0, 0);
    chRange(1, 1, 1);
    chRange(0, 2, 0);
    chRange(0, 2, 1);
    chRange(0, 2, 2);
    assertThrows(AssertionError.class, () -> chRange(0, 2, -1));
    assertThrows(AssertionError.class, () -> chRange(0, 2, 3));
    assertThrows(IllegalArgumentException.class, () -> chRange(0, -1, 3));

    var chCustom = chRange(0, 2);
    chCustom.applyAsInt(0);
    chCustom.applyAsInt(1);
    chCustom.applyAsInt(2);

    assertThrows(AssertionError. class, () -> chRange(0, 2).applyAsInt(-1));
    assertThrows(AssertionError. class, () -> chRange(0, 2).applyAsInt(3));
    assertThrows(IllegalArgumentException.class, () -> chRange(0, -1));
  }

  @Test
  void chNonBlank0() {
    chNonBlank("a");
    chNonBlank(" a");
    chNonBlank("a ");
    chNonBlank(" a ");
    assertThrows(AssertionError.class, () -> chNonBlank(null));
    assertThrows(AssertionError.class, () -> chNonBlank(""));
    assertThrows(AssertionError.class, () -> chNonBlank(" "));
    assertThrows(AssertionError.class, () -> chNonBlank("\t"));
    assertThrows(AssertionError.class, () -> chNonBlank("\n"));
  }
}
