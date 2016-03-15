package com.purpleit.numberprinter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

/**
 * Unit test for printing millions (0 - 999,999,999).
 */
public class MillionsPrinterTest extends ThousandsPrinterTest {

	public MillionsPrinterTest() {
		printer = new MillionsPrinter();
	}

	@Test
	public void testMillions() {
		assertThat(printer.print(1000_000)).isEqualTo("one million");
		assertThat(printer.print(1000_001)).isEqualTo("one million and one");
		assertThat(printer.print(2000_100)).isEqualTo("two million one hundred");
		assertThat(printer.print(8100_100)).isEqualTo("eight million one hundred thousand one hundred");
		assertThat(printer.print(56_945_781)).isEqualTo("fifty six million nine hundred and forty five thousand seven hundred and eighty one");
		assertThat(printer.print(100_000_000)).isEqualTo("one hundred million");
		assertThat(printer.print(999_999_999)).isEqualTo("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine");
	}

	@Test
	public void testOutOfBounds() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			printer.print(-1);
		}).withMessage("The number -1 is not in the range 0-999,999,999.");

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			printer.print(1_000_000_000);
		}).withMessage("The number 1000000000 is not in the range 0-999,999,999.");
	}
}
