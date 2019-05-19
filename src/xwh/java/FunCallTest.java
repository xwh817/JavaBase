package xwh.java;

public class FunCallTest{

    static class Parent{

    }
    static class Child extends Parent{

    }

    private void fun(Parent p){
        System.out.println("call by parent");
    }
    private void fun(Child c){
        System.out.println("call by child");
    }


    private void fun(char c){
        System.out.println("call by char");
    }
    private void fun(int i){
        System.out.println("call by int");
    }
    private void fun(long l){
        System.out.println("call by long");
    }
    

    public static void main(String[] args) {
        FunCallTest test = new FunCallTest();
        Parent p = new Child();
        test.fun(p);	// call by parent
        test.fun((Child)p);	// call by child

        test.fun(1);
        test.fun('1');  // 如果把fun(char c)去掉，它会去寻找最相近的。
    }
}