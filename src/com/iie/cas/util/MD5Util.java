package com.iie.cas.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MD5Util {
	/**
	 * @Description: Random generation of a specified length string
	 * @param length
	 * @return String
	 * @throws
	 */
	/*
	 * public static String getRandomString(int length) { //length��ʾ����ַ�ĳ���
	 * String base = "abcdefghijklmnopqrstuvwxyz0123456789"; Random random = new
	 * Random(); StringBuffer sb = new StringBuffer(); for (int i = 0; i <
	 * length; i++) { int number = random.nextInt(base.length());
	 * sb.append(base.charAt(number)); } return sb.toString(); }
	 */

	private static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * 获取任意位的随机字符串(0-9 a-z A-Z)
	 * 
	 * @param size
	 *            位数
	 * @return
	 */
	public static final String getRandomNum(int size) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
		}
		return sb.toString();
	}

	/**
	 * md5加密(ITS)
	 * 
	 * @param str
	 * @param charSet
	 * @return
	 */
	public synchronized static final String getMD5Str(String str, String charSet) { // md5加密
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			if (charSet == null) {
				messageDigest.update(str.getBytes());
			} else {
				messageDigest.update(str.getBytes(charSet));
			}
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
}
