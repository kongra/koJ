// Copyright (c) Konrad Grzanek
// Created 22.07.19
package koJ.unchecked;

import org.jetbrains.annotations.NotNull;

import java.util.function.DoubleSupplier;

@FunctionalInterface
public interface UncheckedDoubleSupplier extends DoubleSupplier {

  static double unchecked(@NotNull UncheckedDoubleSupplier supplier) {
    return supplier.getAsDouble();
  }

  double getAsDoubleThrowing() throws Throwable;

  @Override
  default double getAsDouble() {
    try {
      return getAsDoubleThrowing();
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }
}
