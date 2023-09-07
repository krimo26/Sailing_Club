package actors;

/**
 * 
 * Class {@code Notification} represents a general notification generated from a staff to a member 
 * 
 * @author mirko
 *
 */

public class Notification {
	
	private String type;
	private float value;
	private String memberID;
	private String boatID;
	private java.sql.Date date;
	
	/**
	 * 
	 * Class constructor
	 *  
	 * @param t type
	 * @param v value
	 * @param mid memberID
	 * @param bid boatID
	 * @param d date
	 */
	
	public Notification(String t, float v, String mid, String bid, java.sql.Date d) {
		this.type = t;
		this.value = v;
		this.memberID = mid;
		this.boatID = bid;
		this.date = d;
	}
	
	/**
	 * 
	 * Get type method
	 * 
	 * @return type
	 * 
	 */
	
	public String getType() {
		return this.type;
	}
	
	/**
	 * 
	 * Get value method
	 * 
	 * @return value
	 * 
	 */
	
	public float getValue() {
		return this.value;
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
	 * Get boatID method
	 * 
	 * @return boatID
	 * 
	 */
	
	public String getBoatID() {
		return this.boatID;
	}
	
	/**
	 * 
	 * Get date method
	 * 
	 * @return date
	 * 
	 */
	
	public java.sql.Date getDate(){
		return this.date;
	}

}
