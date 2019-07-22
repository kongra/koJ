// Copyright (c) Konrad Grzanek
// Created 22.07.19
package koJ;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

import static koJ.Ch.chPos;

@BenchmarkMode(Mode.AverageTime)
public class ChBench {

  @Benchmark
  public static long chPosBench() {
    return chPos(1L);
  }

}
