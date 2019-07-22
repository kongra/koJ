// Copyright (c) Konrad Grzanek
// Created 22.07.19
package koJ.unchecked;

import org.jetbrains.annotations.NotNull;

import java.util.function.IntSupplier;

@FunctionalInterface
public interface UncheckedIntSupplier extends IntSupplier {

  static int unchecked(@NotNull UncheckedIntSupplier supplier) {
    return supplier.getAsInt();
  }

  int getAsIntThrowing() throws Throwable;

  @Override
  default int getAsInt() {
    try {
      return getAsIntThrowing();
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }
}
