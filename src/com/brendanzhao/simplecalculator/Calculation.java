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
	 * Processes the negative button logic.
	 */
	public void toggleNegative() {
		currentNumber = new BigDecimal(currentNumberString);
		currentNumber = currentNumber.multiply(new BigDecimal(-1));
		currentNumberString = currentNumber.toPlainString();
	}
	
	/**
	 * Processes the square root button logic.
	 */
	public void squareRoot() {
		currentNumber = new BigDecimal(currentNumberString);
		currentNumber = BigDecimal.valueOf(Math.sqrt(currentNumber.doubleValue()));
		currentNumberString = currentNumber.toPlainString();
	}
	
	
	
}
