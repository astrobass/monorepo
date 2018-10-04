import java.util.*;
import org.junit.*;
import org.junit.runner.*;

public class Solution7 {
  public static String problemStatement = "This problem was asked by Facebook. Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded. For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.";

  public static void main( String[] args ) {
    System.out.println();
    System.out.println(problemStatement);
    System.out.println();

    JUnitCore.main("Solution7");
  }

  public char numToChar(String inputString) {
    int input = Integer.parseInt(inputString);
    int output = Character.getNumericValue('a') - 1;
    output = output + input;
    return Character.forDigit(output, 36);
  }

  public void encode(String input, String output) {
    if( input.length() == 0 ) {
      answers.add(output);
      return;
    }
    encode(input.substring(1), output + numToChar(input.substring(0, 1)));
    if( (input.length() >= 2) && Character.isLetter(numToChar(input.substring(0, 2))) ) {
      encode(input.substring(2), output + numToChar(input.substring(0, 2)));
    }
  }

  public List<String> answers = new LinkedList<String>();

  @Test
  public void testThree() {
    String input = "111";
    String output = new String();
    encode(input, output);
    System.out.println(answers.toString());
    Assert.assertEquals("[aaa, ak, ka]", answers.toString());
  }  

  @Test
  public void testFour() {
    String input = "1111";
    String output = new String();
    encode(input, output);
    System.out.println(answers.toString());
    Assert.assertEquals("[aaaa, aak, aka, kaa, kk]", answers.toString());
  }  
}
