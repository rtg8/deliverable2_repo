package com.laboon;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

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
	//creates three mock Rooms and populates a Room array with them
	//that Room array is used to create a house
	//testing the overlap; when moving south once initially you should be
	//returned to the beginning, this covers second branch or if statement
	@Test
	public void testGetCurrentRoomInfoMocks2(){
		Room[] h1 = new Room[3];
		h1[0] = mock(Room.class);
		h1[1] = mock(Room.class);
		h1[2] = mock(Room.class);
		
		when(h1[0].getDescription()).thenReturn("Awesome room.");
		when(h1[1].getDescription()).thenReturn("Awful room.");
		when(h1[2].getDescription()).thenReturn("Atrocious room.");
		
		House house1 = new House (h1);
		house1.moveSouth();
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
	
	//create a mock room with coffee in it to test whether or not the look function
	//recognizes it and collects it
	@Test
	public void testCoffeeLook()
	{
		Room r1 = Mockito.mock(Room.class);
		Room[] _rooms = new Room[1];
		Player player1 = Mockito.mock(Player.class);
		_rooms[0]=r1;
		when(r1.hasCoffee()).thenReturn(true);  //stub hasCoffee to true
		when(r1.hasItem()).thenReturn(true);    //stub hasItem to true
		House house1 = new House(_rooms);
		house1.look(player1, r1);
		Mockito.verify(r1).hasCoffee();		//verify that look has executed properly
		Mockito.verify(player1).getCoffee();
		
		
		
	}
	//create a mock room with cream in it to test whether or not the look function
	//recognizes it and collects it
	@Test
	public void testCreamLook()
	{
		Room r1 = Mockito.mock(Room.class);
		Room[] _rooms = new Room[1];
		Player player1 = Mockito.mock(Player.class);
		_rooms[0]=r1;
		when(r1.hasCream()).thenReturn(true); //stub hasCream to true
		when(r1.hasItem()).thenReturn(true); //stub hasItem to true
		House house1 = new House(_rooms);
		house1.look(player1, r1);
		Mockito.verify(r1).hasCream(); //verify that look has executed properly
		Mockito.verify(player1).getCream();
		
		
		
	}
	
	//create a mock room with sugar in it to test whether or not the look function
	//recognizes it and collects it
	@Test
	public void testSugarLook()
	{
		Room r1 = Mockito.mock(Room.class);
		Room[] _rooms = new Room[1];
		Player player1 = Mockito.mock(Player.class);
		_rooms[0]=r1;
		when(r1.hasSugar()).thenReturn(true);  //stub hasSugar to be true
		when(r1.hasItem()).thenReturn(true); //stub hasItem to be true
		House house1 = new House(_rooms);
		house1.look(player1, r1);
		Mockito.verify(r1).hasSugar(); //verify that look has executed properly
		Mockito.verify(player1).getSugar();
		
		
		
	}
	//create a mock room with nothing in it to test whether or not the look function
	//recognizes it and collects nothing
	@Test
	public void testEmptyLook()
	{
		Room r1 = Mockito.mock(Room.class);
		Room[] _rooms = new Room[1];
		Player player1 = Mockito.mock(Player.class);
		_rooms[0]=r1;
		when(r1.hasCoffee()).thenReturn(false);  //stub hasCoffee to false
		when(r1.hasCream()).thenReturn(false);	//stub hasCream to false
		when(r1.hasSugar()).thenReturn(false); //stub hasSugar to false
		when(r1.hasItem()).thenReturn(false); //stub hasItem to false
		House house1 = new House(_rooms);
		house1.look(player1, r1); //look into empty room
		
		
		
	}
	//sends null value to look function to ensure the null error catch in the loop
	//works properly
	@Test
	public void testNullLook()
	{
		Room r1 = Mockito.mock(Room.class);
		Room[] _rooms = new Room[1];
		Player player1 = Mockito.mock(Player.class);
		_rooms[0]=r1;
		House house1 = new House(_rooms);
		house1.look(player1, null);
		
		
		
	}
	
	
}

