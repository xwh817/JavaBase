package xwh.datastruct;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set set = new HashSet();
		
		
		/**
		 * String是一个特殊的Final对象，有自己实现的equals和hashCode值，
		 * equals=true则hashCode相等，查看String的hashCode源码可知
		 * 
		 * String ==的特殊性，字符串常量的概念
		 */
		//String obj1 = "a"+"bc"+" ";
		String obj1 = "abc ";
		obj1 = obj1.trim();
		//Object obj2 = "abc";
		Object obj2 = "abc";
		
		System.out.println("hashCode:"+obj1.hashCode()+","+obj2.hashCode());
		System.out.println("==:"+(obj1==obj2));
		System.out.println("equals:"+obj1.equals(obj2));
		
		set.add(obj1);
		set.add(obj2);
		
		System.out.println("set size:"+set.size());
		
		
		/**
		 * 得出的结论是：
		 * 1. equals和hashCode之间以及和==之间没有绝对的联系，两个可以自己去实现
		 * 2. 如果是两个不同的物理对象，==肯定是false
		 * 3. 只有equals和hashCode都相等的时候，HashMap\HashTable\Set这样的集合才认为他们是同一个对象。
		 */
		
		MyObj myObj1 = new MyObj("xwh", 817);
		MyObj myObj2 = new MyObj("dh", 817);
		System.out.println("\nhashCode:"+myObj1.hashCode()+","+myObj2.hashCode());
		System.out.println("==:"+(myObj1==myObj2));
		System.out.println("equals:"+myObj1.equals(myObj2));	

		set.clear();
		set.add(myObj1);
		set.add(myObj2);
		
		System.out.println("set size:"+set.size());
		
	}
	
	
	static class MyObj{
		String name;
		int value;
		public MyObj(String name, int value){
			this.name = name;
			this.value = value;
		}
		
		@Override
		public boolean equals(Object obj) {
			/* if(obj instanceof MyObj){
				return ((MyObj) obj).value ==this.value;
			}else {
				return false;
			} */
			return false;
		}
		
		@Override
		public int hashCode() {
			//return name.hashCode();
			return value;
		}
	}

}
