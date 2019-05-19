package xwh.java;

import java.util.Random;

public class CircleRate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

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

}
