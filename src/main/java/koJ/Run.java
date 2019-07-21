// Copyright (c) kongra
// Created 18.07.19
package koJ;

import java.util.List;
import java.util.stream.Collectors;

public class Run {

  public static void main(String... args) {
    List<String> letters = List.of("A", "B", "C");
    List<Integer> lens = letters
        .stream()
        .map(String::length)
        .collect(Collectors.toList());
    System.out.println("It works! " + lens.getClass() + " " +
        letters.getClass());
  }

}
