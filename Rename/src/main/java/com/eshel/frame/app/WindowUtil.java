package com.eshel.frame.app;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class WindowUtil {
	
	public static JFrame showWindow(int windowWidth, int windowHeight,int gravity,String title){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = 0;
    	int y = 0;
    	int horizontal = Gravity.getHorizontal(gravity);
    	switch (horizontal) {
			case Gravity.LEFT:
				x = 0;
				break;
			case Gravity.RIGHT:
				x = screenSize.width - windowWidth;
				break;
			case Gravity.CENTER_HORIZONTAL:
				x = (screenSize.width - windowWidth) / 2;
				break;
		}
    	int vertical = Gravity.getVertical(gravity);
    	switch (vertical) {
			case Gravity.TOP:
				y = 0;
				break;
			case Gravity.BOTTOM:
				y = screenSize.height - windowHeight;
				break;
			case Gravity.CENTER_VERTICAL:
				y = (screenSize.height - windowHeight) / 2;
				break;
    	}
    	JFrame window = new JFrame(title);
    	window.setSize(windowWidth, windowHeight);
    	window.setLocation(x, y);
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.setVisible(true);
    	return window;
	}
	
	public static JLabel addTextView(JPanel parent,String text, int x, int y, int width, int height){
		JLabel label = new JLabel(text);
		label.setBounds(x, y, width, height);
    	parent.add(label);
    	return label;
	}
	
	
	public static JRadioButton addRadioButton(JPanel panel, ButtonGroup bg, String text, int x, int y, int width, int height){
		JRadioButton jb = new JRadioButton(text);
		jb.setBounds(x, y, width, height);
		panel.add(jb);
		bg.add(jb);
    	return jb;
	}

	
	public static JTextField addEditText(JPanel parent,String text, int x, int y, int width, int height){
		JTextField edittext = new JTextField(text);
		edittext.setBounds(x, y, width, height);
    	parent.add(edittext);
    	return edittext;
	}
	public static JButton addButton(JPanel parent,String text, int x, int y, int width, int height, ActionListener listener){
		JButton button = new JButton(text);
		button.setBounds(x, y, width, height);
		button.addActionListener(listener);
    	parent.add(button);
    	return button;
	}
	
}
