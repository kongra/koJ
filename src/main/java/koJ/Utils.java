// Copyright (c) kongra
// Created 2019-07-18
package koJ;

public class Utils {

  private Utils() {
    throw new AssertionError();
  }

  /**
   * Throw even checked exceptions without being required
   * to declare them or catch them. Suggested idiom:
   * <p>
   * <code>throw sneakyThrow( some exception );</code>
   */
  public static RuntimeException sneakyThrow(Throwable t) {
    // http://www.mail-archive.com/javaposse@googlegroups.com/msg05984.html
    if (t == null) throw new NullPointerException();
    Utils.sneakyThrow0(t);
    return null;
  }

  @SuppressWarnings("unchecked")
  static private <T extends Throwable> void sneakyThrow0(Throwable t) throws T {
    throw (T) t;
  }
}
