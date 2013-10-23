package com.brendanzhao.simplecalculator;

import java.math.BigDecimal;

/**
 * @author Brendan Zhao 
 * Represents the calculation that is created by the user.
 */
public class Calculation {

	/**
	 * Represents the number the user creates by using the calculator.
	 */
	private String currentNumberString;

	/**
	 * Represents the number that user creates by using the calculator after an operator is tapped.
	 */
	private String bufferNumberString;

	/**
	 * Represents the internal value of the current number used to calculate operations.
	 */
	private BigDecimal currentNumber;
	
	/**
	 * Represents the internal value of the buffer number used to calculate operations.
	 */
	private BigDecimal bufferNumber;

	public Calculation() {
		currentNumberString = "0";
		bufferNumberString = "";
	}

	public void setCurrentNumberString(String firstNumberString) {
		this.currentNumberString = firstNumberString;
	}

	public String getCurrentNumberString() {
		return currentNumberString;
	}

	public void setBufferNumberString(String secondNumberString) {
		this.bufferNumberString = secondNumberString;
	}

	public String getBufferNumberString() {
		return bufferNumberString;
	}

	/**
	 * Updates the internal BigDecimal values and is to be used whenever an operation occurs.
	 */
	private void updateBigDecimals() {
		currentNumber = new BigDecimal(currentNumberString);
		bufferNumber = new BigDecimal(bufferNumberString);
	}

	/**
	 * Processes the calculation.
	 */
	private void brainPower() {
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
