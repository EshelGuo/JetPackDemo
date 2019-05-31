package com.eshel.frame.view;

import com.eshel.frame.app.Context;
import com.eshel.frame.app.Frame;

import javax.management.loading.MLet;

/**
 * createBy Eshel
 * createTime: 2019/4/28 09:42
 * desc: TODO
 */
public class View extends Frame {

	protected ViewGroup.LayoutParams mLayoutParams;

	public void setLayoutParams(ViewGroup.LayoutParams layoutParams){
		mLayoutParams = layoutParams;
	}

	public<LP extends ViewGroup.LayoutParams> LP getLayoutParams(){
		return (LP) mLayoutParams;
	}

	public View(Context context) {
		super(context);
	}
}
