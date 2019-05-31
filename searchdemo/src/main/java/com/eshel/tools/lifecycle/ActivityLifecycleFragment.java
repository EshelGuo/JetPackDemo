package com.eshel.tools.lifecycle;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * createBy Eshel
 * createTime: 2019/5/9 15:45
 * desc: TODO
 */
public class ActivityLifecycleFragment extends Fragment{
//	final AtomicReference<ArrayList<ActivityLifecycle>> mCallbacks = new AtomicReference<ArrayList<ActivityLifecycle>>(new ArrayList<>(5));
	private List<ActivityLifecycle> mCallbacks = new ArrayList<>(5);

	public ActivityLifecycleFragment() {
	}

	public ActivityLifecycleFragment addCallback(ActivityLifecycle callbacks) {
		mCallbacks.add(callbacks);
		return this;
	}

	public ActivityLifecycleFragment removeCallback(ActivityLifecycle callbacks){
		mCallbacks.remove(callbacks);
		return this;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		for (ActivityLifecycle callback : mCallbacks) {
			callback.onActivityCreated(getActivity(), savedInstanceState);
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		for (ActivityLifecycle callback : mCallbacks) {
			callback.onActivityResult(getActivity(), requestCode, resultCode, data);
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		for (ActivityLifecycle callback : mCallbacks) {
			callback.onActivityResumed(getActivity());
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		for (ActivityLifecycle callback : mCallbacks) {
			callback.onActivityPaused(getActivity());
		}
	}

	@Override
	public void onStart() {
		super.onStart();
		for (ActivityLifecycle callback : mCallbacks) {
			callback.onActivityStarted(getActivity());
		}
	}

	@Override
	public void onStop() {
		super.onStop();
		for (ActivityLifecycle callback : mCallbacks) {
			callback.onActivityStopped(getActivity());
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		for (ActivityLifecycle callback : mCallbacks) {
			callback.onActivityDestroyed(getActivity());
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		for (ActivityLifecycle callback : mCallbacks) {
			callback.onRequestPermissionsResult(getActivity(), requestCode, permissions, grantResults);
		}
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
		for (ActivityLifecycle callback : mCallbacks) {
			callback.onActivitySaveInstanceState(getActivity(), outState);
		}
	}
}
