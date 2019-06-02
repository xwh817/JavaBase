package xwh.java;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    public static void main(String[] args) {
        Util<Fruit> util = new Util<>();

        Fruit fruit = new Apple("苹果");
        util.print(fruit);


        util.setValue(fruit);
        String str = util.getValue();
        System.out.println(str);

        int i = util.getValue();    // 编译不报错，但是运行会报错
        System.out.println(i);

        List<Apple> apples = new ArrayList();
        // util.printFruit(apples); // 这行会报错
    }

    static class Fruit{
        private String name;
        public Fruit(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return this.name;
        }
    }


    static class Apple extends Fruit{
        public Apple(String name) {
            super(name);
        }
    }

    /**
     * 泛型限定，里面出现的类型T只能是Fruit
     */
    static class Util<T extends Fruit> {
        private T value;
        
        /**
         * 函数泛型
         * 和View.findViewById是一样的写法。
         * R由返回类型确定，外面期望什么类型，这儿就强转什么类型。
         * 另外：T.getClass()或者T.class都是非法的，因为T是泛型变量。由于一个类的类型是什么是在编译期处理的，故不能在运行时直接在Base里得到T的实际类型。
         */
        public <R> R getValue() {
            /* if (R instanceof String) {
                return (R)value.toString();
            } */
            return (R)value.toString(); // 这儿是不安全的
        }

        public void setValue(T value){
            this.value = value;
        }

        public void print(T t) {
            System.out.println(t);
        }

        /**
         * 这儿的参数不能是List<Apple>
         * 要改成下面printAll的写法
         */
        public void printFruit(List<Fruit> list) {
            printAll(list);
        }

        /**
         * ? 表示统配符，表示所有类型都可以。
         * 为什么要用通配符了，
         * 因为：List<Fruit> 不是List<Apple>的父类
         */
        public void printAll(List<? extends Fruit> list) {
            for(Fruit item : list) {
                System.out.println(item);
            }
        }

    }

}