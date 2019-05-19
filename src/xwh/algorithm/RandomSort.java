package xwh.algorithm;

import java.util.Random;


/**
 * 随机洗牌
 *
 */
public class RandomSort {

	public static void main(String[] args) {
		int[] array = getArray(10);
		print(array);
		randomFun(array);
		print(array);
		
	}
	
	public static int[] getArray(int size){
		int[] array = new int[size]; 
		for(int i=0;i<array.length;i++){
			array[i] = i+1;
		}
		return array;
	}
	
	public static void randomFun(int[] array){
		Random rdm = new Random();
		for(int i=0;i<array.length;i++){
			int index = rdm.nextInt(array.length);
			int temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
	}
	
	public static void print(int[] array){
		StringBuffer str = new StringBuffer("[");
		for(int item : array){
			str.append(item).append(",");
		}
		if(array.length>0){
			str.deleteCharAt(str.length()-1);
		}
		str.append("]");
		
		System.out.println(str);
	}

}
