package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import model.ComplaintDetails;
import utility.ConnectionManager;

public class ComplaintDetailsInsertion {
	static boolean result = false;
	public static boolean CDInsertion(ComplaintDetails CD) {
		 
		String insert_query = "INSERT INTO COMPLAINT_DETAILS(COMPLAINT_ID,COMPLAINT_USER_ID,COMPLAINT_TYPE,FULL_COMPLAINT,COMPLAINT_STATUS,COMPLAINT_DATE,COMPLAINT_USER_EMAIL,COMPLAINT_USER_CONTACT,COMPLAINT_USER_ADDRESS) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			
			Connection con;
			con = ConnectionManager.getConnection();
			
			PreparedStatement ps = con.prepareStatement(insert_query);
			ps.setInt(1, CD.getComplaintId());
			ps.setString(2, CD.getComplaintUserId());
			ps.setString(3, CD.getComplaintType());
			ps.setString(4, CD.getFullComplaint());
			ps.setString(5, CD.getComplaintStatus());
			
			//CHANGING LOCALTIME DATE TO SQL DATE
			ps.setDate(6, java.sql.Date.valueOf( CD.getComplaintDate()));
			ps.setString(7, CD.getComplaintUserEmail());
			ps.setLong(8, CD.getComplaintUserContact());
			ps.setString(9,CD.getComplaintUserAddress());
			
			ps.executeUpdate();
			result = true;
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println("---------------- PLEASE ENTER VALID DETAILS  --------------------------");
		}
		
		return result;		
	}
}