package xwh.java;

/**
 * 内部类
 *
 */
public class InnerClass {

    // 栈溢出
    //private InnerClass instance = new InnerClass();

	public static void main(String[] args) {
		InnerClass t = new InnerClass();
        t.test();

        //t.instance.instance.test();
	}
    
    public void changeValue(Inner inner) {
        inner.change(1);
    }

    private void test(){
        int a = 1;

        /* changeValue(new Inner(){
            @Override
            public void change(int a) {
                a = 2;
            }
        });  */

        //changeValue(a -> {a = 2;});

        new Thread(new Runnable(){
        
            @Override
            public void run() {
                System.out.println("Thread: " + Thread.currentThread().getName());
            }
        }).start();

       /* new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }).start();  */

        System.out.println(a);
    }

    interface Inner{
        void change(int a);
    }
}
