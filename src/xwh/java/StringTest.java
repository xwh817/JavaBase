package xwh.java;

public class StringTest{
    public static void main(String[] args) {
        String s1 = "abc";  // 存储在方法区的常量池。
        String s2 = "abc";
        String s3 = new String("abc");  // 通过new出的对象实例在堆中。
        
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s3.intern());  // intern从常量池中去取。
    }
}