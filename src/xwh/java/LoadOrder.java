package xwh.java;

public class LoadOrder {
	
	{
		a=2;
		//System.out.println("a="+a);
		System.out.println("a=2");
	}
	
	
	private int a = 1;
	
	private static int b = 10;
	
	{
		b = 11;
	}


	static{
		System.out.println("static code");
	}
	
	{
		System.out.println("no static code");
	}
	
	
	public LoadOrder() {
		System.out.println("constructor");
		a = 3;
	}
	
	public static void main(String[] args) {
		System.out.println("main");
		
		LoadOrder order = new LoadOrder();
		
		System.out.println("a="+order.a);
		
		//System.out.println("b="+b);
	}
	

	{
		a=4;
		System.out.println("a="+a);
	}
}
