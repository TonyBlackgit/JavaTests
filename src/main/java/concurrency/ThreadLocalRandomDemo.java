package concurrency;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomDemo {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      Player player = new Player();
      player.start();
    }
  }
}
class Player extends Thread {
  private final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
  @Override
  public void run() {
//      System.out.println(getName() + ": " + ThreadLocalRandom.current().nextInt(100));
    System.out.println(getName() + ": " + RANDOM.nextInt(100));
  }
}