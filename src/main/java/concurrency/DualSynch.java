package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DualSynch {
    private Object syncObject = new Object();
    ReentrantLock lock = new ReentrantLock();

    public void f() {
        boolean acquired = lock.tryLock();//如果拿不到，下边的代码还是会执行，要小心使用
//        if(acquired) {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("f()" + i);
                    Thread.yield();
                }
            } finally {
                if (acquired) {
                    lock.unlock();
                }
            }
//        }

    }

    public void g() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("g()" + i);
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final DualSynch dual = new DualSynch();
        new Thread() {
            public void run() {
                dual.g();
            }
        }.start();
        dual.f();
    }
}
