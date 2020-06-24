package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class ArrayListTest {
    public static void main(String[] args) {
        //ArrayList不是线程安全的，使用以下不能产生从0-19的数
//        List<String> list = new ArrayList<>(3);
        //使用CopyOnArrayList则可以，因为add的时候会首先复制一个新的数组,添加到新的数组成功后才会替换掉原来的数组，并且整个过程是加锁的
        List<String> list = new CopyOnWriteArrayList<String>();
        list.add("dog");
        list.add("cat");
        ExecutorService executor = new ThreadPoolExecutor(2, 2, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        executor.execute(() -> {
            for(int i=0; i<10; i++){
                list.add(Integer.toString(i));
                Iterator<String> it = list.iterator();
                while(it.hasNext()){
                    System.out.println(it.next());
                }
                System.out.println();
            }
        });
        executor.execute(() -> {
            for(int i=10; i<20; i++){
                list.add(Integer.toString(i));
                Iterator<String> it = list.iterator();
                while(it.hasNext()){
                    System.out.println(it.next());
                }
                System.out.println();
            }
        });
        if(executor != null){
            executor.shutdown();
        }
    }
}
