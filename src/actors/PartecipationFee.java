package actors;

/**
 * 
 * Class {@code PartecipationFee} represents a partecipation fee associated to a member and a competition 
 * 
 * @author mirko
 *
 */

public class PartecipationFee {

	private String memberID;
	private String boatID;
	private String competitionID;
	
	/**
	 * 
	 * Class constructor
	 *  
	 * @param mid memberID
	 * @param bid boatID
	 * @param cid competitionID

	 */
	
	public PartecipationFee(String mid, String bid, String cid) {
		this.memberID = mid;
		this.boatID = bid;
		this.competitionID = cid;
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
	 * Get competitionID method
	 * 
	 * @return competitionID
	 * 
	 */
	
	public String getCompetitionID() {
		return this.competitionID;
	}

}
