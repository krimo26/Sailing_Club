package actors;

/**
 * 
 * Class {@code PartecipationExtended} represents a class used to represent partecipants in JavaFX 
 * 
 * @author mirko
 *
 */

public class PartecipationExtended {
	
	private String memberUsername;
	private String boatName;
	private String competitionName;
	private String memberID;
	private String boatID;
	private java.sql.Date date;
	private float value;

	/**
	 * 
	 * Class constructor
	 *  
	 * @param member memberUsername
	 * @param boat boatName
	 * @param comp competitionName
	 * @param mid memberID
	 * @param d date
	 * @param v value
	 */
	
	public PartecipationExtended(String member, String boat, String comp, String mid, String bid, java.sql.Date d, float v) {
		this.memberUsername = member;
		this.boatName = boat;
		this.competitionName = comp;
		this.memberID = mid;
		this.boatID = bid;
		this.date = d;
		this.value = v;
	}
	
	/**
	 * 
	 * Get memberUsername method
	 * 
	 * @return memberUsername
	 * 
	 */
	
	public String getMember() {
		return this.memberUsername;
	}
	
	/**
	 * 
	 * Get boatName method
	 * 
	 * @return boatName
	 * 
	 */
	
	public String getBoat() {
		return this.boatName;
	}
	
	/**
	 * 
	 * Get competitionName method
	 * 
	 * @return competitionName
	 * 
	 */
	
	public String getCompetition() {
		return this.competitionName;
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
	
	public java.sql.Date getDate() {
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
	
}
