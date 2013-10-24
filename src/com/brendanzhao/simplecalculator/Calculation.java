package com.brendanzhao.simplecalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Brendan Zhao Represents the calculation that is created by the user.
 */
public class Calculation {

	/**
	 * Represents the maximum length of input inside of the calculator.
	 */
	public static final int MAX_CALCULATION_LENGTH = 16;

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

	/**
	 * Represents the operation to be performed when doing calculations with two numbers.
	 */
	private char operator;

	/**
	 * Initializes a new instance of Calculation with default values.
	 */
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

	public void setOperator(char operator) {
		this.operator = operator;
	}

	/**
	 * Processes calculations involving only one number.
	 * 
	 * @param singleOperation
	 *            Specifies the type of single number operation to perform. This had to be passed in or else it would
	 *            interfere with dual number operations.
	 */
	public void singleBrainPower(char singleOperation) {
		currentNumber = new BigDecimal(currentNumberString);

		switch (singleOperation) {
			case '\u00B1':
				currentNumber = currentNumber.multiply(new BigDecimal(-1));
				break;

			case '\u221a':
				if (currentNumber.signum() == 1) {
					currentNumber = BigDecimal.valueOf(Math.sqrt(currentNumber.doubleValue()));
				}
				break;

			default:
				break;
		}

		currentNumberString = currentNumber.toPlainString();
	}

	/**
	 * Processes calculations involving two numbers and returns the result.
	 */
	public void doubleBrainPower() {
		currentNumber = new BigDecimal(currentNumberString);
		bufferNumber = new BigDecimal(bufferNumberString);

		switch (operator) {
			case '+':
				currentNumber = bufferNumber.add(currentNumber);
				break;

			case '-':
				currentNumber = bufferNumber.subtract(currentNumber);
				break;

			case '*':
				currentNumber = bufferNumber.multiply(currentNumber);
				break;

			case '\u00F7':
				currentNumber = bufferNumber.divide(currentNumber, MAX_CALCULATION_LENGTH, RoundingMode.HALF_UP)
						.stripTrailingZeros();
				break;

			default:
				break;
		}

		bufferNumberString = "";
		currentNumberString = currentNumber.toPlainString();
	}
}
