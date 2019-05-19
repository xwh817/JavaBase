package xwh.java;

public class InitTest{

    static {
        a = 2;      // 不报错
        //System.out.println(a);    // 此行报错未定义
    }

    public static int a = 1;

    static class Sub extends InitTest {
        public static int b = a;
    }

    /* static {
        a = 3;
        System.out.println(a);
    } */

    public static void main(String[] args) {
        System.out.println(a);    //  a= 1,不是2
        // 父类先init
        System.out.println(Sub.b);
    }
}