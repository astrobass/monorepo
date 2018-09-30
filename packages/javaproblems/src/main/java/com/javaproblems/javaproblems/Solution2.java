import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.rules.*;

public class Solution2 {
  public static String problemStatement = "This problem was asked by Uber. Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i. For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6]. Follow-up: what if you can't use division?";

  public static int[] missingProduct(int[] input) {
    int[] result = new int[input.length];
    int product = 1;

    for( int i=0; i<input.length; i++ ) {
      product *= input[i];
    }

    for( int j=0; j<input.length; j++ ) {
      result[j] = product/input[j];
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(problemStatement);
    System.out.println();

    JUnitCore.main("Solution2");
  }

  @Rule
  public TestRule watcher = new TestWatcher() {
    protected void starting(Description description) {
      System.out.println();
      System.out.println();
      System.out.println("Starting test: " + description.getMethodName());
    }

    protected void succeeded(Description description) {
      System.out.println();
      System.out.println("  " + description.getMethodName() + " succeeded.");
    }

    protected void failed(Description description) {
      System.out.println();
      System.out.println("  " + description.getMethodName() + " failed.");
    }
  };

  @Test
  public void testFiveNumbers() {
    int[] input = {1, 2, 3, 4, 5};
    int[] result = missingProduct(input);
    int[] answer = {120, 60, 40, 30, 24};
    Assert.assertArrayEquals(result, answer);
  }

  @Test
  public void testThreeNumbers() {
    int[] input = {3, 2, 1};
    int[] result = missingProduct(input);
    int[] answer = {2, 3, 6};
    Assert.assertArrayEquals(result, answer);
  }
}
