package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actors.MembershipFee;

public class MembershipFeeTest {

	static String memberid = "memberid";
	
	@SuppressWarnings("deprecation")
	static java.sql.Date defaultdate = new java.sql.Date(2000,01,01);
	static java.sql.Date registrationD = defaultdate;
	
	static float value = 100;
	static int paid = 0;
	
	private static MembershipFee membershipfee= new MembershipFee(memberid,defaultdate,value,paid);

	
	@Test
	public void testMemberID() {
		assertTrue(memberid == membershipfee.getMemberID());
	}

	@Test
	public void testDate() {
		assertTrue(defaultdate == membershipfee.getDate());
	}
	
	@Test
	public void testValue() {
		assertTrue(value == membershipfee.getValue());
	}
	
	@Test
	public void testPaid() {
		assertTrue(paid == membershipfee.getPaid());
	}
	

}
