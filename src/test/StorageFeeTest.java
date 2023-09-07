package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actors.StorageFee;

public class StorageFeeTest {

	static String memberid = "mid";
	static String boatid = "bid";
	static String boatname = "bname";
	
	
	
	@SuppressWarnings("deprecation")
	static java.sql.Date defaultdate = new java.sql.Date(2000,01,01);
	static java.sql.Date registrationD = defaultdate;
	
	static float value = 100;
	static int paid = 0;
	
	private static StorageFee storagefee = new StorageFee(memberid,boatid,boatname,defaultdate,value,paid);
	
	@Test
	public void testMemberID() {
		assertTrue(memberid == storagefee.getMemberID());
	}

	@Test
	public void testBoatID() {
		assertTrue(boatid == storagefee.getBoatID());
	}
	
	@Test
	public void testBoatName() {
		assertTrue(boatname == storagefee.getBoatName());
	}
	
	@Test
	public void testDate() {
		assertTrue(memberid == storagefee.getMemberID());
	}
	
	@Test
	public void testValue() {
		assertTrue(value == storagefee.getValue());
	}
	
	@Test
	public void testPaid() {
		assertTrue(paid == storagefee.getPaid());
	}
	
	

}
