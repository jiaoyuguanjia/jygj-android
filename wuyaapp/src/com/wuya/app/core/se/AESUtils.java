package com.wuya.app.core.se;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import android.text.TextUtils;

/**
 * 用户敏感信息AES加密工具类
 * 
 */
public class AESUtils {

	/**
	 * 加密算法
	 */
	private static final String CRYPTOGRAPHIC_ALGORITHM = "AES";

	/**
	 * 加密字符编码
	 */
	private static final String CRYPTOGRAPHIC_CHARSETN = "utf-8";

	/**
	 * 随机数算法
	 */
	 private static final String SECURE_RANDOM_ALGORITHM = "SHA1PRNG";

	/**
	 * 加解密key
	 */
	private static byte[] key;

	private AESUtils() {
	}

	//private static final String AesKey = "MKO9N7A8BU3I2SW5";

	private static final String seed = "3cb2a75669c5810a46110cc0322c00e1";

	/*static {
		try {
			SecureRandom secureRandom = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM);
			secureRandom.setSeed(AesKey.getBytes("UTF-8"));

			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128, secureRandom);

			SecretKey secretKey = kgen.generateKey();
			key = secretKey.getEncoded();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * 加密器本地线程变量
	 */
	private static ThreadLocal<Cipher> ecipherThreadLocal = new ThreadLocal<Cipher>() {
		public Cipher initialValue() {
			Cipher ecipher = null;
			try {
				key = HexStringUtils.parseHexStr2Byte(seed);
				if (key == null) {
					throw new Exception("key is null,please have a check");
				}

				SecretKeySpec sks = new SecretKeySpec(key,
						CRYPTOGRAPHIC_ALGORITHM);
				ecipher = Cipher.getInstance(CRYPTOGRAPHIC_ALGORITHM);// 创建加密密码器
				ecipher.init(Cipher.ENCRYPT_MODE, sks);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ecipher;
		}
	};

	/**
	 * 解密器本地线程变量
	 */
	private static ThreadLocal<Cipher> dcipherThreadLocal = new ThreadLocal<Cipher>() {
		public Cipher initialValue() {
			Cipher dcipher = null;
			try {
				key = HexStringUtils.parseHexStr2Byte(seed);
				if (key == null) {
					throw new Exception("key is null,please have a check");
				}

				SecretKeySpec sks = new SecretKeySpec(key,
						CRYPTOGRAPHIC_ALGORITHM);
				dcipher = Cipher.getInstance(CRYPTOGRAPHIC_ALGORITHM);// 创建解密密码器
				dcipher.init(Cipher.DECRYPT_MODE, sks);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dcipher;
		}
	};

	/**
	 * AES加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @return
	 */
	public static String encrypt(String content) {
		if (TextUtils.isEmpty(content)) {
			return null;
		}

		content = content.trim();// 去除前后空格

		try {
			Cipher ecipher = ecipherThreadLocal.get();// 获取当前线程的加密器
			if (ecipher == null) {
				throw new NullPointerException("ecipher is null");
			}
			byte[] byteContent = content.getBytes(CRYPTOGRAPHIC_CHARSETN);
			byte[] result = null;
			result = ecipher.doFinal(byteContent);
			return HexStringUtils.parseByte2HexStr(result); // 16进制的转换
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * AES解密
	 * 
	 * @param content
	 *            需要解密的内容
	 * @return
	 */
	public static String decrypt(String content) throws Exception {
		if (TextUtils.isEmpty(content)) {
			return null;
		}

		Cipher dcipher = dcipherThreadLocal.get();// 获取当前线程的解密器
		if (dcipher == null) {
			throw new NullPointerException("dcipher is null");
		}

		byte[] contentTemp = Base64Encoder.decode(content,
				Base64Encoder.DEFAULT); // 将16进制字符串变为加密字符串
		byte[] result = null;
		result = dcipher.doFinal(contentTemp);
		return new String(result, CRYPTOGRAPHIC_CHARSETN);
	}
}
