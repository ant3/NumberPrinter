package com.purpleit.numberprinter;

public class MillionsPrinter implements Printer {

	Printer thousandsPrinter;

	
	public MillionsPrinter() {
		this(new ThousandsPrinter());
	}
	
	public MillionsPrinter(Printer thousandsPrinter) {
		this.thousandsPrinter = thousandsPrinter;
	}

	public String print(int number) {
		if (number < 0 || number > 999_999_999) {
			throw new IllegalArgumentException("The number " + number + " is not in the range 0-999,999,999.");
		}

		int millions = number / 1_000_000;
		int thousands = number % 1_000_000;
		if(millions == 0) {
			return thousandsPrinter.print(thousands);
		} else if(thousands == 0) {
			return thousandsPrinter.print(millions) + " million";
		} else if(thousands < 100) {
			return thousandsPrinter.print(millions) + " million and " + thousandsPrinter.print(thousands);
		} else {
			return thousandsPrinter.print(millions) + " million " + thousandsPrinter.print(thousands);
		}
	}
}
