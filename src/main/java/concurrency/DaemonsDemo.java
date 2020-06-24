package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class SimpleDaemon implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread() + " " + this);//use Thread.currentThread() to print explicit information of current thread
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
class DaemonThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
public class DaemonsDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for(int i=0;i<4;i++){
            exec.execute(new SimpleDaemon());
        }
        System.out.println("start test");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
