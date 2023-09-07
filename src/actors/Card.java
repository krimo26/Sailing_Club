package actors;

/**
 * 
 * Class {@code Card} represents a Card used for paying fees
 * 
 * @author mirko
 *
 */

public class Card {
	
	private String memberID;
	private String code;
	private String password;
	
	/**
	 * 
	 * Class constructor
	 *  
	 * @param mid memberID
	 * @param cod code
	 * @param pass password
	 */
	
	public Card(String mid, String cod, String pass) {
		this.memberID = mid;
		this.code = cod;
		this.password = pass;
	}
	
	/**
	 * 
	 * Get memberID method
	 * 
	 * @return memberID
	 * 
	 */
	
	public String getMemberID() {
		return this.memberID;
	}
	
	/**
	 * 
	 * Get code method
	 * 
	 * @return code
	 * 
	 */
	
	public String getCode() {
		return this.code;
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
	

}
