package com.eshel.frame.app;

import com.eshel.frame.Config;
import com.eshel.frame.utils.Log;

public class MainProcedure {

	public static final String TAG = MainProcedure.class.getSimpleName();

	public static void main(String args[]){
		Log.i(TAG, "main procedure started");
		Config.init();
		Class<? extends Activity> launchClass = Manifest.getInstance().getLaunchActivity();
		try {
			Activity activity = launchClass.newInstance();
			activity.create();
			activity.start();
		} catch (InstantiationException | IllegalAccessException e) {
			Log.e(TAG, "", e);
		}
	}
}
