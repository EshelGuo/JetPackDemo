package com.eshel.frame.app;

/**
 * createBy Eshel
 * createTime: 2019/4/28 00:15
 * desc: TODO
 */
public class Context {

	public void startActivity(Class<? extends Activity> clazz){
		Activity activity;
		try {
			activity = clazz.newInstance();
			activity.create();
			activity.start();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
