// Copyright (c) kongra
// Created 18.07.19
package koJ;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Utils {

  @Contract(value = " -> fail", pure = true)
  private Utils() {
    throw new AssertionError();
  }

  /**
   * Throw even checked exceptions without being required
   * to declare them or catch them. Suggested idiom:
   * <p>
   * <code>throw sneakyThrow( some exception );</code>
   */
  @NotNull
  @Contract("null -> fail")
  static RuntimeException sneakyThrow(Throwable t) {
    // http://www.mail-archive.com/javaposse@googlegroups.com/msg05984.html
    if (t == null) throw new NullPointerException();
    Utils.sneakyThrow0(t);
    return new RuntimeException();
  }

  @Contract("_ -> fail")
  @SuppressWarnings("unchecked")
  static private <T extends Throwable> void sneakyThrow0(Throwable t) throws T {
    throw (T) t;
  }
}
