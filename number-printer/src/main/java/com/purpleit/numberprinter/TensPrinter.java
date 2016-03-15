package com.purpleit.numberprinter;

public class TensPrinter implements Printer {

	private static final String[] TEENS = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen" };
	private static final String[] TENS = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
			"eighty", "ninety" };

	Printer unitPrinter;

	
	public TensPrinter() {
		this(new UnitPrinter());
	}
	
	public TensPrinter(Printer unitPrinter) {
		this.unitPrinter = unitPrinter;
	}

	public String print(int number) {
		if (number < 0 || number > 99) {
			throw new IllegalArgumentException("The number " + number + " is not in the range 0-99.");
		}

		int tens = number / 10;
		int units = number % 10;
		switch (tens) {
			case 0:
				return unitPrinter.print(number);
			case 1:
				return TEENS[units];
			default:
				return (units == 0) ? TENS[tens] : TENS[tens] + " " + unitPrinter.print(units);
		}
	}
}
