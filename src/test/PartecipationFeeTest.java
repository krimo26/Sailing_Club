package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actors.PartecipationFee;

public class PartecipationFeeTest {

	static String memberid = "mid";
	static String boatid = "bid";
	static String competitionid = "cid";
	
	private static PartecipationFee partecipationfee = new PartecipationFee(memberid,boatid,competitionid);

	
	@Test
	public void testMemberID() {
		assertTrue(memberid == partecipationfee.getMemberID());
	}

	@Test
	public void testBoatID() {
		assertTrue(boatid == partecipationfee.getBoatID());
	}
	
	@Test
	public void testCompetitionID() {
		assertTrue(competitionid == partecipationfee.getCompetitionID());
	}


}
