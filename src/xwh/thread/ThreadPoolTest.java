package xwh.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
         
        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            cachedThreadPool.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
            executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    	*/
		
		 
        //ExecutorService threadPool = Executors.newCachedThreadPool();		// 使用缓存，但个数不定
        ExecutorService threadPool = Executors.newFixedThreadPool(3);  	// 定长线程个数
        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            threadPool.execute(myTask);
        }
        
        
        
        System.out.println("shutdown");		// shutdown并不是马上停止，
        threadPool.shutdown();
        //threadPool.shutdownNow();		// shutdownDow会打断正在执行的线程
	}
}


class MyTask implements Runnable {
   private int taskNum;
    
   public MyTask(int num) {
       this.taskNum = num;
   }
    
   @Override
   public void run() {
       System.out.println("正在执行task "+taskNum+", "+Thread.getAllStackTraces().size());
       try {
    	   Random rdm = new Random();
           Thread.currentThread().sleep(rdm.nextInt(6000));
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("task "+taskNum+"执行完毕");
   }
}
