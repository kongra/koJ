// Copyright (c) Konrad Grzanek
// Created 22.07.19
package koJ;

import org.jetbrains.annotations.Contract;

public class Ch {

  @Contract(value = " -> fail", pure = true)
  private Ch() {
    throw new AssertionError();
  }

  @Contract(value = "_ -> param1", pure = true)
  public static byte chPos(byte b) {
    if (b > 0) return b;
    throw new AssertionError();
  }

  @Contract(value = "_ -> param1", pure = true)
  public static short chPos(short s) {
    if (s > 0) return s;
    throw new AssertionError();
  }

  @Contract(value = "_ -> param1", pure = true)
  public static int chPos(int i) {
    if (i > 0) return i;
    throw new AssertionError();
  }

  @Contract(value = "_ -> param1", pure = true)
  public static long chPos(long l) {
    if (l > 0) return l;
    throw new AssertionError();
  }

  @Contract(value = "_ -> param1", pure = true)
  public static byte chNat(byte b) {
    if (b >= 0) return b;
    throw new AssertionError();
  }

  @Contract(value = "_ -> param1", pure = true)
  public static short chNat(short s) {
    if (s >= 0) return s;
    throw new AssertionError();
  }

  @Contract(value = "_ -> param1", pure = true)
  public static int chNat(int i) {
    if (i >= 0) return i;
    throw new AssertionError();
  }

  @Contract(value = "_ -> param1", pure = true)
  public static long chNat(long l) {
    if (l >= 0) return l;
    throw new AssertionError();
  }

  @Contract("_ -> param1")
  public static String chNonBlank(String s) {
    if (s == null || s.isBlank()) throw new AssertionError();
    return s;
  }

}
