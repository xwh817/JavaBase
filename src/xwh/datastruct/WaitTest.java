package xwh.datastruct;

public class WaitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final WaitTest test = new WaitTest();
		new Thread() {
			public void run() {
				test.testWait();
			};
		}.start();

		new Thread() {
			public void run() {
				test.testWait();
			};
		}.start();

		new Thread() {
			public void run() {
				test.testNotify(2000);
			};
		}.start();
		
		
		
		
		
	}

	private int count;
	
	public synchronized void testWait(){
		count++;
		System.out.println("something before, wait: " + count);
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("after, " + count);
		
	}
	
	public synchronized void testNotify(long timeAfter){
		try {
			Thread.sleep(timeAfter);
			count--;
			this.notify();
			
			count--;
			this.notify();
			//this.notifyAll();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
