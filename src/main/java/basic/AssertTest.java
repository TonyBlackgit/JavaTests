package basic;

import java.util.Arrays;
import java.util.List;

public class AssertTest {
  //默认assert没有开启，所以一下不会报错，若要开启，使用java -ea xxx
  public static void main(String[] args) {
    List<Integer> nums = Arrays.asList(1,2,3,4,5);
    assert nums.get(1) == 1;
    System.out.println(nums.get(0));
  }
}
