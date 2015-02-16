package com.laboon;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {
	
	//Wasn't sure how to test each individual get method because there are no accesors 
	//for the _has variables. Decided to test them all at once with the hasAllItems() method
	@Test
	public void testGetMethods() {
		Player p1 = new Player();
		p1.getSugar();
		p1.getCoffee();
		p1.getCream();
		assertEquals(true, p1.hasAllItems());
	}
	
	//hasAllItems should return true
	@Test
	public void testHasAllItems(){
		Player p1 = new Player(true, true, true);
		assertTrue(p1.hasAllItems());
	}
	
	//hasAllItems should return false when there are no items
	@Test
	public void testHasNoItems(){
		Player p1 = new Player();
		assertFalse(p1.hasAllItems());
	}
	
	//hAI should return false when it has just 2 items (hAI = hasAllItems)
	@Test
	public void testHasTwoItems(){
		Player p1 = new Player(true, true, false);
		assertFalse(p1.hasAllItems());
	}
	
	//Last combination of items for hasAllItems function
	@Test
	public void testHasTwoOtherItems(){
		Player p1 = new Player(false, true, true);
		assertFalse(p1.hasAllItems());
	}
	//hAI should return false when it has just 1 item
	@Test
	public void testHasOneItem(){
		Player p1 = new Player();
		p1.getCoffee();
		assertEquals(false, p1.hasAllItems());
	}

	
	//drink should return false when there are no items
	@Test
	public void testDrinkNoItems(){
		Player p1 = new Player();
		assertFalse(p1.drink());
	}
	
	//drink should return false when there is one item available
	@Test
	public void testDrinkOneItem(){
		Player p1 = new Player();
		p1.getSugar();
		assertEquals(false, p1.drink());
	}
	
	//test just cream by itself for 100% code coverage
	@Test
	public void testDrinkCream(){
		Player p1 = new Player();
		p1.getCream();
		assertFalse(p1.drink());
	}
	
	//drink should also return false when there are two items available
	@Test
	public void testDrinkTwoItems(){
		Player p1 = new Player(true, false, true);
		assertFalse(p1.drink());
	}
	
	//drink two different items to test that scenario
	@Test
	public void testDrinkTwoOtherItems(){
		Player p1 = new Player(true, true, false);
		assertFalse(p1.drink());
	}
	
	//drinking just cream and coffee
	@Test
	public void testDrinkCoffeeAndCream(){
		Player p1 = new Player();
		p1.getCoffee();
		p1.getCream();
		assertFalse(p1.drink());
	}
	
	//drink should return true when all items are acquired
	@Test
	public void testDrinkThreeItems(){
		Player p1 = new Player(true, true, true);
		assertTrue(p1.drink());
	}
}
