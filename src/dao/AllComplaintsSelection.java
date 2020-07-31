package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.ComplaintDetails;
import utility.ConnectionManager;

public class AllComplaintsSelection {
	public List<ComplaintDetails> showAllComplaints(){
		List<ComplaintDetails> resultList = new ArrayList<ComplaintDetails>();
		try {
		ComplaintDetails CD = null;
		
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();		
		String selectQuery = "SELECT * FROM COMPLAINT_DETAILS";
		ResultSet resultSet = st.executeQuery(selectQuery);
		
		while (resultSet.next()) {
			int cId = resultSet.getInt("COMPLAINT_ID");
			String cUid = resultSet.getString("COMPLAINT_USER_ID");
			String cType = resultSet.getString("COMPLAINT_TYPE");
			String fComplaint = resultSet.getString("FULL_COMPLAINT");
			String cStatus = resultSet.getString("COMPLAINT_STATUS");
			LocalDate cDate = resultSet.getDate("COMPLAINT_DATE").toLocalDate();
			String cUserEmail = resultSet.getString("COMPLAINT_USER_EMAIL");
			long cUserContact= resultSet.getLong("COMPLAINT_USER_CONTACT");
			String cUserAddress = resultSet.getString("COMPLAINT_USER_ADDRESS");
			CD = new ComplaintDetails(cId,cUid,cType,fComplaint,cStatus,cDate,cUserEmail,cUserContact,cUserAddress);			
			
			resultList.add(CD);
				}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}
}
