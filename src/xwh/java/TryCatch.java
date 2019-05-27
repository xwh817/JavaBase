package xwh.java;

public class TryCatch {
    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(test2());
    }

    /**
     * return语句相当于把结果放在返回的暂存区里面。
     * return 语句执行后,将把返回结果放置进函数栈中,此时函数并不是马上返回,它要执行 finally 语句后才真正开始返回。
     */
    static int test() {
        int x = 0;
        try {
            x = 1;
            System.out.println("return: " + x);
            return x;   // 放入暂存区
        } finally {
            System.out.println("finally: " + x);
            x = 2;      // 对x进行操作，但没有放入暂存区
            System.out.println("finally: " + x);
        }
    }

    static int test2() {
        int x = 0;
        try {
            x = 1;
            return x;
        } finally {
            x = 2;
            return x;
        }
    }

}