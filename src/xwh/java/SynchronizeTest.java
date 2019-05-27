package xwh.datastruct;

public class SynchronizeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final SynchronizeTest test = new SynchronizeTest();
		
		/**
		 * synchronized默认是加在了对象上面
		 */
		new Thread(){
			public void run() {
				test.fun1();
			};
		}.start();
		

		new Thread(){
			public void run() {
				test.fun2();
			};
		}.start();

		new Thread(){
			public void run() {
				test.fun3();
			};
		}.start();
		
		
		/**
		 * 指定加在哪个对象上面
		 */
		String str = "test";
		synchronized (str) {
			
		}
		
	}
	
	
	public synchronized void fun1(){
		System.out.println("fun1");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void fun2(){
		System.out.println("fun2");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void fun3(){
		System.out.println("fun3");
	}
	

}
