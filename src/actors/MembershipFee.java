package actors;

/**
 * 
 * Class {@code MembershiFe} represents a membership fee associated to a member 
 * 
 * @author mirko
 *
 */

public class MembershipFee {

	private String memberID;
	private java.sql.Date date;
	private float value;
	private int paid;
	
	/**
	 * 
	 * Class constructor
	 *  
	 * @param mid memberID
	 * @param d date
	 * @param v value
	 * @param p paid
	 */
	
	public MembershipFee(String mid, java.sql.Date d, float v, int p) {
		this.memberID = mid;
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
