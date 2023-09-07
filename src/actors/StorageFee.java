package actors;

/**
 * 
 * Class {@code StorageFee} represents a storage fee associated to a boat and his owner 
 * 
 * @author mirko
 *
 */

public class StorageFee {

	private String memberID;
	private String boatID;
	private String boatName;
	private java.sql.Date date;
	private float value;
	private int paid;
	
	/**
	 * 
	 * Class constructor
	 *  
	 * @param mid memberID
	 * @param bid boatID
	 * @param n boatName
	 * @param d date
	 * @param v value
	 * @param p paid
	 */
	
	public StorageFee(String mid, String bid, String n, java.sql.Date d, float v, int p) {
		this.memberID = mid;
		this.boatID = bid;
		this.boatName = n;
		this.date = d;
		this.value = v;
		this.paid = p;
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
	 * Get boatName method
	 * 
	 * @return boatName
	 * 
	 */
	
	public String getBoatName() {
		return this.boatName;
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
	 * Get paid method
	 * 
	 * @return paid
	 * 
	 */
	
	public int getPaid() {
		return this.paid;
	}

}
