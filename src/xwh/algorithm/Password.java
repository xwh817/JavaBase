package xwh.algorithm;
import java.security.MessageDigest;

public class Password {

	public static void main(String[] args) {
        String str = "VBLBOZBK";
				System.out.println(str + ":" + getPwd(str));
				
				String test = "123";
				System.out.println(test.split("\\|")[0]);
    }
    
    public static String getPwd(String str){
		int length = 6;
		char c2 = str.charAt(str.length()-1);
		int index = c2 * c2 % (str.length() - length);
		String md5 = encodeMD5(str + index).substring(index, index + length);
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<length;i++) {
			stringBuilder.append(md5.charAt(i) % 10);
		}
		return stringBuilder.toString();
    }
    
    
	/**
	 * MD5 编码
	 */
	public static String encodeMD5(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		return bytes2HexString(byteArray);
	}


	public static String bytes2HexString(byte[] byteArray) {
		if (byteArray == null) {
			return "";
		}
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}


}
