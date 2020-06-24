package basic;

import java.util.concurrent.atomic.LongAdder;

public class StringTest {

  public static void main(String[] args) {
    String s = new String("1");

    String s2 = "1";
    s.intern();
    System.out.println(s == s2);

    String s3 = new String("1") + new String("1");
//    上边这一句等价于下边这些
//    StringBuilder sb = new StringBuilder("1");
//    sb.append("1");
//    String s3 = sb.toString();
    s3.intern();
    String s4 = "11";
    System.out.println(s3 == s4);
  }
}
