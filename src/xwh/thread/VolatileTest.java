package xwh.thread;

public class VolatileTest {

    public static void main(String[] args) throws InterruptedException {
        //test1();
        test2();
    }

    /**
     * 修改和打印并发执行 预测可能的结果： a=1, b=2 a=3, b=3 但是出现了： a=1, b=3 加了volatile之后，就不会出现a=1,
     * b=3的情况了。
     * 
     * 下面的判断条件代码，居然打印出了a=3,b=3的情况。 不控制并发，各种奇葩问题都可能出现。
     * 
     */
    /*
     * private volatile int a = 1; private volatile int b = 2;
     */
    private int a = 1;
    private int b = 2;

    private void change() {
        a = 3; // a被改成3了，但是又没有同步到主内存
        b = a; //
    }

    private void print() {
        // System.out.println("a=" + a + ", b=" + b);
        if (a == 1 && b == 2) {

        } else if (a == 3 && b == 3) {

        } else {
            System.out.println("a=" + a + ", b=" + b);
        }
    }

    private static void test1() {

        int i = 0;
        while (i < 10000) {
            i++;

            VolatileTest test = new VolatileTest();

            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                test.print();
            }).start();

            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                test.change();
            }).start();
        }

    }

    static class MyThread implements Runnable {
        private boolean flag = false;

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            flag = true;    // 被修改之后，如果volatile为true，就马上同步到主内存，其他线程可见。
            System.out.println("flag = true");
        }

        public boolean getFlag() {
            return flag;
        }
    }

    /**
     * 例子2的原理是： 一个线程在死循环里面不停地检测flag 另外一个线程将flag修改为true
     * 如果不加volatile，那么检测线程对另一个线程的修改不可见，无法跳出死循环。
     * 
     * 还有一点是，如果加了sleep，等sleep完了之后回来，访问到的变化是更新了的。
     * 说明纯死循环，那个变量值一直没法更新。
     * 
     * @throws InterruptedException
     */
    private static void test2() throws InterruptedException {
        MyThread thread = new MyThread();
        new Thread(thread).start();
        while(true) {
            //Thread.sleep(100);
            if (thread.getFlag()) {
                System.out.println("flat被改为true，结束循环");
                break;
            }
        }
    }

}