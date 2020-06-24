package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SimplePriority implements Runnable {
    private int priority;
    private int count = 5;
    private volatile double d = 0;

    public SimplePriority(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return Thread.currentThread() + " : " + count;
    }

    @Override
    public void run() {
//        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 10000000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if(i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if (--count == 0) return;
        }
    }
}

public class PriorityDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            exec.execute(new SimplePriority(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriority(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
