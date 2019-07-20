// Copyright (c) Konrad Grzanek
// Created 2019-07-19
package koJ;

import java.util.function.Supplier;

@FunctionalInterface
public interface UncheckedSupplier<T> extends Supplier<T> {

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
