package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import utility.ConnectionManager;

public class GivenComplaintDeletion {
	
	public void withdrawComplaint(int complaintId) throws ClassNotFoundException, IOException, SQLException {
		try {
			int result;
		Connection con = ConnectionManager.getConnection();
		String selectQuery = "DELETE FROM COMPLAINT_DETAILS WHERE COMPLAINT_ID = ?";
		
		PreparedStatement st = con.prepareStatement(selectQuery);
		st.setInt(1,complaintId);
		result = st.executeUpdate();		
		if(result!=0) {
			System.out.println(" DELETION SUCCESSFUL ");
		}
		else {
			System.out.println(" UNABLE TO DELETE THE RECORD ");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println(result);
		//return result;
	}
}
