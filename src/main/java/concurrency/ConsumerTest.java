package concurrency;

import java.util.concurrent.*;

public class ConsumerTest {
    public static void main(String[] args) {
        ConsumerRun cr = new ConsumerRun();
        cr.test();
    }
}
class ConsumerRun{
    Runnable consumer = this::consume;
    private void consume(){
        System.out.println("In consume");
    }

    public void test() {
        ExecutorService executor = null;
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1,10,10000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        try {
            executor = Executors.newFixedThreadPool(5);
            executor.execute(consumer);
            executor.submit(consumer);
        }finally {
            if(executor != null){
                executor.shutdown();
            }
        }
    }
}
