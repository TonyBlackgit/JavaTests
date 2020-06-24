package basic;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamTest {
  public static void main(String[] args) {
    Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c")
            .map(s -> {
              System.out.println("map: " + s);
              return s.toUpperCase();
            })
            .filter(s -> {
              System.out.println("filter: " + s);
              return s.startsWith("A");
            });
            stream.forEach(s -> System.out.println("forEach: " + s));
    Arrays.hashCode(new int[]{1,3,4});
  }
}
