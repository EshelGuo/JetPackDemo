package com.eshel.tools.rename.util;

/**
 * 获取当前操作系统
 */
public class OperatingSystemTypeUtil {
	public static String OS = System.getProperty("os.name").toLowerCase();
	public static SystemType getSystemType(){
		return SystemType.checkSystemType(OS);
	}
	
	public enum SystemType {
		WINDOWS("windows"), MAC("mac"), LINUX("linux"), KNOWN("known");
		private String type;
		SystemType (String type){
			this.type = type;
		}
		public static SystemType checkSystemType(String type){
			SystemType[] values = SystemType.values();
			for (SystemType systemType : values) {
				if(type.indexOf(systemType.type) >= 0)
					return systemType;
			}
			return KNOWN;
		}
	}
}

