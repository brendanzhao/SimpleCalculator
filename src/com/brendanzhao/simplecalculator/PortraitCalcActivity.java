package com.brendanzhao.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * This represents the main activity for the calculator app.
 * 
 * @author Brendan Zhao
 */
public class PortraitCalcActivity extends Activity implements OnClickListener {

	/**
	 * Represents the actual calculation that the user is creating.
	 */
	private Calculation calculation;

	/**
	 * Represents the display of the number entered before an operator was tapped.
	 */
	private TextView bufferedCalculationView;

	/**
	 * Represents the display of the number being currently typed.
	 */
	private TextView currentCalculationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.portrait_layout);

		bufferedCalculationView = (TextView) findViewById(R.id.bufferedcalculation);
		currentCalculationView = (TextView) findViewById(R.id.currentcalculation);
		calculation = new Calculation();
		updateTextViews();
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

	/**
	 * Updates the calculator text views that are displaying the numbers.
	 */
	private void updateTextViews() {
		currentCalculationView.setText(calculation.getCurrentNumberString());
		bufferedCalculationView.setText(calculation.getBufferNumberString());
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
				if (calculation.getCurrentNumberString().length() > Calculation.MAX_CALCULATION_LENGTH) {
					return;
				} else if (calculation.getCurrentNumberString().equalsIgnoreCase("0")) {
					calculation.setCurrentNumberString(buttonPressed);
				} else {
					calculation.setCurrentNumberString(calculation.getCurrentNumberString().concat(buttonPressed));
				}
				break;

			case R.id.decimal:
				if (!calculation.getCurrentNumberString().contains(buttonPressed)) {
					calculation.setCurrentNumberString(calculation.getCurrentNumberString().concat(buttonPressed));
				}
				break;

			case R.id.negative:
			case R.id.squareroot:
				calculation.singleBrainPower(buttonPressed.charAt(0));
				break;

			case R.id.add:
			case R.id.subtract:
			case R.id.multiply:
			case R.id.divide:
				if (calculation.getBufferNumberString().isEmpty()) {
					calculation.setOperator(buttonPressed.charAt(0));
					calculation.setBufferNumberString(calculation.getCurrentNumberString());
					calculation.setCurrentNumberString("0");
				} else {
					calculation.doubleBrainPower();
					calculation.setBufferNumberString(calculation.getCurrentNumberString());
					calculation.setCurrentNumberString("0");
					calculation.setOperator(buttonPressed.charAt(0));
				}
				break;

			case R.id.equals:
				if (!calculation.getBufferNumberString().isEmpty()) {
					calculation.doubleBrainPower();
				}
				break;

			case R.id.clear:
				calculation.resetCalculator();
				break;

			default:
				break;
		}

		updateTextViews();
	}
}
