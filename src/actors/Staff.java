package actors;

/**
 * 
 * Class {@code Staff} represents a staff actor 
 * 
 * @author mirko
 *
 */

public class Staff {
	
	private String username;
	private String password;
	
	/**
	 * 
	 * Class constructor
	 *  
	 * @param un username
	 * @param p password
	 */
	
	public Staff(String un, String p) {
		this.username = un;
		this.password = p;
	}
	
	/**
	 * 
	 * Default class constructor 
	 * 
	 */
	
	public Staff() {
		this.username = "";
		this.password = "";
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
	 * Set password method
	 * 
	 * @param password new password
	 * 
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}

}
