package com.purpleit.numberprinter;

public class HundredsPrinter implements Printer {

	Printer tensPrinter;

	
	public HundredsPrinter() {
		this(new TensPrinter());
	}
	
	public HundredsPrinter(Printer tensPrinter) {
		this.tensPrinter = tensPrinter;
	}

	public String print(int number) {
		if (number < 0 || number > 999) {
			throw new IllegalArgumentException("The number " + number + " is not in the range 0-999.");
		}

		int hundreds = number / 100;
		int tens = number % 100;
		if(hundreds == 0) {
			return tensPrinter.print(tens);
		} else if(tens == 0) {
			return tensPrinter.print(hundreds) + " hundred";
		} else {
			return tensPrinter.print(hundreds) + " hundred and " + tensPrinter.print(tens);
		}
	}
}
