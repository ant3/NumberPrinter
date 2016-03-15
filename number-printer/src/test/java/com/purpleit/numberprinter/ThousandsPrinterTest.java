package com.purpleit.numberprinter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

/**
 * Unit test for printing thousands (0 - 999,999).
 */
public class ThousandsPrinterTest extends HundredsPrinterTest {

	public ThousandsPrinterTest() {
		printer = new ThousandsPrinter();
	}

	@Test
	public void testThousands() {
		assertThat(printer.print(1000)).isEqualTo("one thousand");
		assertThat(printer.print(1005)).isEqualTo("one thousand and five");
		assertThat(printer.print(1042)).isEqualTo("one thousand and forty two");
		assertThat(printer.print(1100)).isEqualTo("one thousand one hundred");
		assertThat(printer.print(1105)).isEqualTo("one thousand one hundred and five");
		assertThat(printer.print(12_045)).isEqualTo("twelve thousand and forty five");
		assertThat(printer.print(999_999)).isEqualTo("nine hundred and ninety nine thousand nine hundred and ninety nine");
	}

	@Test
	public void testOutOfBounds() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			printer.print(-1);
		}).withMessage("The number -1 is not in the range 0-999,999.");

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			printer.print(1_000_000);
		}).withMessage("The number 1000000 is not in the range 0-999,999.");
	}
}
