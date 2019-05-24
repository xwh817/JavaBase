package xwh.java;

/**
 * 内部类
 *
 */
public class InnerClassTest {

    // 栈溢出
    //private InnerClass instance = new InnerClass();

    private String strTest;

	public static void main(String[] args) {
		InnerClassTest t = new InnerClassTest();
        t.test();

        //t.instance.instance.test();

        //System.out.println(t.test);
        
        InnerClass inner = t.new InnerClass();
        inner.test();

        t.testInner();
        
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

    class InnerClass{
        public static final int test = 1;
        public void test(){
            System.out.println("InnerClass:" + test);
        }
    }

    public void testInner(){
        class InnerClass2{
            public static final int test = 1;
            public void test(){
                System.out.println("InnerClass2:" + test);
            }
        }

        InnerClass2 inner = new InnerClass2();
        inner.test();
    }

    
    public static class staticInner{
        public void test(){
            System.out.println(strTest);    // 静态内部类不可访问外部非static成员变量
        }
    }
    
}
