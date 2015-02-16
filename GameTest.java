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
		game1.doSomething("N");
		Mockito.verify(house1).moveNorth();
	}

	@Test
	public void testDoSomethingn()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("n");
		Mockito.verify(house1).moveNorth();
	}

	@Test
	public void testDoSomethingS()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("S");
		Mockito.verify(house1).moveSouth();
	}

	@Test
	public void testDoSomethings()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("s");
		Mockito.verify(house1).moveSouth();
	}

	@Test
	public void testDoSomethingL()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("L");
		Mockito.verify(house1).look(player1,  null);
	}

	@Test
	public void testDoSomethingl()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("l");
		Mockito.verify(house1).look(player1,  null);
	}

	@Test
	public void testDoSomethingI()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("I");
		Mockito.verify(player1).showInventory();
	}

	@Test
	public void testDoSomethingi()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("i");
		Mockito.verify(player1).showInventory();
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

