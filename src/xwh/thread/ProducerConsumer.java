package xwh.thread;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class ProducerConsumer {

    private static boolean isRunning = false;
    private static int MAX = 3; // 仓库容量
    private static int size = 0; // 仓库当前大小
    private static Random rdm = new Random();
    private static List<Producer> mProducers = new ArrayList<>();
    private static List<Consumer> mConsumers = new ArrayList<>();

    public static void main(String[] args) {

        isRunning = true;

        mProducers.add(new Producer("生产者1："));
        mProducers.add(new Producer("生产者2："));
        mProducers.add(new Producer("生产者3："));

        mConsumers.add(new Consumer("消费者1："));
        mConsumers.add(new Consumer("消费者2："));


        for(Producer producer : mProducers){
            new Thread(producer).start();
        }

        for(Consumer consumer : mConsumers){
            new Thread(consumer).start();
        }

        
        

    }

    static class Producer implements Runnable {
        public String name;
        public Producer(String name) {
            this.name = name;
        }

        public synchronized void run() {
            while (isRunning) {
                try {
                    if (size >= MAX) {
                        log(name + ": 仓库已满，停止生产。");

                        for(Consumer consumer : mConsumers){
                            consumer.notify();
                        }

                        this.wait();
                    } else {
                        Thread.sleep(rdm.nextInt(5000)); // 生产需要时间
                        log(name + ": 生产 +1");
                        size++;
                    }
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

        public synchronized void run() {
            try {
                while (isRunning) {
                    if (size <= 0) {
                        log(name + ": 仓库空了，停止消费。");
                        
                        for(Producer producer : mProducers){
                            producer.notify();
                        }

                        this.wait();
                    } else {
                        size--;
                        log(name + ": 消费 -1");
                        Thread.sleep(rdm.nextInt(3000)); // 消费间隔
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void log(String log) {
        System.out.println(log);
    }
}