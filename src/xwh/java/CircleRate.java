package xwh.java;

import java.util.Random;

/**
 * 通过概率计算圆周率
 */
public class CircleRate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		randomTest();
	}


	public static void getPi(){

		int total = 0;
		int count = 0;

		Random rdm = new Random();
		while (total<Integer.MAX_VALUE) {
			double x = rdm.nextDouble() * 2-1;
			double y = rdm.nextDouble() * 2-1;

			double distance = Math.sqrt(x * x + y * y);
			if (distance < 1) {
				count++;
			}
			total++;
			
			if(total%1000000==0){
				double rate = 4.0*count/total;
				System.out.println(total+","+count+","+rate);
			}

		}
	}

	public static void randomTest() {
		/**
		 * 伪随机数
		 * 只要种子确定后，每次产生的序列就是固定的。
		 */
		for (int i=0;i<3;i++) {
			Random rdm = new Random(1);
			for (int j=0;j<5;j++) {
				System.out.print(rdm.nextInt() + ", ");
			}
			System.out.println();
		}

		/**
		 * 如果不传种子seed,代码会每次更新种子的时候是使用的CAS来更新的，
		 * 如果高并发的环境下，性能是个问题。jdk建议大家尽量要使用 SecureRandom 来实现随机数的生成。
		 * 
		 */
		
	}

}
