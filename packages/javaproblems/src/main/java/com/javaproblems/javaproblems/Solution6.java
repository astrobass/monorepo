import org.junit.*;
import org.junit.runner.*;
import org.junit.rules.*;

// Not finished (requires XOR of pointers to previous and next nodes)

public class Solution6 {
  public static String problemStatement = "This problem was asked by Google.\n" +
"An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node. Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.\n" + 
"If using a language that has no pointers (such as Python), you can assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses.";
  
  public static void main(String[] args) {
    System.out.println(problemStatement);
 
    JUnitCore.main("Solution6");
  }

  @Test
  public void test() {
    Assert.assertEquals(1, 1);
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
