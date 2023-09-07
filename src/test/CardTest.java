package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actors.Card;

public class CardTest {
	
	static String memberid = "memberid";
	static String code = "code";
	static String password = "password";
	
	
	private static Card card = new Card(memberid,code,password);

	
	@Test
	public void testMemberID() {
		assertTrue(memberid == card.getMemberID());
	}

	@Test
	public void testCode() {
		assertTrue(code == card.getCode());
	}
	
	@Test
	public void testPassword() {
		assertTrue(password == card.getPassword());
	}

	

}
