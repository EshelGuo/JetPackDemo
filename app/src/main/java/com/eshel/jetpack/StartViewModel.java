package com.eshel.jetpack;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.icu.text.TimeZoneNames;
import android.os.Handler;
import android.os.Looper;

import java.util.Timer;
import java.util.TimerTask;

/**
 * createBy Eshel
 * createTime: 2019/4/29 11:07
 * desc: TODO
 */
public class StartViewModel extends ViewModel{

	private ObservableField<String> text;

	private final MutableLiveData<String> _data = new MutableLiveData<>();
	private int time = 0;
	private Handler mHandler = new Handler(Looper.getMainLooper());
	private final LiveData<Integer> mTimeNS;
	private final LiveData<Integer> switchLiveData;

	public StartViewModel() {

		text = new ObservableField<>("");
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				_data.setValue(++time + "s");
				mHandler.postDelayed(this, 1000);
			}
		}, 1000);

		mTimeNS = Transformations.map(_data, new Function<String, Integer>() {
			@Override
			public Integer apply(String input) {
				return Integer.valueOf(input.substring(0, input.length() - 1));
			}
		});

		switchLiveData = Transformations.switchMap(_data, new Function<String, LiveData<Integer>>() {

			private MutableLiveData<Integer> mResult;

			@Override
			public LiveData<Integer> apply(String input) {
				Integer time = Integer.valueOf(input.substring(0, input.length() - 1));
				if (time % 10 == 0) {
					if(mResult == null)
						mResult = new MutableLiveData<>();
					mResult.postValue(time);
					return mResult;
				}
				return null;
			}
		});

		
	}

	public void setText(String text) {
		this.text.set(text);
	}

	public ObservableField<String> getText() {
		return text;
	}

	public LiveData<String> getData() {
		return _data;
	}

	public LiveData<Integer> getTimeNS() {
		return mTimeNS;
	}

	public LiveData<Integer> getSwitchLiveData() {
		return switchLiveData;
	}
}
