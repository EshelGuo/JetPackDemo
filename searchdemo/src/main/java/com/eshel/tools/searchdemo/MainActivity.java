package com.eshel.tools.searchdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TextWatcher {

	private EditText et;
	private RecyclerView rv;
	private SearchAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et = findViewById(R.id.et);
		rv = findViewById(R.id.rv);

		mAdapter = new SearchAdapter(this, Data.getInstance().getSource());
		rv.setLayoutManager(new LinearLayoutManager(this));
		rv.setAdapter(mAdapter);
		et.addTextChangedListener(this);
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {

	}

	@Override
	public void afterTextChanged(Editable s) {
		mAdapter.updateKeyword(s.toString());
	}
}
