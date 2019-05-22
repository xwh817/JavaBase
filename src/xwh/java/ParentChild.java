package xwh.java;

import java.io.File;
import java.io.IOException;

public class ParentChild {
    
    class Parent {
        protected int fun() throws IOException{
            return 1;
        }
        protected Parent getObj(){
            return new Parent();
        }
    }

    class Child extends Parent {

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
    }
}