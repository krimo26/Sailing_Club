package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actors.Competition;

public class CompetitionTest {

	static String name = "name";
	static String ID = "id";
	
	@SuppressWarnings("deprecation")
	static java.sql.Date defaultdate = new java.sql.Date(2000,01,01);
	static java.sql.Date registrationD = defaultdate;
	
	static float partecipationfee = 100;
	
	private static Competition competition = new Competition(name,ID,defaultdate,partecipationfee);

	
	@Test
	public void testName() {
		assertTrue(name == competition.getName());
	}

	@Test
	public void testID() {
		assertTrue(ID == competition.getID());
	}
	
	@Test
	public void testPartecipationFee() {
		assertTrue(partecipationfee == competition.getPartecipationFee());
	}
	
	@Test
	public void testDate() {
		assertTrue(defaultdate == competition.getDate());
	}
	
}
