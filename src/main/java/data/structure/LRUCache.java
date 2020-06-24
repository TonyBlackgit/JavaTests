package data.structure;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LRUCache<S, T> {
  static final long EXPIRE_TIME = 30000;
  // Thread to scan and clean expired nodes.
  private ScheduledExecutorService expireThreadPool =
          new ScheduledThreadPoolExecutor(10);
  // Used to store data.
  private ConcurrentHashMap<S, Node<S, T>> cache =
          new ConcurrentHashMap<>();
  //
  private PriorityQueue<Node<S, T>> expireQueue =
          new PriorityQueue<>((o1, o2) -> {
            long tmp = o1.getExpireTime() - o2.getExpireTime();
            if (tmp > 0) return 1;
            if (tmp < 0) return -1;
            return 0;
          });

  public void start() {
    expireThreadPool.scheduleAtFixedRate((Runnable) () -> {
      long now = System.currentTimeMillis();
      while (true) {
        Node t = expireQueue.peek();
        if (t == null || t.getExpireTime() < now) {
          return;
        }
        cache.remove(t.getKey());
        expireQueue.poll();
      }
    }, 1, EXPIRE_TIME, TimeUnit.MILLISECONDS);
  }

  public synchronized void set(S key, T value) {
    Node<S, T> newNode = new Node<>(key, value);
    Node<S, T> old = cache.put(key, newNode);
    if (old != null) {
      expireQueue.remove(old);
    }
    expireQueue.add(newNode);
  }

  public T get(S key) {
    long now = System.currentTimeMillis();
    Node<S, T> old = cache.get(key);
    if (old == null) {
      return null;
    }
    expireQueue.remove(old);
    old.setExpireTime(now + EXPIRE_TIME);
    expireQueue.add(old);
    return old.getValue();
  }
}

class Node<S, T> {
  private S key;
  private T value;
  private long expireTime;

  public Node(S key, T value) {
    this(key, value, System.currentTimeMillis() + LRUCache.EXPIRE_TIME);
  }

  private Node(S key, T value, long expireTime) {
    this.key = key;
    this.value = value;
    this.expireTime = expireTime;
  }

  public S getKey() {
    return key;
  }

  public T getValue() {
    return value;
  }

  public long getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(long expireTime) {
    this.expireTime = expireTime;
  }
}