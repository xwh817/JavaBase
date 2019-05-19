package xwh.net.broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPBroadcast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
	        /*
	         * 在Java UDP中单播与广播的代码是相同的,要实现具有广播功能的程序只需要使用广播地址即可, 例如：这里使用了本地的广播地址
	         */
	        InetAddress inetAddr = InetAddress.getByName("255.255.255.255");
	        DatagramSocket client = new DatagramSocket();
	 
			byte[] msg = new String("connection successfully!!!").getBytes();
	        DatagramPacket sendPack = new DatagramPacket(msg, msg.length, inetAddr, 8888);
	 
	        client.send(sendPack);
	        System.out.println("Client send msg complete");
	        client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
