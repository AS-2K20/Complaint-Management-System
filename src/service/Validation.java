package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.AdminLogin;
import model.UserLogin;
import model.UserSignUp;
import utility.ConnectionManager;

public class Validation {
	
	public boolean result = false;
	public boolean userLogin(UserLogin UL) throws IOException, SQLException, ClassNotFoundException {
		
			Connection con = ConnectionManager.getConnection();
	
			String selectSql = "SELECT * FROM USER_LOGIN";
			Statement st = con.createStatement();
			ResultSet resultSet = st.executeQuery(selectSql);
	
			while(resultSet.next()) 
			{
			if(resultSet.getString("USER_ID").equals(UL.getUserId()) && resultSet.getString("USER_PASSWORD").equals(UL.getPassword())) {
				result = true;
				}
			}
			return result;
	}

	public boolean userSignUp(UserSignUp USU) {
				
		String uIdRegEx = "^[a-zA-Z0-9_.]{5,20}$";
		String uNameRegEx = "^[a-zA-z][a-zA-z ].{4,20}$";
		String uEmailRegEx = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		String uPasswordRegEx = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@$_.])(?=\\S+$).{6,20}$";
		
		if(USU.getUserId().matches(uIdRegEx)&&USU.getUserName().matches(uNameRegEx)&&USU.getUserEmail().matches(uEmailRegEx)&&USU.getUserPassword().matches(uPasswordRegEx)) {
			result = true;
		}
		return result;
	}
	
	public boolean adminLogin(AdminLogin aL) throws ClassNotFoundException, IOException, SQLException {
		Connection con = ConnectionManager.getConnection();
		String selectSql = "SELECT * FROM ADMIN_LOGIN";
		Statement st = con.createStatement();
		ResultSet resultSet = st.executeQuery(selectSql);

		while(resultSet.next()) 
		{
		if(resultSet.getString("ADMIN_ID").equals(aL.getAdminId()) && resultSet.getString("ADMIN_PASSWORD").equals(aL.getAdminPassword())) {
			result = true;
			}
		}
		return result;
		
	}
}
