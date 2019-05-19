package xwh.datastruct;

public class WaitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final WaitTest test = new WaitTest();
		new Thread(){
			public void run() {
				test.testWait();
			};
		}.start();
		
		new Thread(){
			public void run() {
				test.testWait();
			};
		}.start();
		

		new Thread(){
			public void run() {
				test.testNotify();
			};
		}.start();
		
		
		
		
	}

	
	public synchronized void testWait(){
		System.out.println("something before");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("after");
		
	}
	
	public synchronized void testNotify(){
		try {
			Thread.sleep(3000);
			this.notifyAll();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
