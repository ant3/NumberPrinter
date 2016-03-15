package com.purpleit.numberprinter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Test;

/**
 * Unit test for printing tens (0 - 99).
 */
public class TensPrinterTest extends UnitPrinterTest {

	public TensPrinterTest() {
		printer = new TensPrinter();
	}

	@Test
	public void testTenToNineteen() {
		assertThat(printer.print(10)).isEqualTo("ten");
		assertThat(printer.print(11)).isEqualTo("eleven");
		assertThat(printer.print(12)).isEqualTo("twelve");
		assertThat(printer.print(13)).isEqualTo("thirteen");
		assertThat(printer.print(14)).isEqualTo("fourteen");
		assertThat(printer.print(15)).isEqualTo("fifteen");
		assertThat(printer.print(16)).isEqualTo("sixteen");
		assertThat(printer.print(17)).isEqualTo("seventeen");
		assertThat(printer.print(18)).isEqualTo("eighteen");
		assertThat(printer.print(19)).isEqualTo("nineteen");
	}
	
	@Test
	public void testTens() {
		assertThat(printer.print(20)).isEqualTo("twenty");
		assertThat(printer.print(21)).isEqualTo("twenty one");
		assertThat(printer.print(99)).isEqualTo("ninety nine");
	}

	@Test
	public void testOutOfBounds() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			printer.print(-1);
		}).withMessage("The number -1 is not in the range 0-99.");

		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			printer.print(100);
		}).withMessage("The number 100 is not in the range 0-99.");
	}
}
