package com.eshel.demo;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

	private ImageView mTest;
	private int currentHeight;
	private int currentwidth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		currentHeight  = dp2px(300);

		final int width = dp2px(300);
		currentwidth = width;
		mTest = findViewById(R.id.test);

		mTest.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
//				int width = width;
				int intrinsicWidth = mTest.getDrawable().getIntrinsicWidth();
				Matrix matrix = new Matrix();

				float f = currentwidth*1.0f/intrinsicWidth;
				matrix.postScale(f, f);
				mTest.setImageMatrix(matrix);
//				mTest.getViewTreeObserver().removeOnGlobalLayoutListener(this);
			}
		});

		final int pxHeight = dp2px(600);

		mTest.postDelayed(new Runnable() {
			@Override
			public void run() {
				if(currentHeight >= pxHeight)
					return;
				ViewGroup.LayoutParams layoutParams = mTest.getLayoutParams();
				if(layoutParams == null)
					layoutParams = new ViewGroup.LayoutParams(width, currentHeight);
				currentHeight += 5;
				currentwidth += 1;
				layoutParams.height = currentHeight;
				mTest.setLayoutParams(layoutParams);
				mTest.postDelayed(this, 30);
			}
		}, 1000);
	}

	private int dp2px(int dp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
				getApplication().getResources().getDisplayMetrics());
	}
}
