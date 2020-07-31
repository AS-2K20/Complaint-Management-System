package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utility.ConnectionManager;

public class ComplaintUpdation{
	public void complaintUpdate(int complaintId) {
		try {
			Connection con = ConnectionManager.getConnection();
			String updateQuery = "UPDATE COMPLAINT_DETAILS SET COMPLAINT_STATUS = ? WHERE COMPLAINT_ID = ? ";
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setString(1," INVESTIGATION GOING ON ");
			ps.setInt(2, complaintId);
			ps.executeUpdate();			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
