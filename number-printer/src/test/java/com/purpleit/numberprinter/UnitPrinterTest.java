package com.purpleit.numberprinter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

/**
 * Unit test for printing units (0 - 9).
 */
public class UnitPrinterTest {

	protected Printer printer;
	
	
	public UnitPrinterTest() {
		printer = new UnitPrinter();
	}

	@Test
	public void testZeroToNine() {
		assertThat(printer.print(0)).isEqualTo("zero");
		assertThat(printer.print(1)).isEqualTo("one");
		assertThat(printer.print(2)).isEqualTo("two");
		assertThat(printer.print(3)).isEqualTo("three");
		assertThat(printer.print(4)).isEqualTo("four");
		assertThat(printer.print(5)).isEqualTo("five");
		assertThat(printer.print(6)).isEqualTo("six");
		assertThat(printer.print(7)).isEqualTo("seven");
		assertThat(printer.print(8)).isEqualTo("eight");
		assertThat(printer.print(9)).isEqualTo("nine");
	}

	@Test
	public void testOutOfBounds() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			printer.print(-1);
		}).withMessage("The number -1 is not in the range 0-9.");

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			printer.print(10);
		}).withMessage("The number 10 is not in the range 0-9.");
	}
}
