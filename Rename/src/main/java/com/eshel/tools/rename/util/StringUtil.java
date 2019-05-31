package com.eshel.tools.rename.util;

public class StringUtil {
	/**
	 * һ��Ϊ���򷵻� true
	 * ȫ���ǿշ��� false
	 * @param values
	 * @return
	 */
	public static boolean isHaveEmpty(String ... values){
		if(values == null)
			return true;
		for (String value : values) {
			if(value == null || value.equals(""))
				return true;
		}
		return false;
	}
	/**
	 * ȫ���ǿշ��� true
	 * @param values
	 * @return
	 */
	public static boolean isAllEmpty(String ... values){
		if(values == null)
			return true;
		for (String value : values) {
			if(value != null && !value.equals(""))
				return false;
		}
		return true;
	}
}
