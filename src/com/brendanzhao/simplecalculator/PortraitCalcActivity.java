package com.brendanzhao.simplecalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/**
 * This represents the main activity for the calculator app.
 * @author Brendan Zhao
 */
public class PortraitCalcActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.portrait_layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.portrait_calc, menu);
		return true;
	}
}
