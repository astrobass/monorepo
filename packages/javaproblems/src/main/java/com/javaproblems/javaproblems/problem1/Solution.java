package com.javaproblems.javaproblems.problem1;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
//import org.junit.*;
//import org.junit.runner.*;

public class Solution {

    // Complete the myMap function below.
    static void addOne(Map<String,Object> myMap) {
        // Iterate through values of myMap
        // If value is ArrayList<String>, append "one" to that ArrayList
        // If value is ArrayList<Integer>, append 1 to that ArrayList
        for( Map.Entry<String,Object> entry : myMap.entrySet() ) {
            ArrayList<Object> value = (ArrayList<Object>)entry.getValue();
            if( value.get(0) instanceof String) {
                value.add("one");
                entry.setValue(value);
            } else {
                value.add(1);
                entry.setValue(value);
            }
        }
    }

    public static void main(String[] args) {
        // Uncomment to run JUnit test case
        //JUnitCore.main("Solution");
        
        ArrayList<String> value1 = new ArrayList<String>();
        value1.add("hello");
        
        ArrayList<Integer> value2 = new ArrayList<Integer>();
        value2.add(123);
        
        Map<String,Object> myMap = new HashMap<String,Object>();
        myMap.put("key1", value1);
        myMap.put("key2", value2);
        
        // Before myMap = { "key1": ["hello"], "key2": [123] }
        System.out.println("Before myMap: " + myMap);
        addOne(myMap);
        // After myMap = { "key1": ["hello", "one"], "key2": [123, 1] }
        System.out.println("After myMap: " + myMap);
    }
    
 /*
   @Test
    public void testOne() {
      ArrayList<String> value1 = new ArrayList<String>();
      value1.add("hello");
      ArrayList<Integer> value2 = new ArrayList<Integer>();
      value2.add(123);
      Map<String,Object> myMap = new HashMap<String,Object>();
      myMap.put("key1", value1);
      myMap.put("key2", value2);

      ArrayList<String> value3 = new ArrayList<String>();
      value3.add("hello");
      value3.add("one");
      ArrayList<Integer> value4 = new ArrayList<Integer>();
      value4.add(123);
      value4.add(1);
      Map<String,Object> answerMap = new HashMap<String,Object>();
      answerMap.put("key1", value1);
      answerMap.put("key2", value2);
      
      addOne(myMap);
      Assert.assertEquals(answerMap, myMap);
    }
*/
}

