package com.eshel.tools.rename.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 获取Jar包所在文件路径
 */
public class JarUtil {

	public static String getJarFilePath(){
		String path = JarUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		try {
			path = URLDecoder.decode(path,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return path;
	}
	public static File getJarFile(){
		return new File(getJarFilePath());
	}
	public static File getJarParentDir(){
		return getJarFile().getParentFile();
	}
}
