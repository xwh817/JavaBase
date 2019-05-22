package xwh.java;

public class Main{
    public static void main(String[] args) {

        short s1 = 1; 
        s1 = s1++;
        int a = 1;
        short s2 = (short)a;
        short s3 = s1 + s2;     // 自动提升为int，报错
    }


    /**
     * switch
     * Cannot switch on a value of type long. (long型不可以)
     * Only convertible int values, strings or enum variables are permitted
     * int型包括：short,char,byte
     */
    private static void testSwitch(){

        String i = "test";
        switch(i) {
            case "test1":break;
            default:break;
        }
    }
}