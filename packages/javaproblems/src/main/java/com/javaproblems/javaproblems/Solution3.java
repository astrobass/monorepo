import java.util.Scanner;
import org.junit.*;
import org.junit.runner.*;
import org.junit.rules.*;

// Not finished

public class Solution3 {
  public static String problemStatement = "This problem was asked by Google. Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree. For example, given the following Node class\n\n" +
"class Node:\n" +
"    def __init__(self, val, left=None, right=None):\n" +
"        self.val = val\n" +
"        self.left = left\n" +
"        self.right = right\n\n" +
"The following test should pass:\n" +
"node = Node('root', Node('left', Node('left.left')), Node('right'))\n" +
"assert deserialize(serialize(node)).left.left.val == 'left.left'\n";

  public static void main(String[] args) {
    System.out.println(problemStatement);
    System.out.println();

    JUnitCore.main("Solution3");
  }

  public class Node {
    String val;
    Node left;
    Node right;

    public Node(String val) {
      this.val = val;
    }

    public Node(String val, Node left) {
      this.val = val;
      this.left = left;
    }

    public Node(String val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static final char MARKER = '%';

  public String serial(Node node, String output) {
    if( node == null ) {
      output += MARKER;
      return output;
    }
    output += node.val + MARKER;
    output = serial(node.left, output);
    output = serial(node.right, output);

    return output;
  }

  public String serialize(Node node) {
    String output = new String();
    output = serial(node, output);
    return output;
  }

  public boolean first = true;
  public Node rootNode;

  public Node deserial(String input, Node node) {
    if ( (input == null) || (input.equals("")) )
       return node; 

    int index = input.indexOf(MARKER);
    String nodeString = input.substring(0,index);
    input = input.substring(index+1);
    System.out.println(nodeString + " " + input);
    node = new Node(nodeString);
    if( first ) {
      rootNode = node;
      first = false;
    }
    if( node != null ) {
      node = deserial(input, node.left);
    }
    if( node != null ) {
      node = deserial(input, node.right);
    }
    return node;
  }

  public Node deserialize(String input) {
    Node node = deserial(input, null);
    return rootNode;
  }

  @Test
  public void testSerialize() {
    Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));
    Assert.assertEquals("root%left%left.left%%%%right%%%", serialize(node));
  }

  @Test
  public void testSerializeDeserialize() {
    Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));
    node = deserialize(serialize(node));
    System.out.println(node.val);
    Assert.assertEquals("left.left", node.left.val);
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
