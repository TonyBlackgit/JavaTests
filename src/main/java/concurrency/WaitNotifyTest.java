package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WaitNotifyTest {
  public static void main(String[] args) throws InterruptedException {
    List<Integer> cache = new ArrayList<>(1);
    Producer p1 = new Producer(cache);
    Producer p2 = new Producer(cache);
    Consumer c1 = new Consumer(cache);
    Consumer c2 = new Consumer(cache);
    ExecutorService es = Executors.newCachedThreadPool();
    es.execute(c1);
    es.execute(c2);
    es.execute(p1);
    es.execute(p2);

//    TimeUnit.MILLISECONDS.sleep(5000);
//    es.shutdownNow();
  }
}

/**
 * Producer, cache size is 1.
 */
class Producer implements Runnable {
  private final List<Integer> cache;
  public Producer(List<Integer> cache) {
    this.cache = cache;
  }

  @Override
  public void run() {
    while (!Thread.interrupted()) {
      produce();
    }
  }

  private void produce() {
    synchronized (cache) {
      try {
        while (cache.size() == 1) {
          cache.wait();
        }
        System.out.println("Producer produce a message.");
        cache.add(ThreadLocalRandom.current().nextInt());
        cache.notify();
      } catch (InterruptedException o) {
        o.printStackTrace();
      }
    }
  }
}

class Consumer implements Runnable {
  private List<Integer> cache;
  public Consumer(List<Integer> cache) {
    this.cache = cache;
  }

  @Override
  public void run() {
    while (!Thread.interrupted()) {
      consume();
    }
  }

  private void consume() {
    synchronized (cache) {
      try {
        while (cache.size() == 0) {
          cache.wait();
        }
        System.out.println("Consumer consume a message.");
        cache.remove(0);
        cache.notify();
      } catch (InterruptedException o){
        o.printStackTrace();
      }
    }
  }
}