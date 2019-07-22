// Copyright (c) Konrad Grzanek
// Created 22.07.19
package koJ;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Optional;

public class NonBlank implements Deref<String> {

  private final String s;

  @Contract(pure = true)
  private NonBlank(@NotNull String s) {
    this.s = s;
  }

  @NotNull
  @Contract(value = "_ -> new", pure = true)
  public static Optional<NonBlank> valueOf(String s) {
    if (s == null || s.isBlank())
      return Optional.empty();

    return Optional.of(new NonBlank(s));
  }

  @Override
  public String deref() {
    return s;
  }

  @Override
  public String toString() {
    return deref();
  }

  @Contract(value = "null -> false", pure = true)
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NonBlank nonBlank = (NonBlank) o;
    return s.equals(nonBlank.s);
  }

  @Override
  public int hashCode() {
    return Objects.hash(s);
  }

}
