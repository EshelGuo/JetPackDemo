package com.eshel.tools.rename.util;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/**
 * 提取错误信息
 */
public class Error {

	public static String getTrack(Throwable throwable){
		StringBuilder sb = new StringBuilder();
		sb.append(throwable.toString());
		sb.append("\n");
		StackTraceElement[] stackTrace = throwable.getStackTrace();
		if(stackTrace != null){
			for (StackTraceElement stackTraceElement : stackTrace) {
				sb.append("\tat ");
				sb.append(stackTraceElement.toString());
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
	public static String getExceptionMsg(Throwable e){
		StringBuilder sb = new StringBuilder();
		sb.append("msg:");
		sb.append(e.getMessage());
		sb.append("\r\n");
		StackTraceElement[] stackTrace = e.getStackTrace();
		for (int i = stackTrace.length - 1; i >= 0; i--) {
			sb.append(stackTrace[i]);
			sb.append("\r\n");
		}
		return sb.toString();
	}
}
