package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import model.FirDetails;
import utility.ConnectionManager;

public class FirDetailsInsertion {
	static boolean result = false;
	
public boolean insertFirDetails(FirDetails FD) {
	
	try {
		String insert_query = "INSERT INTO FIR_DETAILS (FIR_ID,FIR_COMPLAINT_ID,FIR_DATE,FIR_COMPLAINT_USER_ID,FIR_COMPLAINT_TYPE,FIR_FULL_COMPLAINT,FIR_COMPLAINT_DATE,FIR_COMPLAINT_USER_EMAIL,FIR_COMPLAINT_USER_CONTACT,FIR_COMPLAINT_USER_ADDRESS)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		Connection con;
		con = ConnectionManager.getConnection();
		
		PreparedStatement ps = con.prepareStatement(insert_query);
		ps.setInt(1, FD.getFirId());
		ps.setInt(2, FD.getFirComplaintId());
		ps.setDate(3, java.sql.Date.valueOf( FD.getFirDate()));
		ps.setString(4, FD.getFirComplaintUserId());
		ps.setString(5, FD.getFirComplaintType());
		ps.setString(6, FD.getFirFullComplaint());
		ps.setDate(7,java.sql.Date.valueOf( FD.getFirComplaintDate()));
		ps.setString(8, FD.getFirComplaintUserEmail());
		ps.setLong(9, FD.getFirComplaintUserContact());
		ps.setString(10, FD.getFirComplaintUserAddress());
		
//		System.out.println(FD.getFirId());
//		System.out.println(FD.getFirComplaintId());
//		System.out.println(FD.getFirDate());
//		System.out.println(FD.getFirComplaintUserId());
//		System.out.println(FD.getFirComplaintType());
//		System.out.println(FD.getFirFullComplaint());
//		System.out.println(java.sql.Date.valueOf( FD.getFirComplaintDate()));
//		System.out.println(FD.getFirComplaintUserEmail());
//		System.out.println(FD.getFirComplaintUserContact());
//		System.out.println(FD.getFirComplaintUserAddress());
		
		ps.executeUpdate();
		
		result = true;
	}
	catch(Exception e) {
		//System.out.println("----- KINDLY GIVE CORRECT AND PROPER INPUTS ------");
		e.printStackTrace();
	}
	return result;
}
}
