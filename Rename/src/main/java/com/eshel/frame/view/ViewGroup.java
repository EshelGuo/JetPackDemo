package com.eshel.frame.view;

import com.eshel.frame.app.Context;
import com.eshel.frame.app.Frame;

import java.util.LinkedList;

import javax.swing.JPanel;

/**
 * createBy Eshel
 * createTime: 2019/4/28 09:41
 * desc: TODO
 */
public abstract class ViewGroup extends Frame{

	protected LinkedList<View> childs = new LinkedList<>();

	public ViewGroup(Context context) {
		super(context);
	}

	public void addView(View view){
		childs.add(view);
	}

	public void removeView(View view){
		childs.remove(view);
	}

	public void layout(JPanel panel, int left, int top, int right, int bottom){

	}

	public static class LayoutParams{
		public int width;
		public int height;

		public int marginLeft;
		public int marginTop;
		public int marginRight;
		public int marginBottom;
	}

}
