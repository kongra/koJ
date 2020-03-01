// Copyright (c) Konrad Grzanek
// Created 22.07.19
package koJ;

import org.jetbrains.annotations.NotNull;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class StreamsBench {

  @Benchmark
  public static void iterBench(@NotNull MyState state,
                               @NotNull Blackhole blackhole) {
    long sum = 0;
    for (long i = state.start; i < state.n; i++) {
      sum += i;
    }
    state.result = sum;
    blackhole.consume(sum);
  }

  @Benchmark
  public static void streamBench(@NotNull MyState state,
                                 @NotNull Blackhole blackhole) {
    long sum = LongStream.iterate(state.start, i -> i + 1)
        .limit(state.n)
        .reduce(0L, Long::sum);
    state.result = sum;
    blackhole.consume(sum);
  }

  @Benchmark
  public static void iterLongBench(@NotNull MyState state,
                                   @NotNull Blackhole blackhole) {
    Long sum = 0L;
    for (Long i = state.start; i < state.n; i++) {
      sum += i;
    }
    state.result = sum;
    blackhole.consume(sum);
  }

  @Benchmark
  public static void streamLongBench(@NotNull MyState state,
                                     @NotNull Blackhole blackhole) {
    long sum = Stream.iterate(state.start, i -> i + 1)
        .limit(state.n)
        .reduce(0L, Long::sum);
    state.result = sum;
    blackhole.consume(sum);
  }

  @State(Scope.Thread)
  public static class MyState {
    final long start = 200;
    final long n = 300;
    long result = 0;
  }

}
