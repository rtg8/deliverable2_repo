package com.laboon;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.mockito.*;
import java.io.*;

public class GameTest {
	@Mock
	House house1 = Mockito.mock(House.class);
	Player player1 = Mockito.mock(Player.class);
	
	
	//Sending uppercase N into function and verifying the game responds appropriately by moving north
	@Test
	public void testDoSomethingN()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("N");
		Mockito.verify(house1).moveNorth();
	}
	//Sending lowercase n into function and verifying the game responds appropriately by moving north
	@Test
	public void testDoSomethingn()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("n");
		Mockito.verify(house1).moveNorth();
	}

	//Sending uppercase S into function and verifying the game responds appropriately by moving south
	@Test
	public void testDoSomethingS()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("S");
		Mockito.verify(house1).moveSouth();
	}
	//Sending lowercase s into function and verifying the game responds appropriately by moving south
	@Test
	public void testDoSomethings()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("s");
		Mockito.verify(house1).moveSouth();
	}

	//Sending uppercase L into function and verifying the game responds appropriately by looking
	@Test
	public void testDoSomethingL()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("L");
		Mockito.verify(house1).look(player1,  null);
	}

	//Sending lowercase l into function and verifying the game responds appropriately by looking
	@Test
	public void testDoSomethingl()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("l");
		Mockito.verify(house1).look(player1,  null);
	}

	//Sending uppercase I into function and verifying the game responds appropriately by checking inventory
	@Test
	public void testDoSomethingI()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("I");
		Mockito.verify(player1).showInventory();
	}
	
	
	//Sending lowercase i into function and verifying the game responds appropriately by checking inventory
	@Test
	public void testDoSomethingi()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("i");
		Mockito.verify(player1).showInventory();
	}
	
	//Sending uppercase D into function and verifying the game responds appropriately by drinking without any ingredients
	@Test
	public void testDoSomethingD()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		retval = game1.doSomething("D");
		assertTrue(retval == -1);
	}
	
	//Sending lowercase d into function and verifying the game responds appropriately by drinking without any ingredients
	@Test
	public void testDoSomethingd()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		retval = game1.doSomething("d");
		assertTrue(retval == -1);
	}

	//Sending upper case D into a function while stubbing function to assume player has all ingredients
	//drinking should result in winning the game
	@Test
	public void testDoSomethingDwin()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		Mockito.doReturn(true).when(player1).drink();
		retval = game1.doSomething("D");
		assertTrue(retval == 1);
	}

	//Sending lower case d into a function while stubbing function to assume player has all ingredients
	//drinking should result in winning the game
	@Test
	public void testDoSomethingdwin()
	{
		Game game1 = new Game(player1, house1);
		int retval; 
		Mockito.doReturn(true).when(player1).drink();
		retval = game1.doSomething("d");
		assertTrue(retval == 1);
	}

	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream original = System.out;
	
	@Before
	public void setUpStreams(){
		System.setOut(new PrintStream(outContent));
	}
	
	//Tests whether the H command is implemented in the coffee maker quest program
	@Test
	public void testDoSomethingH()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("H");
		assertEquals ("Help message here.", outContent.toString());
	}
	
	//test for lower case h command
	@Test
	public void testDoSomethingh()
	{
		Game game1 = new Game(player1, house1);
		game1.doSomething("h");
		assertEquals ("Help message here.", outContent.toString());
	}
	
	@After
	public void cleanUpStreams()
	{
		System.setOut(original);
	}
}