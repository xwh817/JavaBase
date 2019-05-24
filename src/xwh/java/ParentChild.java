package xwh.java;

import java.io.File;
import java.io.IOException;

public class ParentChild {
    
    static class Parent {
        protected int fun() throws IOException{
            return 1;
        }
        protected Parent getObj(){
            return new Parent();
        }
        
        public void testClassName(){
            System.out.println(super.getClass().getName());
        }
    }

    static class Child extends Parent {

        /**
         * 1. 子类方法的访问权限只能和父类相同或更大,不能更小。
         * 2. 只能比父类抛出更少的异常,或者是抛出父类抛出的异常的子异常
         * 3. 返回基本类型必须和父类相同，例如这儿改成short和long都报错
         * 4. 返回对象可以是子类
         */
        @Override
        public int fun() throws IOException{
            return 2;
        }

        @Override
        public Child getObj() {
            return new Child();
        }

        public void testClassName(){
            // getClass是final的，super的和this的相同
            System.out.println(super.getClass().hashCode());
            System.out.println(this.getClass().hashCode());
            System.out.println(super.getClass().getSimpleName());
            System.out.println(this.getClass().getSuperclass().getSimpleName());
        }
    }


    public static void main(String[] args) {
        Parent p = new Child();

        //System.out.println(p.getClass().getName());
        //System.out.println(p.getClass().getSuperclass().getName());
        p.testClassName();
    }
}