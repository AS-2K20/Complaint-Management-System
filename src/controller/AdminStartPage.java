package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.itextpdf.text.DocumentException;

import model.AdminLogin;
import service.Validation;

public class AdminStartPage {
	public void AdminStart() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, DocumentException {
		int choice;
		String adminId;
		String adminPassword;
		
		//CREATING OBJECT FOR VALIDATION CLASS
		Validation Validate = new Validation();
		
		// Creating object for the Class AdminLogin
		AdminLogin AL = null;
		
		AdminChoice AC = new AdminChoice();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			 System.out.println("-----------------------------------------------");
			 System.out.println(" 1. Admin Login ");
			 System.out.println(" 2. Previous Menu ");
			 System.out.println(" 3. Exit ");
			 System.out.println("-----------------------------------------------");
			 System.out.println(" PLEASE ENTER YOUR CHOICE: ");
			 choice = Integer.parseInt(br.readLine());
			 
			 switch(choice) {
			 case 1://Admin Login
				 System.out.println("-----------------------------------------------");
				 System.out.println("                 ADMIN LOGIN                    ");
				 System.out.println("-----------------------------------------------");
				 System.out.println(" Enter Admin ID: ");
				 adminId = br.readLine();
				 System.out.println(" Enter Admin Password: ");
				 adminPassword = br.readLine();
				 AL = new AdminLogin(adminId,adminPassword);
				 Validate.adminLogin(AL);
				 if(Validate.adminLogin(AL)==true) {
					System.out.println(" ADMIN LOGIN SUCCESSFULL ");
					System.out.println();
					
					//Redirecting to AdminChoice Class	
					AC.adminChoice();
				 }
				 else {
					 System.out.println(" PLEASE ENTER VALID ADMIN LOGIN DETAILS ");
				 }
				 break;
			 case 2://Going To Previous Menu
				 break;
			 case 3://Program Execution Stopped
				 System.out.println("--------------------------------");
				 System.out.println(" PROGRAM EXECUTION STOPPED ");
				 System.out.println("--------------------------------");
				 System.exit(0);
			 }
		}
		while(choice>0 && choice<=2) ;
		
	}
}
