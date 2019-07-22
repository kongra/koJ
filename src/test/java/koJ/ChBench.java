// Copyright (c) Konrad Grzanek
// Created 22.07.19
package koJ;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

import static koJ.Ch.chNonBlank;
import static koJ.Ch.chPos;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ChBench {

  @Benchmark
  public static void chPosBench(MyState state, Blackhole blackhole) {
    long l = chPos(state.l);
    blackhole.consume(l);
  }

  @Benchmark
  public static void chNonBlank1Bench(MyState state, Blackhole blackhole) {
    String s = chNonBlank(state.s1);
    blackhole.consume(s);
  }

  @Benchmark
  public static void chNonBlank2Bench(MyState state, Blackhole blackhole) {
    String s = chNonBlank(state.s2);
    blackhole.consume(s);
  }

  @Benchmark
  public static void chNonBlank3Bench(MyState state, Blackhole blackhole) {
    String s = chNonBlank(state.s3);
    blackhole.consume(s);
  }

  @Benchmark
  public static void chNonBlank4Bench(MyState state, Blackhole blackhole) {
    String s = chNonBlank(state.s4);
    blackhole.consume(s);
  }

  @Benchmark
  public static void chNonBlank5Bench(MyState state, Blackhole blackhole) {
    String s = chNonBlank(state.s5);
    blackhole.consume(s);
  }

  @Benchmark
  public static void chNonBlank6Bench(MyState state, Blackhole blackhole) {
    String s = chNonBlank(state.s6);
    blackhole.consume(s);
  }

  @State(Scope.Thread)
  public static class MyState {
    public String s1 = "a";
    public String s2 = " a";
    public String s3 = "a ";
    public String s4 = " a ";
    public String s5 = "A very long string with a lot of elements" +
        "inside of it usbdyfbusdybf yubsdfyu vyusvdf uyvsd uvy";

    public String s6 = " ".repeat(200) + s5;

    public long l = 1;
  }

}
