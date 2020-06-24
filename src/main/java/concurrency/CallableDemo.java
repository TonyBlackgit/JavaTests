package concurrency;

import jdk.nashorn.internal.codegen.CompilerConstants;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.*;

class TaskWithResult implements Callable<String>{
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    public String call(){
        return "result of task "+id;
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> result = new ArrayList<>();
        for(int i=0;i<5;i++){
            result.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs : result){
            try{
                if(fs.isDone())
                    System.out.println(fs.get());
            }catch (InterruptedException ie){
                System.out.println(ie.getStackTrace());
            }catch (ExecutionException ee){
                ee.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }
    }
}
