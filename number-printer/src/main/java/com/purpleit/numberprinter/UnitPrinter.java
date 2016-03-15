package com.purpleit.numberprinter;

public class UnitPrinter implements Printer {
	
	private static final String[] UNITS = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	public String print(int number) {
		if(number < 0 || number > 9) {
			throw new IllegalArgumentException("The number " + number + " is not in the range 0-9.");
		}
		
		return UNITS[number];
	}
}
