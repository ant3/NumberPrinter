package com.purpleit.numberprinter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

/**
 * Unit test for printing hundreds (0 - 999).
 */
public class HundredsPrinterTest extends TensPrinterTest {

	public HundredsPrinterTest() {
		printer = new HundredsPrinter();
	}

	@Test
	public void testHundreds() {
		assertThat(printer.print(100)).isEqualTo("one hundred");
		assertThat(printer.print(105)).isEqualTo("one hundred and five");
		assertThat(printer.print(111)).isEqualTo("one hundred and eleven");
		assertThat(printer.print(123)).isEqualTo("one hundred and twenty three");
		assertThat(printer.print(999)).isEqualTo("nine hundred and ninety nine");
	}

	@Test
	public void testOutOfBounds() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			printer.print(-1);
		}).withMessage("The number -1 is not in the range 0-999.");

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			printer.print(1000);
		}).withMessage("The number 1000 is not in the range 0-999.");
	}
}
