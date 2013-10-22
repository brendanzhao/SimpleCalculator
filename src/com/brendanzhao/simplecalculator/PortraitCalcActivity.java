package com.brendanzhao.simplecalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * This represents the main activity for the calculator app.
 * @author Brendan Zhao
 */
public class PortraitCalcActivity extends Activity implements OnClickListener {

	/**
	 * Represents the value entered before an operator was tapped.
	 */
	private TextView bufferedCalculation;
	
	/**
	 * Represents the value currently being typed.
	 */
	private TextView currentCalculation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.portrait_layout);
		
		bufferedCalculation = (TextView) findViewById(R.id.bufferedcalculation);
		currentCalculation = (TextView) findViewById(R.id.currentcalculation);
		initializeButtons();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.portrait_calc, menu);
		return true;
	}
	
	/**
	 * Sets the on click listeners of every button on the keypad.
	 */
	private void initializeButtons() {
		findViewById(R.id.zero).setOnClickListener(this);
		findViewById(R.id.one).setOnClickListener(this);
		findViewById(R.id.two).setOnClickListener(this);
		findViewById(R.id.three).setOnClickListener(this);
		findViewById(R.id.four).setOnClickListener(this);
		findViewById(R.id.five).setOnClickListener(this);
		findViewById(R.id.six).setOnClickListener(this);
		findViewById(R.id.seven).setOnClickListener(this);
		findViewById(R.id.eight).setOnClickListener(this);
		findViewById(R.id.nine).setOnClickListener(this);
		findViewById(R.id.add).setOnClickListener(this);
		findViewById(R.id.subtract).setOnClickListener(this);
		findViewById(R.id.multiply).setOnClickListener(this);
		findViewById(R.id.divide).setOnClickListener(this);
		findViewById(R.id.squareroot).setOnClickListener(this);
		findViewById(R.id.negative).setOnClickListener(this);
		findViewById(R.id.decimal).setOnClickListener(this);
		findViewById(R.id.equals).setOnClickListener(this);
		findViewById(R.id.clear).setOnClickListener(this);
	}

	@Override
	public void onClick(View button) {
		
		String buttonPressed = ((Button) button).getText().toString();
	
		switch (button.getId()) {
		case R.id.zero:
		case R.id.one:
		case R.id.two:
		case R.id.three:
		case R.id.four:
		case R.id.five:
		case R.id.six:
		case R.id.seven:
		case R.id.eight:
		case R.id.nine:
		case R.id.decimal:
			if (currentCalculation.getText() == "0")
				currentCalculation.setText(buttonPressed);
			else 
				currentCalculation.append(buttonPressed);
			break;
		default:
			break;
		}
	}
}
