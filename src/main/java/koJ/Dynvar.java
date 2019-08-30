// Copyright (c) Konrad Grzanek
// Created 21.07.19
package koJ;

import koJ.unchecked.UncheckedRunnable;
import koJ.unchecked.UncheckedSupplier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.function.Supplier;

public final class Dynvar<T> implements Deref<T> {

  private final ThreadLocal<ArrayDeque<T>> localStacks =
      ThreadLocal.withInitial(ArrayDeque::new);
  private final T initValue;

  private Dynvar(T initValue) {
    this.initValue = initValue;
  }

  @NotNull
  @Contract("_ -> new")
  public static <T> Dynvar<T> initially(T value) {
    return new Dynvar<>(value);
  }

  @Override
  public T deref() {
    var stack = localStacks.get();
    return stack.isEmpty() ? initValue : stack.peek();
  }

  public <S> S binding(T value, @NotNull Supplier<S> supplier) {
    var stack = localStacks.get();
    stack.push(value);
    try {
      return supplier.get();
    } finally {
      stack.pop();
    }
  }

  public void binding(T value, @NotNull Runnable body) {
    var stack = localStacks.get();
    stack.push(value);
    try {
      body.run();
    } finally {
      stack.pop();
    }
  }

  public <S> S bindingUnchecked(T value, @NotNull UncheckedSupplier<S> supplier) {
    var stack = localStacks.get();
    stack.push(value);
    try {
      return supplier.get();
    } finally {
      stack.pop();
    }
  }

  public void bindingUnchecked(T value, @NotNull UncheckedRunnable body) {
    var stack = localStacks.get();
    stack.push(value);
    try {
      body.run();
    } finally {
      stack.pop();
    }
  }
}
