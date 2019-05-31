package com.eshel.jetpack;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.lang.reflect.Constructor;

/**
 * createBy Eshel
 * createTime: 2019/4/29 11:08
 * desc: TODO
 */
public class EndViewModel extends ViewModel{

	private final MutableLiveData<String> data = new MutableLiveData<>();

	public EndViewModel (){
	    data.postValue("Bye!");
	}

	public LiveData<String> getData() {
		return data;
	}
}
