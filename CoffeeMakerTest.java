package com.laboon;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoffeeMakerTest {

	//testing the runArgs() function. It should always return 0.
	@Test
	public void testRunArgs() {
		CoffeeMaker c = new CoffeeMaker();
		String argument = "anything";
		assertEquals(0, c.runArgs(argument));
	}

}
