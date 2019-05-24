package xwh.java;

public abstract class AbstractTest{

    /**
     * 可以有main函数，也可以执行
     * 不过只能执行static函数，因为不能实例化对象。
     * @param args
     */
    public static void main(String[] args) {
        test2();
    }

    public void test1(){
        System.out.println("Test1");
    }

    public static void test2(){
        System.out.println("Test2");
    }

    protected abstract void test3();
}