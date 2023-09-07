package actors;

/**
 * 
 * Class {@code Transfer} represents a transfer used once to pay a fee 
 * 
 * @author mirko
 *
 */

public class Transfer {
	
	private String memberID;
	private String code;
	private int used;
	
	/**
	 * 
	 * Class constructor
	 *  
	 * @param mid memberID
	 * @param cod code
	 * @param us used
	 */
	
	public Transfer(String mid, String cod, int us) {
		this.memberID = mid;
		this.code = cod;
		this.used = us;
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
	 * Get used method
	 * 
	 * @return used
	 * 
	 */
	
	public int getUsed() {
		return this.used;
	}

}
