package com.eshel.frame.app;

/**
 * createBy Eshel
 * createTime: 2019/4/28 00:20
 * desc: TODO
 */
public class Manifest {

	private volatile static Manifest INSTANCE;
	private Manifest(){}
	public static Manifest getInstance(){
	    if(INSTANCE == null){
	        synchronized (Manifest.class){
	            if(INSTANCE == null)
	                INSTANCE = new Manifest();
	        }
	    }
	    return INSTANCE;
	}

	private Class<? extends Activity> launchActivity;

	public Class<? extends Activity> getLaunchActivity(){
		return launchActivity;
	}

	public void registLaunchActivity(Class<? extends Activity> clazz){
		launchActivity = clazz;
	}
}
