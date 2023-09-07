package actors;

/**
 * 
 * Class {@code Competition} represents a general competition where boats can enrol 
 * 
 * @author mirko
 *
 */

public class Competition {

	private String name;
	private String ID;
	private java.sql.Date date;
	float partecipationFee;
	
	/**
	 * 
	 * Class constructor
	 *  
	 * @param n name
	 * @param id ID
	 * @param d date
	 * @param pf partecipationFee
	 */
	
	public Competition(String n, String id, java.sql.Date d, float pf) {
		this.name = n;
		this.ID = id;
		this.date = d;
		this.partecipationFee = pf;
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
	 * Get partecipationFee method
	 * 
	 * @return partecipationFee
	 * 
	 */
	
	public float getPartecipationFee() {
		return this.partecipationFee;
	}

}
