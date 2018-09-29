package com.javaproblems.javaproblems.problem1;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;

public class Solution {
  public static String problemStatement = "This problem was recently asked by Google. Given a list of numbers and a number k, return whether any two numbers from the list add up to k. For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17. Bonus: Can you do this in one pass?";

  public static boolean isAddUp(int[] input, int sum) {
    List<Integer> list = new ArrayList();
    
    for( int i=0; i<input.length; i++ ) {
      int element = input[i];
      if( list.contains(sum-element) ) {
        return true;
      } else {
        list.add(element);
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(problemStatement);
    System.out.println();

    JUnitCore.main("com.javaproblems.javaproblems.problem1.Solution");
  }

  @Test
  public void testOne() {
    int[] input = {10, 15, 3, 7};
    int sum = 17;
    boolean result = isAddUp(input, sum);
    assertEquals("Testing input " + Arrays.toString(input) + " for sum " + sum, result, true);
  }

  @Test
  public void testTwo() {
    int[] input = {10, 15, 3, 7};
    int sum = 30;
    boolean result = isAddUp(input, sum);
    assertEquals("Testing input " + Arrays.toString(input) + " for sum " + sum, result, false);
  }
}
