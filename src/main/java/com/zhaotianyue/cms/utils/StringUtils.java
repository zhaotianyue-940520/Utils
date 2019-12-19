package com.zhaotianyue.cms.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	/**
	 *  随机字符串源
	 */
	static char charArray[] =new char[36];
	static {
		for (int i = 0; i < 10; i++) {
			charArray[i]=(char)('0'+i);
		}
		for (int i = 0; i < 26; i++) {
			charArray[i+10]=(char)('A'+i);
		}
	}
	/**
	 * 判断一个字符串是否为空，空字符串也认为是的空
	 * @param str
	 * @return 为空返回true  否则返回false
	 */
	public static boolean isBlank(String str) {
		return str==null||"".equals(str.trim());
	}
	/**
	 * 判断一个字符串时间否有值 
	 * @param str   
	 * @return 非空返回true  空字符串或空返回false
	 */
	public static boolean hasValue(String str) {
		return !(str==null||"".equals(str.trim()));
	}
	/**
	 * 判断是否是手机号
	 * @param str   
	 * @return 是手机号返回true  不是手机号返回false
	 */
	public static boolean isPhone(String str) {
		String regex="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		boolean matches = m.matches();
		return matches;
	}
	/**
	 * 判断手机号码是否为数值，是否长度为11位，开始位必须是1.
	 * @param src
	 * @return b
	 */
	public static boolean isNumber(String src){
		String regex="^\\d+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(src);
		boolean b = m.matches();
		return b;
	}
	/**
	 * 判断手机号码是否为数值，是否长度为11位，开始位必须是1.
	 * @param src
	 * @return b
	 */
	public static boolean judgeTelephoneIsOk(String src){
		String regex="^[1]\\d{10}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(src);
		boolean b = m.matches();
		return b;
	}

	/**
	 * 判断是否是邮箱
	 * @param str   
	 * @return 是邮箱返回true  不是邮箱返回false
	 */
	public static boolean isEmail(String str) {
		String regex="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		boolean matches = m.matches();
		return matches;
	}
	/**
	 * 随机英文字符串
	 * @param n   
	 * @return 
	 */
	public static String randomStr(int n) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <n; i++) {
			char randomChar = (char) ('a'+random.nextInt(26));
			sb.append(randomChar);
		}
		return sb.toString();
	}
	/**
	 * 获取英文和数字组合的字符串
	 * @param n
	 * @return
	 */
	public static String randomStrNum(int n) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int index =  random.nextInt(36);
			char randomChar = charArray[index];
			sb.append(randomChar);
		}
		return sb.toString();
	}
	/**
	 * 获取随机字符串 长度2为n
	 * @param n
	 * @return 
	 * @throws UnsupportedEncodingException 
	 */
	public static String getGbk(int n){
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getGbk());
		}
		return sb.toString();
	}
	
	/**
	 * 随机获取一个中文汉字
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private static String getGbk(){
		
		byte word[] = new byte[2];
		//  0x1A   0x1A+94
		Random random = new Random();
		word[0] = (byte)(0xA1 + 16 + random.nextInt(39));
		word[1] = (byte)(0xA1  + random.nextInt(94));
		try {
			return new String(word,"GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
