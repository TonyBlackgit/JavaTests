package basic;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {
  public static void main(String[] args) {
    LambdaTest l = new LambdaTest();
    l.externalIter();
    l.internalIter();
  }

  public void externalIter(){
    long start = System.currentTimeMillis();
    List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
    for(int i : nums){
      System.out.print(i);
    }
    System.out.println();
    long end = System.currentTimeMillis();
    System.out.println("externalIter Cost time: " + (end-start));
  }

  public void internalIter(){
    long start = System.currentTimeMillis();
    List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
    nums.forEach((Integer value) -> System.out.print(value));
    System.out.println();
    long end = System.currentTimeMillis();
    System.out.println("internalIter Cost time: " + (end-start));
  }
}
