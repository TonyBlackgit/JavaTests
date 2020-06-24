package basic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest extends RecursiveTask<Integer> {
  private static final int THRESHOLD = 100;
  private int start;
  private int end;

  public ForkJoinTest(int start, int end){
    this.start = start;
    this.end = end;
  }

  protected Integer compute(){
    int sum = 0;
    boolean canComputer = (end - start) <= THRESHOLD;
    //如果任务规模小于 阈值 THRESHOLD 就直接计算
    if(canComputer){
      for(int i = start; i <= end; i++){
        sum += i;
      }
    }else{
      //如果任务大于阈值就裂变为两个子任务
      int middle = (start + end) / 2;
      ForkJoinTest leftTask = new ForkJoinTest(start, middle);
      ForkJoinTest rightTask = new ForkJoinTest(middle + 1, end);
      //执行子任务
      leftTask.fork();
      rightTask.fork();
      int leftResult = leftTask.join();
      int rightResult = rightTask.join();
      //合并子任务
      sum = leftResult + rightResult;
    }
    return sum;
  }

  public static void main(String[] args){
    long startTime = System.currentTimeMillis();
    ForkJoinPool pool = new ForkJoinPool();
    ForkJoinTest task = new ForkJoinTest(1, 10000);
    Future<Integer> result = pool.submit(task);
    try{
      System.out.println("result is: " + result.get());
    }catch(InterruptedException e){
    }catch(ExecutionException e){
    }finally{
      long endTime = System.currentTimeMillis();
      System.out.println("total cost: " + (endTime - startTime));
      pool.shutdown();
    }
  }
}