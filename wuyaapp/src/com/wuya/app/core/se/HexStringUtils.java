package com.wuya.app.core.se;


/**
 * 用户敏感信息AES加密工具类（字节转换）
 * 
 * @author wzk
 * @create 2013-10-25
 */
public class HexStringUtils {

	/**
	 * 转化字符串为十六进制编码
	 * 
	 * @param s
	 * @return
	 */
	public static String StringToHex(String s) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			str.append(Integer.toHexString((int) s.charAt(i)));
		}
		return str.toString();
	}

	/**
	 * 转化十六进制编码为字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String HexToString(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(
						s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "utf-8");// UTF-16le:Not
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

	/**
	 * 将16进制转换为二进制 
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	/**
	 * 将二进制转换成16进制 
	 * 
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex);
		}
		return sb.toString();
	}
}
