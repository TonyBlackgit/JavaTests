package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicIntegerTest {
    public static void main(String[] args) {
        final AtomicInteger a = new AtomicInteger(1);
        System.out.println("Before test(AtomicInteger) : a = " + a);
        test(a);
        System.out.println("After test(AtomicInteger) : a = " + a);
    }
    public static void test(AtomicInteger a) {
        a.getAndAdd(1);
        System.out.println("In test(AtomicInteger) : a = " + a);
    }
}
