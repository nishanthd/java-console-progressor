package com.roonv;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.roonv.ConsoleProgressor;

public class ConsoleProgressorTest {

	ConsoleProgressor console = new ConsoleProgressor();

	@Test
	public void testGeneratingEllipsisEquavalentPercentage() {

		assertEquals("", console.generateEllipsis(1));
		assertEquals("=", console.generateEllipsis(3));
		assertEquals("==", console.generateEllipsis(4));
	}

	@Test
	public void testSettingEllipsis() {
		console.setEllipsis("-");
		String result = console.generateEllipsis(3);
		assertEquals("-", result);
		console.setEllipsis("=");
	}

	@Test
	public void testGeneratingSapce() {
		String result = console.generateSpaces(45);
		assertEquals("     ", result);
	}

	@Test
	public void testGeneratingProgressFor100Percentage() {
		String result = console.generateProgressString(100);

		assertEquals("[==================================================>]", result);
	}

	@Test
	public void testGeneratingProgressFor5Percentage() {
		String result = console.generateProgressString(5);

		assertEquals("[==>                                                ]", result);
	}

	@Test
	public void testShowingProgress() throws InterruptedException {

		int i = 1;
		while (i <= 100) {
			console.showProgress(i);
			i++;
			Thread.sleep(20);
		}
	}

}
