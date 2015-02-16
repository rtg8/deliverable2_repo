package com.laboon;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.*;

public class GameTest {
	@Mock


	House house1 = Mockito.mock(House.class);
	Player player1 = Mockito.mock(Player.class);

	@Test
	public void testDoSomethingN()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		retval = game1.doSomething("N");
		assertTrue(retval == 0);
	}

	@Test
	public void testDoSomethingn()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		retval = game1.doSomething("n");
		assertTrue(retval == 0);
	}

	@Test
	public void testDoSomethingS()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		retval = game1.doSomething("S");
		assertTrue(retval == 0);
	}

	@Test
	public void testDoSomethings()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		retval = game1.doSomething("s");
		assertTrue(retval == 0);
	}

	@Test
	public void testDoSomethingL()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		retval = game1.doSomething("L");
		assertTrue(retval == 0);
	}

	@Test
	public void testDoSomethingl()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		retval = game1.doSomething("l");
		assertTrue(retval == 0);
	}

	@Test
	public void testDoSomethingI()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		retval = game1.doSomething("I");
		assertTrue(retval == 0);
	}

	@Test
	public void testDoSomethingi()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		retval = game1.doSomething("i");
		assertTrue(retval == 0);
	}

	@Test
	public void testDoSomethingD()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		retval = game1.doSomething("D");
		assertTrue(retval == -1);
	}

	@Test
	public void testDoSomethingd()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		retval = game1.doSomething("d");
		assertTrue(retval == -1);
	}

	@Test
	public void testDoSomethingDwin()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		Mockito.doReturn(true).when(player1).drink();
		retval = game1.doSomething("D");
		assertTrue(retval == 1);
	}

	@Test
	public void testDoSomethingdwin()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		Mockito.doReturn(true).when(player1).drink();
		retval = game1.doSomething("d");
		assertTrue(retval == 1);
	}


}

