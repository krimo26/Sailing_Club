package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actors.Boat;

public class BoatTest {

	static String name = "name";
	static String ID = "bid";
	static float storagefee = 100;
	static String memberid = "mid";
	
	@SuppressWarnings("deprecation")
	static java.sql.Date defaultdate = new java.sql.Date(2000,01,01);
	static java.sql.Date registrationD = defaultdate;
	
	private static Boat boat = new Boat(name,ID,storagefee,defaultdate,memberid);

	
	@Test
	public void testName() {
		assertTrue(name == boat.getName());
	}

	@Test
	public void testID() {
		assertTrue(ID == boat.getID());
	}
	
	@Test
	public void testStorageFee() {
		assertTrue(storagefee == boat.getStorageFee());
	}
	
	@Test
	public void testDate() {
		assertTrue(defaultdate == boat.getRegistrationDate());
	}
	
	@Test
	public void testMemberID() {
		assertTrue(memberid == boat.getMemberID());
	}
	
	


}
