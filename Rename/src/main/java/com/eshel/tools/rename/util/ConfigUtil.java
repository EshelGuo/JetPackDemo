package com.eshel.tools.rename.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 保存配置至文件工具
 */
public class ConfigUtil {
	
	public static final String DEFAULT_NAME_STRING = "config.properties";
	Properties properties = new Properties();
	private File file;
	private FileOutputStream fos;
	
	public ConfigUtil(){
		this(DEFAULT_NAME_STRING);
	}
	public ConfigUtil(String configName){
		try {
			file = new File(JarUtil.getJarFile(), configName);
			if(!file.exists() || !file.isFile())
				file.createNewFile();
			
			properties.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ConfigUtil put(String key, String value){
		properties.setProperty(key, value);
		return this;
	}
	
	public ConfigUtil put(String key, int value){
		put(key, String.valueOf(value));
		return this;
	}
	
	public ConfigUtil put(String key, boolean value){
		put(key, String.valueOf(value));
		return this;
	}
	
	public void save(){
		try {
			if(fos == null)
				fos = new FileOutputStream(file);
			
			properties.store(fos, "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getInt(String key){
		try {
			return Integer.valueOf(getString(key));
		} catch (Exception e) {
			return 0;
		}
	}
	
	public boolean getBoolean(String key){
		try {
			return Boolean.valueOf(getString(key));
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getString(String key){
		return properties.getProperty(key);
	}
}
