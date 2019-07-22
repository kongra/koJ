// Copyright (c) Konrad Grzanek
// Created 22.07.19
package koJ;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class StreamsBench {

  @Benchmark
  public static void iterBench(MyState state, Blackhole blackhole) {
    long sum = 0;
    for (long i = 0; i < state.n; i++) {
      sum += i;
    }
    state.result = sum;
    blackhole.consume(sum);
  }

  @Benchmark
  public static void streamBench(MyState state, Blackhole blackhole) {
    long sum = LongStream.iterate(1L, i -> i + 1)
        .limit(state.n)
        .reduce(0L, Long::sum);
    state.result = sum;
    blackhole.consume(sum);
  }

  @Benchmark
  public static void iterLongBench(MyState state, Blackhole blackhole) {
    Long sum = 0L;
    for (Long i = 0L; i < state.n; i++) {
      sum += i;
    }
    state.result = sum;
    blackhole.consume(sum);
  }

  @Benchmark
  public static void streamLongBench(MyState state, Blackhole blackhole) {
    long sum = Stream.iterate(1L, i -> i + 1)
        .limit(state.n)
        .reduce(0L, Long::sum);
    state.result = sum;
    blackhole.consume(sum);
  }

  @State(Scope.Thread)
  public static class MyState {
    final long n = 100;
    long result = 0;
  }

}
