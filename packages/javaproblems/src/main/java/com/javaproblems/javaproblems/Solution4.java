import java.util.Arrays;
import org.junit.*;
import org.junit.runner.*;
import org.junit.rules.*;

public class Solution4 {
  public static final String problemStatement = "This problem was asked by Stripe. Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well. For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3. You can modify the input array in-place.";

  public static void main(String[] args) {
    System.out.println(problemStatement);
    System.out.println();

    JUnitCore.main("Solution4");
  }

  public int getMissingInt(int[] input) {
    System.out.println(Arrays.toString(input));
    int result = input[0];
    int i, j=0;
    int tmp;
    for( i=0; i<input.length; i++ ) {
      if( input[i] < 0 ) {
        tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
        j++;
      }
    }
    System.out.println(Arrays.toString(input));
    for( i=j; i<input.length; i++ ) {
      int num = Math.abs(input[i]);
      if( (j + num - 1 < input.length) && (j + num - 1 >= 0) ) {
        input[j + num - 1] = -input[j + num - 1];
      }
    }
    System.out.println(Arrays.toString(input));
    for( i=j; i<input.length; i++ ) {
      if( input[i] > 0 ) {
        return i - j + 1;
      }
    }
    return input.length;
  }

  @Test
  public void testFourElements() {
    int input[] = {3, 4, -1, 1};
    int result = getMissingInt(input);
    Assert.assertEquals(2, result);
  }

  @Test
  public void testThreeElements() {
    int input[] = {1, 2, 0};
    int result = getMissingInt(input);
    Assert.assertEquals(3, result);
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
}
