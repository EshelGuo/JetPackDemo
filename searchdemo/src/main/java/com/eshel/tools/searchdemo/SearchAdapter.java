package com.eshel.tools.searchdemo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eshel.tools.lifecycle.ActivityHelper;
import com.eshel.tools.lifecycle.ActivityLifecycleAdapter;
import com.eshel.tools.lifecycle.ActivityLifecycleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * createBy Eshel
 * createTime: 2019/5/9 09:54
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

	private List<SearchHolder> source;
	private List<SearchHolder> datas;
	private SearchTask mTask;

	public SearchAdapter(FragmentActivity activity, List<String> datas) {
		source = new ArrayList<>(datas.size());
		for (String data : datas) {
			source.add(new SearchHolder(data));
		}
		this.datas = new ArrayList<>(source);
		mTask = new SearchTask();

		ActivityHelper.registerActivityLifecycle(activity, new ActivityLifecycleAdapter() {
			@Override
			public void onActivityDestroyed(Activity activity) {
				if(mTask != null) {
					mTask.close();
					mTask = null;
				}
			}
		});
	}

	public void updateKeyword(String keyword){
		mTask.search(keyword, source, new Runnable() {
			@Override
			public void run(List<SearchHolder> result) {
				datas = result;
				notifyDataSetChanged();
			}
		});
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
		return new ViewHolder(viewGroup.getContext());
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
		viewHolder.tv.setText(datas.get(position).text);
	}

	@Override
	public int getItemCount() {
		if(datas == null)
			return 0;
		return datas.size();
	}

	static class ViewHolder extends RecyclerView.ViewHolder{

		TextView tv;
		public ViewHolder(Context context) {
			super(View.inflate(context, android.R.layout.simple_list_item_1, null));
			tv = (TextView) itemView;
		}
	}
}
