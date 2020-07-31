package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.itextpdf.text.DocumentException;

import model.UserLogin;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException, ClassNotFoundException, DocumentException {
		
		int choice;
		
		//OBJECT CREATION FOR USERSTARTPAGE CLASS
		UserStartPage usp = new UserStartPage();
		
		//OBJECT CREATION FOR ADMINSTARTPAGE CLASS
		AdminStartPage asp = new AdminStartPage();
		
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		
		System.out.println("***********************************************************");
		System.out.println("             CRIMINAL RECORD MANAGEMENT SYSTEM          ");
		System.out.println("***********************************************************");
		
		while(true) {
		System.out.println("--------------------------------");
		System.out.println(" 1. User ");
		System.out.println(" 2. Administrator ");
		System.out.println(" 3. Exit ");
		System.out.println("--------------------------------");
		System.out.println(" Please Enter Your Choice: ");
		choice = Integer.parseInt(br.readLine());
		
		switch(choice) {
			case 1://USER
				usp.UserStart();//USER START PAGE
				break;
			case 2://ADMINISTRATOR
				asp.AdminStart();//ADMIN START PAGE
				break;
			case 3://EXIT
				System.out.println("--------------------------------");
				 System.out.println(" PROGRAM EXECUTION STOPPED ");
				 System.out.println("--------------------------------");
				 System.exit(0);
		}
		
		}
	}
}
