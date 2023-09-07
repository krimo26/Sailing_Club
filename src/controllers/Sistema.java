package controllers;

/**
 * 
 * Class {@code Sistema} main class that contains all the operations
 * 
 * @author mirko
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import actors.Boat;
import actors.Card;
import actors.Competition;
import actors.Member;
import actors.MembershipFee;
import actors.Notification;
import actors.PartecipationExtended;
import actors.Staff;
import actors.StorageFee;
import actors.Transfer;

public class Sistema {
	
	private String DBURL;
	private Connection con;
	private Statement stmt;
	
	private Member memberLogged;
	private Staff staffLogged;
	
	private String membershipFeeValue;
	
	private String url;
	
	private boolean paymentSuccess;
	
	private Competition compRequested;
	
	private static Sistema istance=null;
	
	/**
	 * 
	 * Singleton pattern: method to get access to Sistema from all the controllers
	 * 
	 * @return istance
	 * 
	 */
	
	public static Sistema getIstance() {
		if(istance==null) {
			istance = new Sistema();
		}
		return istance;
	 }

	/**
	 * 
	 * Class constructor:
	 * 		sets database URL
	 * 		sets membershipFeeValue
	 * 
	 */
	
	public Sistema() {
		
		this.DBURL = "jdbc:mysql://localhost:3306/SailingClub";
		this.membershipFeeValue = "250";
	}
	
	/**
	 * Start method:
	 * 		connection to the database
	 * 
	 */
	
	public void start() {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con=DriverManager.getConnection(this.DBURL, "root", "");
			this.stmt=this.con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Get url method:
	 * 		used to get url for the manuals
	 * @return url
	 * 
	 */
	
	public String getURL() {
		return this.url;
	}
	
	/**
	 * 
	 * Set url method:
	 * 		used to set url for the manuals
	 * 
	 * @param s url
	 */
	
	public void setURL(String s) {
		this.url = s;
	}
	
	/**
	 * 
	 * Login method for Member
	 * 
	 * @param username username
	 * @param password password
	 * @return success
	 * 
	 */
	
	public boolean loginMember(String username, String password) {
		try {
			
    		String sql = "select Name, Lastname, ID, Address, Username, Password, RegistrationD from Member where Username= '"+username+"' and Password= '"+password+"'";
    		ResultSet rs = this.stmt.executeQuery(sql);
    		
    		if(rs.next()) { 
    			this.memberLogged = new Member(rs.getString("Name"), rs.getString("Lastname"),rs.getString("ID"),
    					rs.getString("Address"), rs.getString("Username"), rs.getString("Password"), rs.getDate("RegistrationD"));
    			return true;
    		} 
    		else {
    			return false;
    		}

		}catch(Exception e) {
    		e.printStackTrace();
    		return false;
    		}
		
	}
	
	/**
	 * 
	 * Login method for Staff
	 * 
	 * @param username username
	 * @param password password
	 * @return success
	 */
	
	public boolean loginStaff(String username, String password) {
		try {
			
    		String sql = "select Username, Password from Staff where Username= '"+username+"' and Password= '"+password+"'";
    		ResultSet rs = this.stmt.executeQuery(sql);
    		
    		if(rs.next()) { 
    			this.staffLogged = new Staff (rs.getString("Username"), rs.getString("Password"));
    			return true;
    		} 
    		else {
    			return false;
    		}

		}catch(Exception e) {
    		e.printStackTrace();
    		return false;
    		}
	}
	
	/**
	 * 
	 * Registration method for staff
	 * 
	 * @param name name
	 * @param lastname lastname
	 * @param id id
	 * @param address address
	 * @param username username
	 * @param password password
	 * @return success
	 */
	
	public boolean registration(String name, String lastname, String id, String address, String username, String password) {
		if(name.length()!=0 && lastname.length()!=0 && id.length()!=0 && username.length()!=0 && password.length()!=0) {
			try { 

    		String sql="Select Username from Member where Username ='"+username+"'";
    		ResultSet rs = this.stmt.executeQuery(sql);
    		
    		if(rs.next()) {
    			System.out.println("Username already in use");
    			return false;
    		} 
    		
    		else {

    			Calendar c = Calendar.getInstance();
	    		c.add(Calendar.YEAR, 1);
	    		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    		String newdate = format.format(c.getTime()); 
	    		
	    		String sql1="insert into Member(Name, Lastname, ID, Address, Username, Password, RegistrationD) values ('"+name+"','"+lastname+"','"+id+"','"+address+"','"+username+"','"+password+"',DEFAULT)";
	    		this.stmt.executeUpdate(sql1);
	    		
	    		String sql2="insert into MembershipFee(MemberID, Date, Value, Paid) values ('"+id+"','"+newdate+"','"+this.membershipFeeValue+"' ,'0')";
	    		this.stmt.executeUpdate(sql2);
	    		
	    		String sql3 = "select Name, Lastname, ID, Address, Username, Password, RegistrationD from Member where Username= '"+username+"' and Password= '"+password+"'";
	    		ResultSet rs3 = this.stmt.executeQuery(sql3);
	    		if (rs3.next()) {
		    		this.memberLogged = new Member(rs3.getString("Name"), rs3.getString("Lastname"),rs3.getString("ID"),
	    					rs3.getString("Address"), rs3.getString("Username"), rs3.getString("Password"), rs3.getDate("RegistrationD"));
		    		return true;
	    		}
	    		else {
	    			return false;
	    		}
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		return false;
    		}
    	}
    	
    	else {
			return false;
    	}
	}
	
	/**
	 * 
	 * Get memberLogged method
	 * 
	 * @return memberLogged
	 * 
	 */
	
	public Member getMemberLogged() {
		return this.memberLogged;
	}
	
	/**
	 * 
	 * Get staffLogged method
	 * 
	 * @return staffLogged
	 */
	
	public Staff getStaffLogged() {
		return this.staffLogged;
	}
	
	/**
	 * 
	 * Member logout method
	 * 
	 */
	
	public void memberLogout() {
		this.memberLogged = new Member();
	}
	
	/**
	 * 
	 * Staff logout method
	 * 
	 */
	
	public void staffLogout() {
		this.staffLogged = new Staff();
	}
	
	/**
	 * 
	 * Edit memberLooged address
	 * @param address address
	 * @return success
	 * 
	 */
	
	public boolean editMemberAddress(String address) {
		
		if(address.length() != 0) {
			try {
	    		String sql = "update Member set Address='"+address+"' where ID='"+this.memberLogged.getID()+"'";
	    		int rs = this.stmt.executeUpdate(sql);
	    		
	    		if(rs != 0) { 
	    			this.memberLogged.setAddress(address);
	    			return true;
	    		} 
	    		else {
	    			return false;
	    		}
	
			}catch(Exception e) {
	    		e.printStackTrace();
	    		return false;
	    		}
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * Edit memberLogged username
	 * @param username username
	 * @return success
	 */
	
	public boolean editMemberUsername(String username) {
		
		if(username.length() != 0) {
			try {
	    		String sql = "update Member set Username='"+username+"' where ID='"+this.memberLogged.getID()+"'";
	    		int rs = this.stmt.executeUpdate(sql);
	    		
	    		if(rs != 0) { 
	    			this.memberLogged.setUsername(username);
	    			return true;
	    		} 
	    		else {
	    			return false;
	    		}
	
			}catch(Exception e) {
	    		e.printStackTrace();
	    		return false;
	    		}
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * Edit memberLogged password
	 * 
	 * @param password password
	 * @return success
	 * 
	 */
	
	public boolean editMemberPassword(String password) {	
		if(password.length() != 0) {
			try {
	    		String sql = "update Member set Password='"+password+"' where ID='"+this.memberLogged.getID()+"'";
	    		int rs = this.stmt.executeUpdate(sql);
	    		
	    		if(rs != 0) { 
	    			this.memberLogged.setPassword(password);
	    			return true;
	    		} 
	    		else {
	    			return false;
	    		}
	
			}catch(Exception e) {
	    		e.printStackTrace();
	    		return false;
	    		}
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * Get cards list associated to memberLogged
	 * @return cardsList
	 * 
	 */
	
	public ArrayList<Card> getCardsList() {
		
		
		ArrayList<Card> list = new ArrayList<Card>();
		
		try {
			String sql = "select Code, Password from Card where MemberID='"+this.memberLogged.getID()+"'";
			ResultSet rs = this.stmt.executeQuery(sql);
			
			while (rs.next()) {
				Card tempcard = new Card(this.memberLogged.getID(), rs.getString("Code"), rs.getString("Password"));
				list.add(tempcard);
			}
		}catch(Exception e) {
    		e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * Get transfer list associated to memberLogged
	 * 
	 * @return success
	 */
	
	public ArrayList<Transfer> getTransfersList() {
	
		ArrayList<Transfer> list = new ArrayList<Transfer>();
		
		try {
			String sql = "select Code, Used from Transfer where MemberID='"+this.memberLogged.getID()+"'";
			ResultSet rs = this.stmt.executeQuery(sql);
			
			while (rs.next()) {
				Transfer temptransfer = new Transfer(this.memberLogged.getID(), rs.getString("Code"), rs.getInt("Used"));
				list.add(temptransfer);
			}
		}catch(Exception e) {
    		e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * Add new card method
	 * 
	 * @param code code
	 * @param password password
	 * @return success
	 * 
	 */
	
	boolean addCard(String code, String password) {
		if(code.length()==16 && password.length()!=0) {
			try {	 

	    		String sql="Select Code from Card where Code ='"+code+"'";
	    		ResultSet rs = this.stmt.executeQuery(sql);
	    		
	    		if(rs.next()) {
	    			System.out.println("Card already exists");
	    			return false;
	    		} 
	    		
	    		else {
		    		String sql1="insert into Card(MemberID, Code, Password) values ('"+this.memberLogged.getID()+"','"+code+"','"+password+"')";
		    		this.stmt.executeUpdate(sql1);
		    		return true;
	    		}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * Add new transfer method
	 * 
	 * @param code code
	 * @return success
	 * 
	 */
	
	boolean addTransfer(String code) {
		if(code.length()==16) {
			try {	 

	    		String sql="Select Code from Transfer where Code ='"+code+"'";
	    		ResultSet rs = this.stmt.executeQuery(sql);
	    		
	    		if(rs.next()) {
	    			System.out.println("Transfer already exists");
	    			return false;
	    		} 
	    		
	    		else {
		    		String sql1="insert into Transfer(MemberID, Code, Used) values ('"+this.memberLogged.getID()+"','"+code+"', 0)";
		    		this.stmt.executeUpdate(sql1);
		    		return true;
	    		}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * Get boat list associated to memberLogged
	 * 
	 * @return boatList
	 * 
	 */
	
	public ArrayList<Boat> getBoatsList() {
		
		ArrayList<Boat> list = new ArrayList<Boat>();
		
		try {
			String sql = "select Name, ID, StorageF, RegistrationD from Boat where MemberID='"+this.memberLogged.getID()+"'";
			ResultSet rs = this.stmt.executeQuery(sql);
			
			while (rs.next()) {
				Boat tempboat = new Boat(rs.getString("Name"),rs.getString("ID"),rs.getFloat("StorageF"),rs.getDate("RegistrationD"), this.memberLogged.getID());
				list.add(tempboat);
			}
		}catch(Exception e) {
    		e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * Get competition list
	 * 
	 * @return competitionList
	 * 
	 */
	
	public ArrayList<Competition> getCompetitionsList(){
		ArrayList<Competition> list = new ArrayList<Competition>();
		
		try {
			String sql = "select Name, ID, Date, PartecipationF from Competition order by Date";
			ResultSet rs = this.stmt.executeQuery(sql);
			
			while (rs.next()) {
				Competition tempcomp = new Competition(rs.getString("Name"),rs.getString("ID"),rs.getDate("Date"),rs.getFloat("PartecipationF"));
				list.add(tempcomp);
			}
		}catch(Exception e) {
    		e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * 
	 * Add new boat method
	 * 
	 * @param name name
	 * @param id ID
	 * @param sf storageFee
	 * @return success
	 * 
	 */
	
	public boolean addBoat(String name, String id, float sf) {
		if(name.length() > 0 && id.length()==6 && sf > 0) {
			try {	 

	    		String sql="Select ID from Boat where ID ='"+id+"'";
	    		ResultSet rs = this.stmt.executeQuery(sql);
	    		
	    		if(rs.next()) {
	    			System.out.println("Boat already exists");
	    			return false;
	    		} 
	    		
	    		else {
	    			String fee = Float.toString(sf);
	    			
	    			Calendar c = Calendar.getInstance();
		    		c.add(Calendar.YEAR, 1);
		    		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    		String newdate = format.format(c.getTime()); 
	    			
		    		String sql1="insert into Boat(Name, ID, StorageF, RegistrationD, MemberID) values ('"+name+"','"+id+"','"+fee+"',DEFAULT,'"+this.memberLogged.getID()+"')";
		    		this.stmt.executeUpdate(sql1);
		    		
		    		String sql2="insert into StorageFee(MemberID, BoatID, BoatName, Date, Value, Paid) values ('"+this.getMemberLogged().getID()+"','"+id+"','"+name+"','"+newdate+"','"+fee+"','0')";
		    		this.stmt.executeUpdate(sql2);
		    		
		    		return true;
	    		}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Remove boat method
	 * 
	 * @param id id
	 * @return success
	 * 
	 */
	
	public boolean removeBoat(String id) {
		if(id.length() == 6) {
			try {	 

	    		String sql="Select ID from Boat where ID ='"+id+"'";
	    		ResultSet rs = this.stmt.executeQuery(sql);
	    		
	    		if(rs.next()) {
		    		String sql1="delete from Boat where ID='"+id+"'";
		    		this.stmt.executeUpdate(sql1);
		    		String sql2="delete from PartecipationFee where BoatID='"+id+"'";
		    		this.stmt.executeUpdate(sql2);
		    		String sql3="delete from StorageFee where BoatID='"+id+"'";
		    		this.stmt.executeUpdate(sql3);
		    		return true;
	    		} 
	    		
	    		else {
		    		System.out.println("Boat doesn't exist");
	    			return false;
	    		}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * Get partecipation list (competition associated to memberLogged)
	 * 
	 * @return partecipationList
	 * 
	 */
	
	public ArrayList<PartecipationExtended> getPartecipationList() {
		
		ArrayList<PartecipationExtended> list = new ArrayList<PartecipationExtended>();
		
		try {
			String sql = "select M.Username as member, B.Name as boat, C.Name as competition, M.ID as mid, B.ID as bid, C.Date, C.PartecipationF from PartecipationFee P join Member M join Boat B join Competition C "
					+ "where P.MemberID=M.ID and P.BoatID=B.ID and P.CompetitionID=C.ID and M.ID='"+this.memberLogged.getID()+"'";
			ResultSet rs = this.stmt.executeQuery(sql);
			
			while (rs.next()) {
				PartecipationExtended temppart = new PartecipationExtended(rs.getString("member"),rs.getString("boat"),rs.getString("competition"),rs.getString("mid"),rs.getString("bid"),rs.getDate("Date"),rs.getFloat("PartecipationF"));
				list.add(temppart);
			}
		}catch(Exception e) {
    		e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * Check boat enrollment
	 * 
	 * @param boat boatID
	 * @param comp competitionID
	 * @return enrollment
	 * 
	 */
	
	public boolean checkBoat(String boat, String comp) {
		if(boat.length() == 6 && comp.length()==6) {
			try {	 

	    		String sql="Select BoatID, CompetitionID from PartecipationFee where BoatID ='"+boat+"' and CompetitionID='"+comp+"'";
	    		ResultSet rs = this.stmt.executeQuery(sql);
	    		
	    		if(rs.next()) {
	    			System.out.println("Boat already partecipates");
	    			return false;
	    		} 
	    		
	    		else {
		    		return true;
	    		}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
		
	}
	
	/**
	 * 
	 * Enroll boat to a competition method
	 * @param boat boatID
	 * @param comp competitioID
	 * @return success
	 * 
	 */
	
	public boolean enrolBoat(String boat, String comp) {
		if(boat.length() == 6 && comp.length()==6) {
			try {	 
	    		String sql1="insert into PartecipationFee(MemberID, BoatID, CompetitionID) values ('"+this.memberLogged.getID()+"','"+boat+"','"+comp+"')";
	    		this.stmt.executeUpdate(sql1);
	    		return true;
	    		
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * Edit staff password method
	 * 
	 * @param password password
	 * @return success
	 * 
	 */
	
	public boolean editStaffPassword(String password) {	
		if(password.length() != 0) {
			try {
	    		String sql = "update Staff set Password='"+password+"' where Username='"+this.staffLogged.getUsername()+"'";
	    		int rs = this.stmt.executeUpdate(sql);
	    		
	    		if(rs != 0) { 
	    			this.staffLogged.setPassword(password);
	    			return true;
	    		} 
	    		else {
	    			return false;
	    		}
	
			}catch(Exception e) {
	    		e.printStackTrace();
	    		return false;
	    		}
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * Get requested competition method
	 * 
	 * @param s competitionID
	 * @return success
	 * 
	 */
	
	public boolean requestCompetition(String s) {

		try {
			
    		String sql = "select Name, ID, Date, PartecipationF from Competition where ID= '"+s+"'";
    		ResultSet rs = this.stmt.executeQuery(sql);
    		
    		if(rs.next()) { 
    			this.compRequested = new Competition(rs.getString("Name"), rs.getString("ID"),rs.getDate("Date"), rs.getFloat("PartecipationF"));
    			return true;
    		} 
    		else {
    			return false;
    		}

		}catch(Exception e) {
    		e.printStackTrace();
    		return false;
    		}
		
	}
	
	/**
	 * 
	 * Get requested competition method
	 * 
	 * @return success
	 * 
	 */
	
	public Competition getCompRequested() {
		return this.compRequested;
	}
	
	/**
	 * 
	 * Get participants of a specific competition method
	 * 
	 * @return partecipationList
	 * 
	 */
	
	public ArrayList<PartecipationExtended> getCompPartList() {
		
		ArrayList<PartecipationExtended> list = new ArrayList<PartecipationExtended>();
		
		try {
			String sql = "select M.Username as member, B.Name as boat, C.Name as competition, M.ID as mid, B.ID as bid, C.Date, C.PartecipationF from PartecipationFee P join Member M join Boat B join Competition C "
					+ "where P.MemberID=M.ID and P.BoatID=B.ID and P.CompetitionID=C.ID and C.ID='"+this.compRequested.getID()+"'";
			ResultSet rs = this.stmt.executeQuery(sql);
			
			while (rs.next()) {
				PartecipationExtended temppart = new PartecipationExtended(rs.getString("member"),rs.getString("boat"),rs.getString("competition"),rs.getString("mid"),rs.getString("bid"),rs.getDate("Date"),rs.getFloat("PartecipationF"));
				list.add(temppart);
			}
		}catch(Exception e) {
    		e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * Pay with card method
	 * 
	 * @param code code
	 * @param password password
	 * @return success
	 * 
	 */
	
	public boolean payCard(String code, String password) {
		
		try {
			
    		String sql = "select MemberID, Code, Password from Card where MemberID= '"+this.memberLogged.getID()+"' and Code= '"+code+"' and Password= '"+password+"'";
    		ResultSet rs = this.stmt.executeQuery(sql);
    		
    		if(rs.next()) { 
    			this.paymentSuccess = true;
    			return true;
    			
    		} 
    		else {
    			this.paymentSuccess = false;
    			return false;
    		}

		}catch(Exception e) {
    		e.printStackTrace();
    		return false;
    		}
	}
	
	/**
	 * 
	 * Pay with transfer method
	 * 
	 * @param code code
	 * @return success
	 * 
	 */
	
	public boolean payTransfer(String code) {
		try {
			
    		String sql = "select MemberID, Code from Transfer where MemberID= '"+this.memberLogged.getID()+"' and Code= '"+code+"'";
    		ResultSet rs = this.stmt.executeQuery(sql);
    		
    		if(rs.next()) { 
    			String sql1 = "delete from Transfer where Code='"+code+"'";
    			this.stmt.executeUpdate(sql1);
    			this.paymentSuccess = true;
    			return true;
    		} 
    		else {
    			this.paymentSuccess = false;
    			return false;
    		}

		}catch(Exception e) {
    		e.printStackTrace();
    		this.paymentSuccess = false;
    		return false;
    	}
	}
		
	/**
	 * 
	 * Get expiring membership fee date method
	 * @return date
	 * 
	 */
	
	public String getExpirementMemberhipFee() {
		try {
			String sql = "select Date from MembershipFee where MemberID='"+this.memberLogged.getID()+"'";
			ResultSet rs = this.stmt.executeQuery(sql);
			if (rs.next()) {
				Date exdate = rs.getDate("Date");
				String stdate = exdate.toString();
				return stdate;
			}
			else {
				return "errore";
			}
			
			
		}catch(Exception e) {
    		e.printStackTrace();
    		return "errore";
		}
	}
	
	/**
	 * 
	 * Get membership fee method
	 * 
	 * @return membershipFeeList
	 * 
	 */
	
	public ArrayList<MembershipFee> getMembershipFee(){
		
		ArrayList<MembershipFee> list = new ArrayList<MembershipFee>();
		
		try {
			String sql = "select MemberID, Date, Value from MembershipFee order by Date";
			ResultSet rs = this.stmt.executeQuery(sql);
			
			while (rs.next()) {
				MembershipFee tempfee = new MembershipFee(rs.getString("MemberID"),rs.getDate("Date"),rs.getFloat("value"), 0);
				list.add(tempfee);
			}
		}catch(Exception e) {
    		e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * 
	 * Get membership fee list associated with memberLogged 
	 * 
	 * @param id id
	 * @return membershipFeeList
	 */
	
	public ArrayList<MembershipFee> getMyMebershipFee(String id){
		
		ArrayList<MembershipFee> list = new ArrayList<MembershipFee>();
		
		try {
			String sql = "select MemberID, Date, Value from MembershipFee where MemberID='"+id+"'";
			ResultSet rs = this.stmt.executeQuery(sql);
			
			while (rs.next()) {
				MembershipFee tempfee = new MembershipFee(rs.getString("MemberID"),rs.getDate("Date"),rs.getFloat("value"), 0);
				list.add(tempfee);
			}
		}catch(Exception e) {
    		e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * 
	 * Check membership fee method
	 * (check existence of a membership fee)
	 * 
	 * @return success
	 * 
	 */
	
	public boolean checkMembershipFee() {
			try {	 

	    		String sql="Select MemberID, Date, Value from MembershipFee where MemberID ='"+this.memberLogged.getID()+"'";
	    		ResultSet rs = this.stmt.executeQuery(sql);
	    		
	    		if(rs.next()) {
	    			
	    			return true;
	    		} 
	    		
	    		else {
	    			System.out.println("Fee does not exist");
		    		return true;
	    		}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	
	/**
	 * 
	 * Pay membership fee method
	 * 
	 * @return success
	 * 
	 */
	
	public boolean payMembershipFee() {
			try {	 
				
				String sql="Select Date from MembershipFee where MemberID ='"+this.memberLogged.getID()+"'";
	    		ResultSet rs = this.stmt.executeQuery(sql);
			    if (rs.next()) {
		    		Calendar c = Calendar.getInstance();
		    		Date olddate = rs.getDate("Date");
		    		c.setTime(olddate);
		    		c.add(Calendar.YEAR, 1);
		    		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    		String newdate = format.format(c.getTime()); 	    		
		    		String sql1 = "update MembershipFee set Date='"+newdate+"' where MemberID='"+this.memberLogged.getID()+"'";
		    		this.stmt.executeUpdate(sql1);
		    		String sql2="delete from Notification where Type='MEM' and MemberID='"+this.memberLogged.getID()+"' and Date='"+olddate+"'";
		    		this.stmt.executeUpdate(sql2);
		    		this.paymentSuccess = true;
		    		return true;
			    }
			    else {
			    	this.paymentSuccess = false;
			    	return false;
			    }
			}catch(Exception e) {
				e.printStackTrace();
				this.paymentSuccess = false;
				return false;
			}
		
		
	}
	
	/**
	 * 
	 * Get storage fee list method
	 * 
	 * @return storageFeeList 
	 * 
	 */
	
	public ArrayList<StorageFee> getStorageFee(){
		
		ArrayList<StorageFee> list = new ArrayList<StorageFee>();
		
		try {
			String sql = "select MemberID, BoatID, BoatName, Date, Value from StorageFee order by Date";
			ResultSet rs = this.stmt.executeQuery(sql);
			
			while (rs.next()) {
				StorageFee tempfee = new StorageFee(rs.getString("MemberID"),rs.getString("BoatID"),rs.getString("BoatName"),rs.getDate("Date"),rs.getFloat("value"), 0);
				list.add(tempfee);
			}
		}catch(Exception e) {
    		e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * 
	 * Get storage fee list associated to memberLogged
	 * 
	 * @return storageFee list
	 * 
	 */
	
	public ArrayList<StorageFee> getMyStorageFee(){
		
		ArrayList<StorageFee> list = new ArrayList<StorageFee>();
		
		try {
			String sql = "select MemberID, BoatID, BoatName, Date, Value from StorageFee where MemberID='"+this.memberLogged.getID()+"' order by Date";
			ResultSet rs = this.stmt.executeQuery(sql);
			
			while (rs.next()) {
				StorageFee tempfee = new StorageFee(rs.getString("MemberID"),rs.getString("BoatID"),rs.getString("BoatName"),rs.getDate("Date"),rs.getFloat("value"), 0);
				list.add(tempfee);
			}
		}catch(Exception e) {
    		e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * 
	 * Check storage fee method
	 * (check existence of a storage fee associated to a boat)
	 * 
	 * @param bid boatID
	 * @return storageFee list
	 * 
	 */
	
	public boolean checkStorageFee(String bid) {
		
		if(bid.length()==6) {
			
			try {	 

	    		String sql="Select MemberID, BoatID, Date, Value from StorageFee where MemberID ='"+this.memberLogged.getID()+"' and BoatID='"+bid+"'";
	    		ResultSet rs = this.stmt.executeQuery(sql);
	    		
	    		if(rs.next()) {
	    			
	    			return true;
	    		} 
	    		
	    		else {
	    			System.out.println("Fee does not exist");
		    		return false;
	    		}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * Pay storage fee method
	 * 
	 * @param bid boatID
	 * @return success
	 * 
	 */
	
	public boolean payStorageFee(String bid) {
		try {	 
			
			String sql="Select Date from StorageFee where MemberID ='"+this.memberLogged.getID()+"' and BoatID='"+bid+"'";
    		ResultSet rs = this.stmt.executeQuery(sql);
		    if (rs.next()) {
	    		Calendar c = Calendar.getInstance();
	    		Date olddate = rs.getDate("Date");
	    		c.setTime(olddate);
	    		c.add(Calendar.YEAR, 1);
	    		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    		String newdate = format.format(c.getTime()); 	    		
	    		String sql1 = "update StorageFee set Date='"+newdate+"' where MemberID='"+this.memberLogged.getID()+"' and BoatID='"+bid+"'";
	    		this.stmt.executeUpdate(sql1);
	    		String sql2="delete from Notification where Type='STO' and MemberID='"+this.memberLogged.getID()+"' and BoatID='"+bid+"' and Date='"+olddate+"'";
	    		this.stmt.executeUpdate(sql2);
	    		this.paymentSuccess = true;
	    		return true;
		    }
		    else {
		    	this.paymentSuccess = false;
		    	return false;
		    }
		}catch(Exception e) {
			e.printStackTrace();
			this.paymentSuccess = false;
			return false;
		}
	
	
	}
	
	/**
	 * 
	 * Get payment success
	 * 
	 * @return success
	 * 
	 */
	
	public boolean getPaymentSuccess() {
		boolean result = this.paymentSuccess;
		this.paymentSuccess = false;
		return result;
	}
	
	/**
	 * 
	 * Send membership fee notification method
	 * 
	 * @param id id
	 * @return success
	 * 
	 */
	
	public boolean sendMembershipNotification(String id) {
		
			try {	 

	    		String sql="Select MemberID, Value, Date from MembershipFee where MemberID ='"+id+"'";
	    		ResultSet rs = this.stmt.executeQuery(sql);
	    		
	    		if(rs.next()) {
	    			float value = rs.getFloat("Value");
	    			String sql1="insert into Notification(Type, Value, MemberID, BoatID, Date) values ('MEM','"+value+"','"+id+"', DEFAULT,'"+rs.getDate("Date")+"')";
		    		this.stmt.executeUpdate(sql1);
		    		return true;
	    		} 
	    		
	    		else {
		    		
		    		System.out.println("No fee");
	    			return false;
	    		}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		
		
	}
	
	/**
	 * 
	 * Send storage fee notification method
	 * 
	 * @param mid memberID
	 * @param bid boatId
	 * @return success
	 * 
	 */
	
	public boolean sendStorageNotification(String mid, String bid) {
		
		try {	 

    		String sql="Select MemberID, BoatID, Value, Date from StorageFee where MemberID ='"+mid+"' and BoatID='"+bid+"'";
    		ResultSet rs = this.stmt.executeQuery(sql);
    		
    		if(rs.next()) {
    			float value = rs.getFloat("Value");
    			String sql1="insert into Notification(Type, Value, MemberID, BoatID, Date) values ('STO','"+value+"','"+mid+"','"+bid+"','"+rs.getDate("Date")+"')";
	    		this.stmt.executeUpdate(sql1);
	    		return true;
    		} 
    		
    		else {
	    		
	    		System.out.println("No fee");
    			return false;
    		}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	
	
	}
	
	/**
	 * 
	 * Get notification list method
	 * 
	 * @return notification list
	 * 
	 */
	
	public ArrayList<Notification> getNotification(){
		
		ArrayList<Notification> list = new ArrayList<Notification>();
		
		try {
			String sql = "select Type, Value, MemberID, BoatID, Date from Notification where MemberID='"+this.memberLogged.getID()+"'";
			ResultSet rs = this.stmt.executeQuery(sql);
			
			while (rs.next()) {
				Notification tempfee = new Notification(rs.getString("Type"),rs.getFloat("Value"),rs.getString("MemberID"),rs.getString("BoatID"),rs.getDate("Date"));
				list.add(tempfee);
			}
		}catch(Exception e) {
    		e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 
	 * End system method
	 * (close connection to database)
	 * 
	 */
	
	public void endSystem() {
		try{
			this.con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
	
	
