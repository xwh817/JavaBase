package xwh.java;

public class WaitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final WaitTest test = new WaitTest();


		new Thread() {
			public void run() {
				test.testSleep(1000);
			};
		}.start();

		new Thread() {
			public void run() {
				test.testSleep(2000);
			};
		}.start();

		/* new Thread() {
			public void run() {
				test.testNotify(2000);
			};
		}.start(); */
		
		
		
		
		
	}

	private int count;
	
	/**
	 * wait之后，会释放锁，其他的线程可以进去
	 */
	public synchronized void testWait(){
		count++;
		System.out.println("before wait: " + count);
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//count--;
		System.out.println("after, " + count);
		
	}

	
	/**
	 * sleep之后，不会释放锁，其他的线程等待sleep结束
	 */
	public synchronized void testSleep(long length){
		count++;
		System.out.println("before sleep: " + count);
		try {
			Thread.sleep(length);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count--;
		System.out.println("after sleep, " + count);
		
	}

	
	

	/**
	 * sleep和wait的区别：
	 * sleep不释放锁，wait会释放锁。从代码执行可以看到，虽然wait代码处于同步块，但是可以有多个线程进入wait状态。
	 * 
	 * 还有个现象，notify并不是马上去唤醒的，而是等出了synchronized代码块才去的。
	 * 那是因为synchronized！！！进行同步加锁了。
	 * 另一个点是：如果在同步块里面sleep，不会释放锁，所以notify后面的代码进不去。
	 */
	public synchronized void testNotify(long timeAfter){
		try {
			System.out.println("sleep:" + timeAfter);
			Thread.sleep(timeAfter);
			
			count--;
			this.notify();

			System.out.println("sleep:" + timeAfter);
			Thread.sleep(timeAfter);

			count--;
			this.notify();
			//this.notifyAll();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
