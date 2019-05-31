package com.eshel.frame.app;

import com.eshel.frame.view.View;
import com.eshel.frame.view.ViewGroup;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * createBy Eshel
 * createTime: 2019/4/28 00:10
 * desc: TODO
 */
public class Window extends Frame{

	public String title;
	private JFrame mWindow;
	private JPanel mPanel;
	private ViewGroup root;

	public Window(Context context) {
		super(context);
		setWidth(500);
		setHeight(500);
	}

	public void create(){
		mWindow = WindowUtil.showWindow(getWidth(), getHeight(), Gravity.CENTER, title);
		mWindow.setResizable(false);
		mPanel = new JPanel();
		mPanel.setLayout(null);
		mPanel.setBounds(getLeft(), getTop(), getRight(), getBottom());
		mPanel.setBackground(Color.white);
	}

	public void show(){
		mWindow.add(mPanel);
		mWindow.setVisible(true);
	}

	public void setRoot(ViewGroup vg) {
		root = vg;
		mPanel.removeAll();
		root.layout(mPanel, getLeft(), getTop(), getRight(), getBottom());
	}
}
