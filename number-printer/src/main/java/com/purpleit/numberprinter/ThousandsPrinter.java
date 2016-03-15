package com.purpleit.numberprinter;

public class ThousandsPrinter implements Printer {

	Printer hundredsPrinter;

	
	public ThousandsPrinter() {
		this(new HundredsPrinter());
	}
	
	public ThousandsPrinter(Printer hundredsPrinter) {
		this.hundredsPrinter = hundredsPrinter;
	}

	public String print(int number) {
		if (number < 0 || number > 999_999) {
			throw new IllegalArgumentException("The number " + number + " is not in the range 0-999,999.");
		}

		int thousands = number / 1000;
		int hundreds = number % 1000;
		if(thousands == 0) {
			return hundredsPrinter.print(hundreds);
		} else if(hundreds == 0) {
			return hundredsPrinter.print(thousands) + " thousand";
		} else if(hundreds < 100) {
			return hundredsPrinter.print(thousands) + " thousand and " + hundredsPrinter.print(hundreds);
		} else {
			return hundredsPrinter.print(thousands) + " thousand " + hundredsPrinter.print(hundreds);
		}
	}
}
