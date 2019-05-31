package com.eshel.tools.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * createBy Eshel
 * createTime: 2019/5/9 16:57
 */
public interface ActivityLifecycle extends ActivityLifecycleCallbacks{
	void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data);
	void onRequestPermissionsResult(Activity activity, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);
}
