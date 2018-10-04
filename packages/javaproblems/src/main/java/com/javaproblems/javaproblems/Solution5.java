import javafx.util.Pair;
import org.junit.*;
import org.junit.runner.*;
import org.junit.rules.*;

public class Solution5 {
  public static String problemStatement = "Good morning! Here's your coding interview problem for today.\n" +
    "This problem was asked by Jane Street.\n" +
    "cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element\n" +
    " of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.\n" + 
    "Given this implementation of cons:\n" + 
    "def cons(a, b):\n" + 
    "    def pair(f):\n" + 
    "        return f(a, b)\n" + 
    "    return pair\n" + 
    "Implement car and cdr.";

  public static void main(String[] args) {
    System.out.println(problemStatement);

    JUnitCore.main("Solution5");
  }

  public Pair<Integer, Integer> cons(int a, int b) {
    Pair<Integer, Integer> pair = new Pair<>(a, b);
    return pair;
  }

  public Integer car(Pair<Integer, Integer> pair) {
    return pair.getKey();
  }

  public Integer cdr(Pair<Integer, Integer> pair) {
    return pair.getValue();
  }

  @Test
  public void testCar() {
    Assert.assertEquals(new Integer(3), car(cons(3, 4))); 
  }

  @Test
  public void testCdr() {
    Assert.assertEquals(new Integer(4), cdr(cons(3, 4))); 
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
