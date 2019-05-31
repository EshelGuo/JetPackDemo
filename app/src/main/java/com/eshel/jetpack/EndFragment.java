package com.eshel.jetpack;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

/**
 * createBy Eshel
 * createTime: 2019/4/29 11:07
 * desc: TODO
 */
public class EndFragment extends Fragment{

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_end, container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
/*		EndViewModel viewModel = ViewModelProviders.of(this).get(EndViewModel.class);
		viewModel.getData().observe(this, new Observer<String>() {
			@RequiresApi(api = Build.VERSION_CODES.KITKAT)
			@Override
			public void onChanged(@Nullable String s) {
				((TextView) Objects.requireNonNull(getView()).findViewById(R.id.text)).setText(s);
			}
		});*/
	}
}
