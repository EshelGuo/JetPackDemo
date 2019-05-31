package com.eshel.frame.app;

/**
 * createBy Eshel
 * createTime: 2019/4/28 00:11
 * desc: 窗口, 控件基础属性
 */
public class Frame {

	public static final int WRAP_CONTENT = -1;
	public static final int MATCH_PARENT = -2;

	protected int width;
	protected int height;

	protected int paddingLeft;
	protected int paddingRight;
	protected int paddingTop;
	protected int paddingBottom;

	protected Context context;

	public Frame(Context context) {
		this.context = context;
	}

	public void setPadding(int padding){
		paddingLeft = paddingRight = paddingTop = paddingBottom = padding;
	}

	public void setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom){
		this.paddingLeft = paddingLeft;
		this.paddingRight = paddingRight;
		this.paddingTop = paddingTop;
		this.paddingBottom = paddingBottom;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getPaddingLeft() {
		return paddingLeft;
	}

	public int getPaddingRight() {
		return paddingRight;
	}

	public int getPaddingTop() {
		return paddingTop;
	}

	public int getPaddingBottom() {
		return paddingBottom;
	}

	public int getLeft(){
		return getPaddingLeft();
	}

	public int getTop(){
		return getPaddingTop();
	}

	public int getRight(){
		return getWidth() - getPaddingRight();
	}

	public int getBottom(){
		return getHeight() - getPaddingBottom();
	}
}
