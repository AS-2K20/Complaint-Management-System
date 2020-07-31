package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.FirDetails;
import utility.ConnectionManager;

public class AllFirDetailsSelection {
	public List<FirDetails> showAllFirDetails() {
		List<FirDetails> resultList = new ArrayList<FirDetails>();
		try {
			FirDetails FD = null;
			
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();		
			String selectQuery = "SELECT * FROM FIR_DETAILS";
			ResultSet resultSet = st.executeQuery(selectQuery);
			
			while (resultSet.next()) {
				int fId = resultSet.getInt("FIR_ID");
				int fCid = resultSet.getInt("FIR_COMPLAINT_ID");
				LocalDate fDate = resultSet.getDate("FIR_DATE").toLocalDate();
				String fCuId = resultSet.getString("FIR_COMPLAINT_USER_ID");
				String fCtype = resultSet.getString("FIR_COMPLAINT_TYPE");
				String fFc = resultSet.getString("FIR_FULL_COMPLAINT");
				LocalDate fCd= resultSet.getDate("FIR_COMPLAINT_DATE").toLocalDate();
				String fCuE = resultSet.getString("FIR_COMPLAINT_USER_EMAIL");
				long fCuC = resultSet.getLong("FIR_COMPLAINT_USER_CONTACT");
				String fCuA = resultSet.getString("FIR_COMPLAINT_USER_ADDRESS");
				FD = new FirDetails(fId,fCid,fDate,fCuId,fCtype,fFc,fCd,fCuE,fCuC,fCuA);			
				
				resultList.add(FD);
					}
				}
			catch(Exception e) {
				System.out.println("----- PLEASE CHECK THE GIVEN DETAILS PROPERLY ----- ");
			}
			return resultList;
	}
}
