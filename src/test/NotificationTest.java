package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actors.Notification;

public class NotificationTest {

	static String type = "type";
	
	static float value = 100;
	static String memberid = "mid";
	static String boatid = "bid";
	
	@SuppressWarnings("deprecation")
	static java.sql.Date defaultdate = new java.sql.Date(2000,01,01);
	static java.sql.Date registrationD = defaultdate;
	
	private static Notification notification = new Notification(type,value,memberid,boatid,defaultdate);

	
	@Test
	public void testType() {
		assertTrue(type == notification.getType());
	}

	@Test
	public void testValue() {
		assertTrue(value == notification.getValue());
	}
	
	@Test
	public void testMemberID() {
		assertTrue(memberid == notification.getMemberID());
	}
	
	@Test
	public void testBoatID() {
		assertTrue(boatid == notification.getBoatID());
	}
	
	@Test
	public void testDate() {
		assertTrue(defaultdate == notification.getDate());
	}
	
	

}
