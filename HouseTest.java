package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class HouseTest {

	//testing whether generateRooms creates the same room array
	//should be false because descriptions are generated randomly
	@Test
	public void testGenerateRooms() {
		House house1 = new House(6);
		Room[] h1 = house1.generateRooms(6);
		Room[] h2 = house1.generateRooms(6);
		assertNotSame(h1, h2);
	}
	
	//creates three mock Rooms and populates a Room array with them
	//that Room array is used to create a house
	//testing the overlap; when moving north 3 times should be in
	//the original room and description should be "Awesome room."
	@Test
	public void testGetCurrentRoomInfoMocks(){
		Room[] h1 = new Room[3];
		h1[0] = mock(Room.class);
		h1[1] = mock(Room.class);
		h1[2] = mock(Room.class);
		
		when(h1[0].getDescription()).thenReturn("Awesome room.");
		when(h1[1].getDescription()).thenReturn("Awful room.");
		when(h1[2].getDescription()).thenReturn("Atrocious room.");
		
		 House house1 = new House (h1);
		house1.moveNorth();
		house1.moveNorth();
		house1.moveNorth();
		house1.getCurrentRoomInfo(); //checking into magical land, should be returned to beginning
		
		assertEquals("Awesome room.", house1.getCurrentRoomInfo());
	}
	
	//even if we are outside of the room getCurrentRoomInfo
	//should never return NULL
	@Test
	public void testGetCurrentRoomInfoNull(){
		House house2 = new House(1);
		house2.moveNorth();
		assertNotNull(house2.getCurrentRoomInfo());
	}
}
