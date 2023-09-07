package test;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import actors.Member;


@FixMethodOrder(MethodSorters.DEFAULT)
public class MemberTest {

	
	static String name = "name";
	static String lastname = "lastname";
	static String ID = "id";
	static String address = "address";
	static String username = "username";
	static String password = "password";
	
	@SuppressWarnings("deprecation")
	static java.sql.Date defaultdate = new java.sql.Date(2000,01,01);
	static java.sql.Date registrationD = defaultdate;
	
	private static Member member = new Member(name,lastname,ID,address,username,password,defaultdate);

	
	@Test
	public void testName() {
		assertTrue(name == member.getName());
	}
	
	@Test
	public void testLastame() {
		assertTrue(lastname == member.getLastname());
	}

	@Test
	public void testID() {
		assertTrue(ID == member.getID());
	}
	
	@Test
	public void testAddress() {
		assertTrue(address == member.getAddress());
	}
	
	@Test
	public void testUsername() {
		assertTrue(username == member.getUsername());
	}
	
	
	@Test
	public void testPassword() {
		assertTrue(password == member.getPassword());
	}

	
}
