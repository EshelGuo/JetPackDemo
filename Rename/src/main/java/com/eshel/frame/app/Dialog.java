package com.eshel.frame.app;

import javax.swing.JOptionPane;

public class Dialog {

	public static void showError(String msg){
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE); 
	}
	public static void showSuccess(String msg){
		JOptionPane.showMessageDialog(null, msg, "Success", JOptionPane.DEFAULT_OPTION); 
	}
}
