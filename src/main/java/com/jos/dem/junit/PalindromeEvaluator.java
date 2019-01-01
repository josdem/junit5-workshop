package com.jos.dem.junit;

import java.util.stream.IntStream;

public class PalindromeEvaluator {

  public boolean isPalindrome(String word){
    String temp  = word.toLowerCase();
    return IntStream.range(0, temp.length() / 2)
      .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
  }

}
