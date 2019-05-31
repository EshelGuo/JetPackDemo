package com.eshel.tools.searchdemo;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static com.eshel.tools.searchdemo.SearchHolder.MAX_MATCHING_RATE;

/**
 * createBy Eshel
 * createTime: 2019/5/9 10:05
 * desc: TODO
 */
public class SearchTask {

	public static final String KEY_KEYWORD = "text";
	public static final String KEY_SOURCE = "source";

	//完全匹配最大OFFSET
	public static final int MAX_OFFSET = 1000;

	private final int MSG_QUIT = -1;
	private final int MSG_SEARCH = 1;


	private Handler mHandler;
	private Handler mMainHandler = new Handler(Looper.getMainLooper());
	public SearchTask() {
		Thread thread = new Thread(){
			@Override
			public void run() {
				createHandler();
				Looper.loop();
//				Looper.myLooper().quitSafely();
			}
		};
		thread.start();
	}

	public void search(String keyword, List<SearchHolder> source, Runnable callback){
		Message msg = Message.obtain();
		msg.what = MSG_SEARCH;
		msg.obj = new Object[]{keyword, source, callback};
		mHandler.sendMessage(msg);
	}

	public void close(){
		Message msg = Message.obtain();
		msg.what = MSG_QUIT;
		mHandler.sendMessage(msg);
	}

	private void createHandler(){
		Looper.prepare();
		mHandler = new Handler(Looper.myLooper()){
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what){
					case MSG_QUIT:
						quit();
						break;
					case MSG_SEARCH:
						Object[] datas = (Object[]) msg.obj;
						String keyword = (String) datas[0];
						List<SearchHolder> source = (List<SearchHolder>) datas[1];
						Runnable callback = (Runnable) datas[2];
						searchInternal(keyword, source, callback);
						break;
				}
			}
		};
	}

	private void searchInternal(String keyword, List<SearchHolder> source, Runnable callback) {
		if(TextUtils.isEmpty(keyword)){
			post(source, callback);
			return;
		}

		if(source == null){
			post(null, callback);
			return;
		}

		final List<SearchHolder> temp = new ArrayList<>(source);
		for (SearchHolder holder : temp) {
			holder.matching_rate = 0;
			// 设置匹配度

			//完全相同
			if(holder.text.equals(keyword)){
				holder.matching_rate = MAX_MATCHING_RATE+1;
				continue;
			}

			//完全匹配
			int index = holder.text.indexOf(keyword);
			if(index != -1){
				holder.matching_rate = 90;
				holder.matching_rate += index*1.0f/MAX_OFFSET;
				continue;
			}

			//完全匹配, 不区分大小写
			int index_ = holder.text.toLowerCase().indexOf(keyword.toLowerCase());
			if(index_ != -1){
				holder.matching_rate = 80;
				holder.matching_rate += index_*1.0f/MAX_OFFSET;
				continue;
			}

			//部分匹配
			// TODO: 2019/5/9
		}

		//移除匹配度为0的数据
		Iterator<SearchHolder> it = temp.iterator();

		while (it.hasNext()){
			SearchHolder next = it.next();
			if(next.matching_rate == 0)
				it.remove();
		}

		//重新排序
		Collections.sort(temp, new Comparator<SearchHolder>() {
			@Override
			public int compare(SearchHolder left, SearchHolder right) {
				float temp = left.matching_rate - right.matching_rate;
				int result = 0;
				if(temp > 0)
					result = 1;
				else if(temp < 0)
					result = -1;
				return result;
			}
		});

		post(temp, callback);
	}

	private void post(final List<SearchHolder> result, final Runnable callback){
		mMainHandler.post(new java.lang.Runnable() {
			@Override
			public void run() {
				callback.run(result);
			}
		});
	}

	private void quit() {
		Looper looper = Looper.myLooper();
		if(looper == null)
			return;

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
			looper.quitSafely();
		}else {
			looper.quit();
		}
	}
}
