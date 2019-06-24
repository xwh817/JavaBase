import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.lang.Integer;

public class CallableTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> myCallable = new MyCallable();
        FutureTask<Integer> task = new FutureTask<>(myCallable);

        System.out.println("开始执行");
        new Thread(task).start();

        System.out.println("主线程做其他事情");

        Integer result = task.get();    // 主线程会阻塞在这儿等待结果。
        System.out.println("执行完成: " + result);


    }


    static class MyCallable implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for(int i=1; i<=100; i++) {
                sum += i;
                Thread.sleep(30);   // 模拟耗时操作
            }
            return sum;
        }
    }

}