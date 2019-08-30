// Copyright (c) kongra
// Created 18.07.19
package koJ;

import koJ.unchecked.UncheckedSupplier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Supplier;

public final class Delay<T> implements Supplier<T>, Deref<T>, Pending {

  private volatile T value;
  private volatile Throwable exception;
  private volatile Supplier<T> supplier;

  @Contract(pure = true)
  private Delay(Supplier<T> supplier) {
    this.supplier = supplier;
  }

  @NotNull
  @Contract(value = "_ -> new", pure = true)
  public static <T> Delay<T> delay(Supplier<T> supplier) {
    return new Delay<>(supplier);
  }

  @NotNull
  @Contract(value = "_ -> new", pure = true)
  public static <T> Delay<T> delayUnchecked(UncheckedSupplier<T> supplier) {
    return new Delay<>(supplier);
  }

  @Override
  public T deref() {
    if (supplier != null) {
      synchronized (this) {
        //double check
        if (supplier != null) {
          try {
            value = supplier.get();
          } catch (Throwable t) {
            exception = t;
          }
          supplier = null;
        }
      }
    }
    if (exception != null)
      throw Objects.requireNonNull(Utils.sneakyThrow(exception));

    return value;
  }

  @Override
  public T get() {
    return deref();
  }

  @Override
  public boolean isRealized() {
    return supplier == null;
  }

  @NotNull
  @Override
  public String toString() {
    return "Delay{" +
        "pending=" + isPending() +
        ", value=" + (isPending() ? "..." : String.valueOf(value))
        + '}';
  }

  @Contract(value = "null -> false", pure = true)
  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Delay<?> delay = (Delay<?>) o;
    return Objects.equals(deref(), delay.deref());
  }

  @Override
  public final int hashCode() {
    return Objects.hash(deref());
  }

}
