// Copyright (c) Konrad Grzanek
// Created 22.07.19
package koJ;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

import static koJ.unchecked.UncheckedDoubleSupplier.unchecked;
import static koJ.unchecked.UncheckedIntSupplier.unchecked;
import static koJ.unchecked.UncheckedLongSupplier.unchecked;
import static koJ.unchecked.UncheckedSupplier.unchecked;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class UncheckedBench {

  @Benchmark
  public void passBench(MyState state, Blackhole blackhole) {
    long l = state.l;
    blackhole.consume(l);
  }

  @Benchmark
  public void passUncheckedSupplierWithLongBench(MyState state, Blackhole blackhole) {
    Long l = unchecked(() -> Long.valueOf(state.l));
    blackhole.consume(l);
  }

  @Benchmark
  public void passUncheckedSupplierWithStringBench(MyState state, Blackhole blackhole) {
    String s = unchecked(() -> state.s);
    blackhole.consume(s);
  }

  @Benchmark
  public void passUncheckedIntSupplierBench(MyState state, Blackhole blackhole) {
    int i = unchecked(() -> state.i);
    blackhole.consume(i);
  }

  @Benchmark
  public void passUncheckedLongSupplierBench(MyState state, Blackhole blackhole) {
    long l = unchecked(() -> state.l);
    blackhole.consume(l);
  }

  @Benchmark
  public void passUncheckedDoubleSupplierBench(MyState state, Blackhole blackhole) {
    double d = unchecked(() -> state.d);
    blackhole.consume(d);
  }

  @State(Scope.Thread)
  public static class MyState {
    final long l = 1;
    final double d = 3.14;
    final int i = 1;
    final String s = "a";
  }
}
