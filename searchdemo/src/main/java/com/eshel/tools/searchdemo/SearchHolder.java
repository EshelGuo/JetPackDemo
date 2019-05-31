package com.eshel.tools.searchdemo;

public class SearchHolder{
	public static final int MAX_MATCHING_RATE = 100;
	public String text;
	float matching_rate;

	public SearchHolder(String text) {
		this.text = text;
	}
}