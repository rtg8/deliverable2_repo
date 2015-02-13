package com.laboon;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {
	
	//hasItem should return True when the Room has some items
	@Test
	public void testHasItemWithItems() {
		Room r = new Room(true, false, false, true, true);
		assertTrue(r.hasItem());
	}
	
	//hasItem should return False when the Room has no items
	@Test
	public void testHasItemWithNoItems(){
		Room r = new Room(false, false, false, true, true);
		assertFalse(r.hasItem());
	}
	
	//hasSugar should return True when the Room has Sugar
	@Test
	public void testHasSugar(){
		Room r = new Room(false, false, true, true, true);
		assertEquals(true, r.hasSugar());
	}
	
	//hasSugar should return False when the Room does not have Sugar
	@Test
	public void testDoesntHaveSugar(){
		Room r = new Room(false, false, false, true, true);
		assertEquals(false, r.hasSugar());
	}
	
	//hasCream should return True when the Room has cream
	@Test
	public void testHasCream(){
		Room r = new Room (false, true, false, true, true);
		assertTrue(r.hasCream());
	}
	
	//hasCream should return False when the Room does not have cream
	@Test
	public void testDoesntHaveCream(){
		Room r = new Room (false, false, true, true, true);
		assertFalse(r.hasCream());
	}
	
	//hasCoffee returns True when the room has coffee
	@Test
	public void testHasCoffee(){
		Room r = new Room (true, false, false, true, false);
		assertTrue(r.hasCoffee());	
	}
	
	//hasCoffee will return False when the room doesn't have coffee
	@Test
	public void testDoesntHaveCoffee(){
		Room r = new Room (false, true, true, false, false);
		assertFalse(r.hasCoffee());
	}
	
	//returns True when the room has a north exit
	@Test
	public void hasNorthExit(){
		Room r = new Room (false, true, false, true, false);
		assertTrue(r.northExit());
	}
	
	//returns false when the room doesn't have a north exit
	@Test
	public void doesntHaveNorthExit(){
		Room r = new Room (false, true, false, false, false);
		assertFalse(r.northExit());
	}
	
	//returns True when there is a south exit
	@Test
	public void hasSouthExit(){
		Room r = new Room (false, false, false, false, true);
		assertTrue(r.southExit());
	}
	
	//returns false when there is no south exit
	@Test
	public void doesntHaveSouthExit(){
		Room r = new Room (true, true, true, false, false);
		assertFalse(r.southExit());
	}
	
	//I wasn't sure on how to test this method because descriptions are created randomly and using entirely
	//private methods; so I settled on testing this method by checking that it does have a description by seeing
	//wheteher the description is NULL or not
	@Test
	public void testGetDescription(){
		Room r = new Room (true, true, true, true, true);
		assertNotNull(r.getDescription());
	}
}