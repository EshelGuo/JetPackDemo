package com.eshel.tools.searchdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * createBy Eshel
 * createTime: 2019/5/9 09:46
 * desc: TODO
 */
public class Data {

	private static Data INSTANCE;
	private Data(){}
	public static Data getInstance(){
	    if(INSTANCE == null){
	        synchronized (Data.class){
	            if(INSTANCE == null)
	                INSTANCE = new Data();
	        }
	    }
	    return INSTANCE;
	}

	public static void destory(){
	    INSTANCE = null;
	}

	private List<String> dataSource;

	private void create(){
		if(dataSource != null)
			return;
		dataSource = new ArrayList<>(50);
		dataSource.add("JetPackDemo");
		dataSource.add(".gradle");
		dataSource.add(".idea");
		dataSource.add("app");
		dataSource.add("gradle");
		dataSource.add("Rename");
		dataSource.add("searchdemo");
		dataSource.add("build");
		dataSource.add("libs");
		dataSource.add("src");
		dataSource.add("androidTest");
		dataSource.add("main");
		dataSource.add("java");
		dataSource.add("searchdemo");
		dataSource.add("MainActivity");
		dataSource.add("res");
		dataSource.add("drawable");
		dataSource.add("drawable-v24");
		dataSource.add("layout");
		dataSource.add("activity_main.xml");
		dataSource.add("mipmap-anydpi-v26");
		dataSource.add("mipmap-hdpi");
		dataSource.add("mipmap-mdpi");
		dataSource.add("mipmap-xhdpi");
		dataSource.add("mipmap-xxhdpi");
		dataSource.add("mipmap-xxxhdpi");
		dataSource.add("values");
		dataSource.add("AndroidManifest.xml");
		dataSource.add("test");
		dataSource.add(".gitignore");
		dataSource.add("build.gradle");
		dataSource.add("proguard-rules.pro");
		dataSource.add("searchdemo.iml");
		dataSource.add(".gitignore");
		dataSource.add("build.gradle");
		dataSource.add("gradle.properties");
		dataSource.add("gradlew");
		dataSource.add("gradlew.bat");
		dataSource.add("hs_err_pid3632.log");
		dataSource.add("hs_err_pid9304.log");
		dataSource.add("hs_err_pid12664.log");
		dataSource.add("JetPackDemo.iml");
		dataSource.add("jetpack笔记.txt");
		dataSource.add("local.properties");
		dataSource.add("settings.gradle");
	}

	public List<String> getSource(){
		create();
		ArrayList<String> dest = new ArrayList<>(dataSource.size());
		dest.addAll(dataSource);
		return dest;
	}

}
