package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.UserSignUp;
import utility.ConnectionManager;

public class UserSignUpDetailsInsertion {
	public boolean result = false;
	public boolean userSUDInsertion(UserSignUp USU) {
		
		
		String insert_query = "INSERT INTO USER_LOGIN (USER_ID,USER_NAME,USER_EMAIL,USER_PASSWORD) VALUES(?,?,?,?)";
		try {
			Connection con ;
			con = ConnectionManager.getConnection();
			
			PreparedStatement ps = con.prepareStatement(insert_query);
			ps.setString(1,USU.getUserId());
			ps.setString(2,USU.getUserName());
			ps.setString(3,USU.getUserEmail());
			ps.setString(4,USU.getUserPassword());
			ps.executeUpdate();
			result = true;
		}
		catch(Exception e) 
		{
			//e.printStackTrace();
			System.out.println("---------------- PLEASE ENTER VALID DETAILS  --------------------------");
		}
		return result;
	}
}
