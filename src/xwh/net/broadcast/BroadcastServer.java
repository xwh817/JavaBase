package xwh.net.broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class BroadcastServer {

	public static void main(String[] args) {
		try {
			DatagramPacket receive = new DatagramPacket(new byte[1024], 1024);
	        DatagramSocket server = new DatagramSocket(8888);
	 
	        System.out.println("---------------------------------");
	        System.out.println("Server current start......");
	        System.out.println("---------------------------------");
	 
	        while (true)
	        {
	            server.receive(receive);
	 
	            byte[] recvByte = Arrays.copyOfRange(receive.getData(), 0,
	                    receive.getLength());
	 
	            System.out.println("Server receive msg:" + new String(recvByte));
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
 
	}
}
