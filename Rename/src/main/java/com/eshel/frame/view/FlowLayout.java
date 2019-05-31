package com.eshel.frame.view;

import com.eshel.frame.app.Context;

import javax.swing.JPanel;

/**
 * createBy Eshel
 * createTime: 2019/4/28 09:49
 * desc: TODO
 */
public class FlowLayout extends ViewGroup{

	private int nowLine = 1;

	public FlowLayout(Context context) {
		super(context);
	}

	public void nextLine(){
		nowLine++;
	}

	@Override
	public void addView(View view) {
		super.addView(view);
		FlowLayout.LayoutParams params = view.getLayoutParams();
		if(params == null) {
			params = new LayoutParams();
			view.setLayoutParams(params);
		}
		params.line = nowLine;
	}

	@Override
	public void layout(JPanel panel, int left, int top, int right, int bottom) {
		super.layout(panel, left, top, right, bottom);
	}

	public static class LayoutParams extends ViewGroup.LayoutParams{
		public int line = -1;
	}
}
