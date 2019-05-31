package com.eshel.jetpack;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.eshel.jetpack.databinding.FragmentStartBinding;

import androidx.navigation.Navigation;

/**
 * createBy Eshel
 * createTime: 2019/4/29 11:07
 * desc: TODO
 */
public class StartFragment extends Fragment {
	public static final String TAG = StartFragment.class.getSimpleName();

	private FragmentStartBinding binder;
	private TextView mText;
	private TextView mTv;
	private Button mNavigateBt;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		binder = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false);
		mText = binder.getRoot().findViewById(R.id.text);
		mTv = binder.getRoot().findViewById(R.id.tv);
		mNavigateBt = binder.getRoot().findViewById(R.id.navigate_bt);
		return binder.getRoot();
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		((Button) getView().findViewById(R.id.navigate_bt)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Navigation.findNavController(v).navigate(R.id.end_action);
			}
		});
		StartViewModel vm = ViewModelProviders.of(this).get(StartViewModel.class);
		vm.getData().observe(this, new Observer<String>() {
			@Override
			public void onChanged(@Nullable String s) {
				binder.setStartViewmodel(vm);
//				binder.setVariable(BR.start_viewmodel, vm);
			}
		});
		vm.getTimeNS().observe(this, new Observer<Integer>() {
			@Override
			public void onChanged(@Nullable Integer integer) {
				Toast.makeText(getContext(), "" + integer, Toast.LENGTH_LONG).show();
			}
		});
		vm.getSwitchLiveData().observe(this, new Observer<Integer>() {
			@Override
			public void onChanged(@Nullable Integer integer) {
				mTv.setText(String.valueOf(integer));
				Log.i(TAG, String.valueOf(integer));
			}
		});
//		StartViewModel viewModel = ViewModelProviders.of(this).get(StartViewModel.class);
/*		viewModel.getData().observe(this, new Observer<String>() {
			@RequiresApi(api = Build.VERSION_CODES.KITKAT)
			@Override
			public void onChanged(@Nullable String data) {
				TextView tv = Objects.requireNonNull(getView()).findViewById(R.id.text);
				tv.setText(data);
			}
		});*/
	}
}
