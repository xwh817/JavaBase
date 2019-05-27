package xwh.thread;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class ProducerConsumer {

    private static boolean isRunning = false;
    private static int MAX = 5; // 仓库容量
    private static int size = 0; // 仓库当前大小
    private static Random rdm = new Random();
    private static List<Producer> mProducers = new ArrayList<>();
    private static List<Consumer> mConsumers = new ArrayList<>();

    public static void main(String[] args) {

        isRunning = true;

        for(int i=1; i<=3; i++) {
            mProducers.add(new Producer("生产者" +i));
        }

        for(int i=1; i<=3; i++) {
            mConsumers.add(new Consumer("消费者" +i));
        }

        for (Producer producer : mProducers) {
            new Thread(producer).start();
        }

        for (Consumer consumer : mConsumers) {
            new Thread(consumer).start();
        }

    }

    /**
     * 理解wait notify成对出现：
     * 操作对象的锁时，要先获得锁，所以要像下面这样synchronized获得对象锁。
     * 而不是简单认为丢到同步块里面就可以了。
     * 
     * notify之后从wait阻塞的地方继续执行，理清流程。
     * 
     * 如果有多个线程对同一个变量进行读写，必须要进行同步操作
     *   例如下面的size变量。在所有对size进行读写的地方进行同步。
     */
    static class Producer implements Runnable {
        public String name;

        public Producer(String name) {
            this.name = name;
        }

        public void run() {
            while (isRunning) {
                try {
                    boolean isFull = false;
                    synchronized(ProducerConsumer.class){
                        isFull = size>=MAX;
                    }

                    if (isFull) {
                        log(name + ": 仓库已满");

                        synchronized(Consumer.class) {
                            Consumer.class.notifyAll();
                        }

                        synchronized(Producer.class) {
                            Producer.class.wait();
                        }
                        
                    }

                    synchronized(ProducerConsumer.class){
                        size++;
                        log(name + ": 生产+1 -> " + size);
                    }
 
                    Thread.sleep(rdm.nextInt(3000)); // 生产间隔时间
                        
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class Consumer implements Runnable {
        public String name;
        public Consumer(String name) {
            this.name = name;
        }

        public void run() {
            while (isRunning) {
                try {
                    boolean isEmpty = false;
                    synchronized(ProducerConsumer.class){
                        isEmpty = size<=0;
                    }
                    if (isEmpty) {
                        log(name + ": 仓库空了");

                        synchronized(Producer.class) {
                            Producer.class.notifyAll();
                        }

                        synchronized(Consumer.class) {
                            Consumer.class.wait();
                        }

                    }

                    synchronized(ProducerConsumer.class){
                        size--;
                        log(name + ": 消费-1 -> " + size);
                    }
                
                    Thread.sleep(rdm.nextInt(3000)); // 消费间隔
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }

    public static void log(String log) {
        System.out.println(log);
    }
}