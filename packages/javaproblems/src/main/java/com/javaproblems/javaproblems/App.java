package com.javaproblems.javaproblems;
import java.net.URLClassLoader;
import java.net.URL;
import java.lang.reflect.*;

public class App {
  public static void main( String[] args ) {

    System.out.println();
    if( args.length < 1 ) {
      System.out.println("No problem number specified");
      return;
    }
    String problemNumber = args[0];
    System.out.println("Executing problem #" + problemNumber);
    System.out.println();

    try {
//      String className = "com.javaproblems.javaproblems.Solution" + problemNumber;
      String className = "Solution" + problemNumber;
      Class classToLoad = Class.forName(className);
      Method method = classToLoad.getDeclaredMethod("main",String[].class);
      method.setAccessible(true);
      Object result = method.invoke(null, (Object)args);
    } catch(ClassNotFoundException e) {
      System.out.println("Problem does not exist");
    } catch(InvocationTargetException e) {
      System.out.println(e.getCause());
    } catch(Exception e) {
      System.out.println(e);
    }

    System.out.println();
  }
}
