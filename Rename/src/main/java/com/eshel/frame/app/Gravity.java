package com.eshel.frame.app;

public class Gravity {
	//十位左右 个位上下
	public static final int CENTER = 11;
	public static final int LEFT = 00;
	public static final int RIGHT = 20;
	public static final int TOP = 00;
	public static final int BOTTOM = 02;
	public static final int CENTER_VERTICAL = 01;
	public static final int CENTER_HORIZONTAL = 10;
	
	public static int getHorizontal(int gravity){
		return gravity / 10 * 10;
	}
	public static int getVertical(int gravity){
		return gravity % 10;
	}
}
