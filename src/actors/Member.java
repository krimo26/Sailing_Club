package actors;

/**
 * 
 * Class {@code Member} represents a member actor 
 * 
 * @author mirko
 *
 */

public class Member {
	
	private String name;
	private String lastname;
	private String ID;
	private String address;
	private String username;
	private String password;
	private java.sql.Date registrationD;
	
	/**
	 * 
	 * Class constructor
	 *  
	 * @param n name
	 * @param l lastname
	 * @param id ID
	 * @param a address
	 * @param un username
	 * @param p password
	 * @parma d date
	 */

	public Member(String n, String l, String id, String a, String un, String p, java.sql.Date d) {
		this.name = n;
		this.lastname = l;
		this.ID = id;
		this.address = a;
		this.username = un;
		this.password = p;
		this.registrationD = d;
	}
	
	/**
	 * 
	 * Default class constructor 
	 * 
	 */
	
	public Member() {
		this.name = "";
		this.lastname = "";
		this.ID = "";
		this.address = "";
		this.username = "";
		this.password = "";
		@SuppressWarnings("deprecation")
		java.sql.Date defaultdate = new java.sql.Date(2000,01,01);
		this.registrationD = defaultdate;
	}
	
	/**
	 * 
	 * Get name method
	 * 
	 * @return name
	 * 
	 */
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * Get lastname method
	 * 
	 * @return lastname
	 * 
	 */
	
	public String getLastname() {
		return this.lastname;
	}
	
	/**
	 * 
	 * Get ID method
	 * 
	 * @return ID
	 * 
	 */
	
	public String getID() {
		return this.ID;
	}
	
	/**
	 * 
	 * Get address method
	 * 
	 * @return address
	 * 
	 */
	
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * 
	 * Get username method
	 * 
	 * @return username
	 * 
	 */
	
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * 
	 * Get password method
	 * 
	 * @return password
	 * 
	 */
	
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * 
	 * Get registrationD method
	 * 
	 * @return registrationD
	 * 
	 */
	
	public java.sql.Date getRegistrationD() {
		return this.registrationD;
	}
	
	/**
	 * 
	 * Set address method
	 * 
	 * @param address new address
	 * 
	 */
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 
	 * Set username method
	 * 
	 * @param username new username
	 * 
	 */
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 
	 * Set password method
	 * 
	 * @param password new password
	 * 
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 
	 * Print Member attributes
	 * 
	 */
	
	public void printMember() {
		System.out.println(this.name + " " + this.lastname + " " + this.ID + " " + 
				this.address + " " + this.username + " " + this.password + " " + this.registrationD);
	}

}
