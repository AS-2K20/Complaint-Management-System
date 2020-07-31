package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.itextpdf.text.DocumentException;

import dao.UserSignUpDetailsInsertion;
import model.UserLogin;
import model.UserSignUp;
import service.Validation;

public class UserStartPage {
 public void UserStart() throws NumberFormatException, IOException, SQLException, ClassNotFoundException, DocumentException {
	 
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 int choice;
	 String userName,userId,userEmail,userPassword;
	//VALIDATION CLASS OBJECT CREATION
	 Validation validate = new Validation();
	
	 //USERCHOICE CLASS OBJECT CREATION
	 UserChoice uc = new UserChoice(); 
	 
	 UserSignUpDetailsInsertion uSignUpDetailsInsertion = new UserSignUpDetailsInsertion();
	 //UserSignUpDetailsInsertion OBJECT CREATION
	 
	 //CREATING OBJECTS FOR USERSIGNUP CLASS 
	 UserSignUp USU = null;//null is used because I am getting values from user after this 
	 
	//CREATING OBJECTS FOR USERLOGIN CLASS
	 UserLogin UL = null;
	 
	 do 
	 {
		 System.out.println(" 1. User SignUp ");
		 System.out.println(" 2. User Login ");
		 System.out.println(" 3. Previous Menu ");
		 System.out.println(" 4. Exit ");
		 System.out.println("--------------------------------");
		 System.out.println(" Please Enter Your Choice: ");
		 choice = Integer.parseInt(br.readLine());
		 
		 switch(choice) {
		 case 1: //USER SIGNUP
			 System.out.println("----------------------");
			 System.out.println(" User SignUp ");
			 System.out.println("----------------------");
			 System.out.println("******* INSTRUCTIONS *******");
			 System.out.println("The User ID must start with an Lower Case");
			 System.out.println("The User ID and User Password Length must be atleast 6 characters and must not exceed 20 characters ");
			 System.out.println("The User ID and User Password must have atleast 1 UpperCase, 1 LowerCase and 1 number");
			 System.out.println("The User Password must contain atleast 1 following special characters @$_.");
			 System.out.println("The User Email must be a valid one");
			 System.out.println("The User ID can contain special characters _ and .");
			 System.out.println("The User Name can have Space character");			
			 System.out.println("The User Name Length must be atleast 3 characters and must not exceed 20 characters");
			 System.out.println("*********************************");
			 
			 System.out.println(" Enter User Id: ");
			 userId = br.readLine();
			 System.out.println(" Enter User Name: ");
			 userName = br.readLine();
			 System.out.println(" Enter User Email: ");
			 userEmail = br.readLine();
			 System.out.println(" Enter User Password: ");
			 userPassword = br.readLine();
			 
			 //INITIALISING THE CONSTRUCTOR WITH THE OBJECT CREATED
			 USU = new UserSignUp(userId,userName,userEmail,userPassword);
			 
			//Passing Object to Validation Class using its Object validate
			 if(validate.userSignUp(USU)==true) 
			 {
				 System.out.println("-------- Validation Successful ---------");
				 
				 //PASSING OBJECT TO userSUDInsertion OF THE CLASS UserSignUpDetailsInsertion
				 if(uSignUpDetailsInsertion.userSUDInsertion(USU)==true) {
				 System.out.println("---------- USER ACCOUNT CREATED SUCCESSFULLY -------------");
				 }
			 }
			 else {
				 System.out.println("---------- PLEASE ENTER CORRECT DETAILS -------------");
			 }
			 break;
			 
		 case 2: //USER LOGIN
			 System.out.println("------------------------------------------");
			 System.out.println("          USER LOGIN        ");
			 System.out.println("------------------------------------------");			 
			 System.out.println(" Enter User Id: ");
			 userId = br.readLine();
			 System.out.println(" Enter User Password: ");
			 userPassword = br.readLine();
			 
			 //Passing User Inputs to UserLogin Constructor class
			 UL = new UserLogin(userId,userPassword);			
			 
			 //Passing Object to Validation Class using its Object validate			 
			 if(validate.userLogin(UL)==true){
				 System.out.println(" LOGIN SUCCESSFUL ");
				 uc.userChoice();//EXECUTE USERCHOICE CLASS'S USERCHOICE() METHOD 
			 }
			 else {
				 System.out.println("---------- PLEASE ENTER CORRECT DETAILS -------------");			 }
			 break;
			 
		 case 3: //PREVIOUS MENU
			 break;
		 case 4:
			 System.out.println("--------------------------------");
			 System.out.println(" PROGRAM EXECUTION STOPPED ");
			 System.out.println("--------------------------------");
			 System.exit(0);
		 }
	 }
	 while(choice>0 && choice<=2);
 }
}
