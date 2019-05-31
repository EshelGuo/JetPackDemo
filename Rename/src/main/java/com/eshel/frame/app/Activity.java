package com.eshel.frame.app;

import com.eshel.frame.view.View;
import com.eshel.frame.view.ViewGroup;

/**
 * createBy Eshel
 * createTime: 2019/4/28 00:17
 */
public abstract class Activity implements Lifeclcle{

	protected Window mWindow;

	public void setTitle(String title){
		mWindow.title = title;
	}

	public Activity() {
		mWindow = new Window(new Context());
	}

	public void onConfig(){
		mWindow.setWidth(500);
		mWindow.setHeight(400);
		mWindow.setPadding(10);
	}

	public void setContentLayout(ViewGroup root){
		mWindow.setRoot(root);
	}

	@Override
	public void onCreate() {

	}

	@Override
	public void onStart() {

	}

	@Override
	public void onResume() {

	}

	@Override
	public void onPause() {

	}

	@Override
	public void onStop() {

	}

	@Override
	public void onDestory() {

	}

	void create() {
		onConfig();
		mWindow.create();
		onCreate();
	}

	public void start() {
		mWindow.show();
		onStart();
	}
}
