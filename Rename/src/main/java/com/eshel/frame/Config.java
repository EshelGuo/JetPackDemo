package com.eshel.frame;

import com.eshel.frame.app.Manifest;
import com.eshel.tools.rename.ui.RenameActivity;

/**
 * createBy Eshel
 * createTime: 2019/4/28 01:15
 * desc: TODO
 */
public class Config {

	public static void init(){
		Manifest.getInstance().registLaunchActivity(RenameActivity.class);
	}
}
