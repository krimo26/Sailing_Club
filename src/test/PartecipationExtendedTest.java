package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actors.PartecipationExtended;

public class PartecipationExtendedTest {

	static String memberusername = "memberusername";
	static String boatname = "boatname";
	static String competitionname = "competitionname";
	static String memberid = "mid";
	static String boatid = "bid";
	
	@SuppressWarnings("deprecation")
	static java.sql.Date defaultdate = new java.sql.Date(2000,01,01);
	static java.sql.Date registrationD = defaultdate;
	
	static float value = 100;
	
	private static PartecipationExtended partecipationextended = new PartecipationExtended(memberusername,boatname,competitionname,memberid,boatid,defaultdate,value);

	
	@Test
	public void testMemberUsername() {
		assertTrue(memberusername == partecipationextended.getMember());
	}

	@Test
	public void testBoatName() {
		assertTrue(boatname == partecipationextended.getBoat());
	}
	
	@Test
	public void testCompetitionName() {
		assertTrue(competitionname == partecipationextended.getCompetition());
	}
	
	@Test
	public void testMembeID() {
		assertTrue(memberid == partecipationextended.getMemberID());
	}
	
	@Test
	public void testBoatID() {
		assertTrue(boatid == partecipationextended.getBoatID());
	}
	
	@Test
	public void testDate() {
		assertTrue(defaultdate == partecipationextended.getDate());
	}

	
	@Test
	public void testValue() {
		assertTrue(value == partecipationextended.getValue());
	}


}
