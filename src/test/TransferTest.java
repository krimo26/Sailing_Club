package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actors.Transfer;

public class TransferTest {

	static String memberid = "mid";
	static String code = "code";
	static int used = 0;
	
	private static Transfer transfer = new Transfer(memberid,code,used);

	
	@Test
	public void testMemberID() {
		assertTrue(memberid == transfer.getMemberID());
	}

	@Test
	public void testCode() {
		assertTrue(code == transfer.getCode());
	}
	
	@Test
	public void testUsed() {
		assertTrue(used == transfer.getUsed());
	}
	
}
