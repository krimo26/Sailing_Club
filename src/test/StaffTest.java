package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import actors.Staff;

public class StaffTest {

	static String username = "username";
	static String password = "password";
	
	private static Staff staff = new Staff(username,password);

	
	@Test
	public void testUsername() {
		assertTrue(username == staff.getUsername());
	}

	@Test
	public void testPassword() {
		assertTrue(password == staff.getPassword());
	}


}
