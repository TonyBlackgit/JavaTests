package concurrency;

import concurrency.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++)
//            new Thread(new LiftOff()).start();
//        System.out.println("In main Thread");
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            executor.execute(new LiftOff());
        executor.shutdown();
        System.out.println("In main Thread");
    }
}
