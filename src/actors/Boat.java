package actors;

/**
 * 
 * Class {@code Boat} represents a general boat associated to his owner 
 * 
 * @author mirko
 *
 */

public class Boat {
	
	private String name;
	private String ID;
	private float storageFee;
	private java.sql.Date registrationDate;
	private String memberID;
	
	/**
	 * 
	 * Class constructor
	 *  
	 * @param n name
	 * @param id ID
	 * @param sf storageFee
	 * @param d date
	 * @param mid memberID
	 */
	
	public Boat(String n, String id, float sf, java.sql.Date d, String mid) {
		this.name = n;
		this.ID = id;
		this.storageFee = sf;
		this.registrationDate = d;
		this.memberID = mid;
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
	 * Get storageFee method
	 * 
	 * @return storageFee
	 * 
	 */
	
	public float getStorageFee() {
		return this.storageFee;
	}
	
	/**
	 * 
	 * Get registrationDate method
	 * 
	 * @return registrationDate
	 * 
	 */
	
	public java.sql.Date getRegistrationDate(){
		return this.registrationDate;
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

}
