package concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerTest implements Runnable {
    private AtomicInteger at = new AtomicInteger(0);
    public int getValue(){
        return at.get();
    }
    private void evenIncrement(){
        at.addAndGet(2);
    }
    @Override
    public void run() {
        while(true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        Timer ter = new Timer();
        ter.schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        }, 5000);
        ExecutorService executor = Executors.newCachedThreadPool();
        TimerTest timerTest = new TimerTest();
        executor.execute(timerTest);
        while (true){
            int val = timerTest.getValue();
            if(val%2!=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
