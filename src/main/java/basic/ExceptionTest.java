package basic;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ExceptionTest {
  public static void main(String[] args) {
    System.out.println(returnBeforeFinally());
    System.out.println("-------------------------------------------");
    catchException();
  }

  // return之前，会先执行finally语句，然后return
  public static int returnBeforeFinally(){
    final ExceptionCatchFinallyTest e = new ExceptionCatchFinallyTest();
    try{
      e.testWithoutException();
      return 0;
    } finally {
      System.out.println("in finally");
    }
  }
  // catch到异常之后，会继续执行后边的代码，像什么都没有发生一样
  // 但是try块内发生异常语句之后的代码执行不到
  public static void catchException(){
    final ExceptionCatchFinallyTest e = new ExceptionCatchFinallyTest();
    try {
      e.testWithException();
      System.out.println("after exception 语句，执行不到");
    } catch(IOException ioe) {
      System.out.println("catch IOException");
    }
    System.out.println("after catch exception");
  }
}

class ExceptionCatchFinallyTest {
  public void testWithException() throws IOException {
    System.out.println("in testWithException");
    throw new IOException();
  }

  public void testWithoutException(){
    System.out.println("in testWithoutException");
  }
}