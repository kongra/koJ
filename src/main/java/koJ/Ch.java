// Copyright (c) Konrad Grzanek
// Created 22.07.19
package koJ;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;

public final class Ch {

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

  @Contract(pure = true)
  public static void validateRange(long start, long end) {
    if (start > end) throw new IllegalArgumentException(
        "start > end with start=" + start + ", end=" + end);
  }

  @Contract(pure = true)
  public static void validateRange(int start, int end) {
    if (start > end) throw new IllegalArgumentException(
        "start > end with start=" + start + ", end=" + end);
  }

  @Contract(value = "_, _, _ -> param3", pure = true)
  private static long chRange0(long start, long end, long l) {
    if(start <= l && l <= end) return l;
    throw new AssertionError();
  }

  @Contract(value = "_, _, _ -> param3", pure = true)
  private static int chRange0(int start, int end, int i) {
    if(start <= i && i <= end) return i;
    throw new AssertionError();
  }

  @Contract(pure = true)
  public static long chRange(long start, long end, long l) {
    validateRange(start, end);
    return chRange0(start, end, l);
  }

  @Contract(pure = true)
  @NotNull
  public static LongUnaryOperator chRange(long start, long end) {
    validateRange(start, end);
    return l -> chRange0(start, end, l);
  }

  @Contract(pure = true)
  public static int chRange(int start, int end, int i) {
    validateRange(start, end);
    return chRange0(start, end, i);
  }

  @Contract(pure = true)
  @NotNull
  public static IntUnaryOperator chRange(int start, int end) {
    validateRange(start, end);
    return i -> chRange0(start, end, i);
  }

  @NotNull
  @Contract(value = "null -> fail", pure = true)
  public static String chNonBlank(String s) {
    if (s == null || s.isBlank()) throw new AssertionError();
    return s;
  }

}
