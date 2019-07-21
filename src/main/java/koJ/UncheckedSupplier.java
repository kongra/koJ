// Copyright (c) Konrad Grzanek
// Created 19.07.19
package koJ;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@FunctionalInterface
public interface UncheckedSupplier<T> extends Supplier<T> {

  static <T> T unchecked(@NotNull UncheckedSupplier<T> supplier) {
    return supplier.get();
  }

  T getThrowing() throws Throwable;

  @Override
  default T get() {
    try {
      return getThrowing();
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
  }
}
