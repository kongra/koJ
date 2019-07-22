// Copyright (c) Konrad Grzanek
// Created 22.07.19
package koJ.unchecked;

import org.jetbrains.annotations.NotNull;

import java.util.function.LongSupplier;

@FunctionalInterface
public interface UncheckedLongSupplier extends LongSupplier {

  static long unchecked(@NotNull UncheckedLongSupplier supplier) {
    return supplier.getAsLong();
  }

  long getAsLongThrowing() throws Throwable;

  @Override
  default long getAsLong() {
    try {
      return getAsLongThrowing();
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }
}
