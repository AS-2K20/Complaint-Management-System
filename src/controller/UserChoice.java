package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.DocumentException;

import dao.ComplaintDetailsInsertion;
import dao.GivenComplaintDeletion;
import dao.GivenComplaintDetailsConverttoPDF;
import dao.GivenComplaintSelection;
import model.ComplaintDetails;


public class UserChoice {
	BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
	
	//Object Creation for ComplaintDetails Model Class
	ComplaintDetails CD = null;	
	
	//GivenComplaintSelection Class's Object creation
	GivenComplaintSelection GCS = new GivenComplaintSelection();
	
	//GivenComplaintDeletion Class's Object creation
	GivenComplaintDeletion GCD = new GivenComplaintDeletion(); 
	
	//PDF Conversion Class's Object Creation
	GivenComplaintDetailsConverttoPDF PDFConversion = new GivenComplaintDetailsConverttoPDF();
	
	public void userChoice() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, DocumentException {
		
		int choice;		
		do {
			System.out.println("*-------------------------------------------------*");
			System.out.println("                      USER OPTIONS                   ");
			System.out.println("*-------------------------------------------------*");
			System.out.println(" 1. Create Complaint ");
			System.out.println(" 2. Check Given Complaint ");
			System.out.println(" 3. WithDraw Complaint ");
			System.out.println(" 4. Convert Given Complaint To PDF ");
			System.out.println(" 5. Previous Menu ");
			System.out.println(" 6. Exit ");
			System.out.println("--------------------------------");
			System.out.println(" Please Enter Your Choice: ");
			choice = Integer.parseInt(br.readLine());
			
			switch(choice) {
				case 1://CREATE COMPLAINT
					createComplaint();
					break;
				case 2://CHECK GIVEN COMPLAINT DETAILS 
					checkComplaint();
					break;
				case 3: //WITHDRAW COMPLAINT
					deleteComplaint();
					break;
				case 4: //PDF Conversion
					convertToPdf();
					break;
				case 5: //GO TO PREVIOUS MENU
					break;
				case 6: //STOP THE PROGRAM
					System.out.println("--------------------------------");
					 System.out.println(" PROGRAM EXECUTION STOPPED ");
					 System.out.println("--------------------------------");
					 System.exit(0);
			}
		}
		while(choice>0 && choice < 4 );
	}
	
	public void createComplaint() throws IOException {
		String complaintUserId, complaintType, fullComplaint, complaintStatus;
		int complaintId;
		LocalDate complaintDate; 
		String complaintUserEmail,complaintUserAddress;
		long complaintUserContact;	
		
		int minValue =5, maxValue=100;//For Setting Min and Max Range
		System.out.println("*****************************************************");
		System.out.println("                    CREATING COMPLAINT                       ");
		System.out.println("*****************************************************");
		complaintId = (int)(Math.random()*(maxValue-minValue+1)+minValue);
		LocalDate myDate = LocalDate.now();//Getting Current Date 
		complaintDate = myDate ;
		complaintStatus = "Complaint Given";
		System.out.println("Enter Your ID:");
		complaintUserId = br.readLine();
		System.out.println("Enter Complaint Type:");
		complaintType = br.readLine();
		System.out.println("Enter Full Complaint in Detail:");
		fullComplaint = br.readLine();
		System.out.println("Enter Your Email:");
		complaintUserEmail = br.readLine();
		System.out.println("Enter Your Phone Number:");
		complaintUserContact = Long.parseLong(br.readLine());
		System.out.println("Enter Your Address:");
		complaintUserAddress = br.readLine();
				
		//PASSING USER INPUTS TO OBJECT CD OF COMPLAINTDETAILS CLASS
		CD = new ComplaintDetails(complaintId, complaintUserId, complaintType, fullComplaint, complaintStatus, complaintDate, complaintUserEmail, complaintUserContact, complaintUserAddress);
		
		if(ComplaintDetailsInsertion.CDInsertion(CD)==true) {
		System.out.println("---------- Complaint Created Successfully -------------");
		System.out.println("Your Complaint ID is : "+complaintId+" ");
		System.out.println("Kindy Keep Note of this Complaint ID");
		}
		
		else {
			System.out.println("----------- PLEASE PROVIDE VALID DETAILS ------------ ");
		}
		
	}
	
	public void checkComplaint() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		int cID;
		System.out.println("*****************************************************");
		System.out.println("                   CHECK GIVEN COMPLAINT                        ");
		System.out.println("*****************************************************");
		System.out.println("Enter Your Complaint ID: ");
		cID = Integer.parseInt(br.readLine());
		
		//Passing the complaint Id from the user to showGivenComplaintDetails method
		GCS.showGivenComplaintDetails(cID);
		List<ComplaintDetails> resultList = new ArrayList<ComplaintDetails>();
		
		//Result of showGivenComplaintDetails method will be stored on the resultList
		resultList = GCS.showGivenComplaintDetails(cID);
		System.out.println("*-------------------------------------------------*");
		System.out.println("                     GIVEN COMPLAINT DETAILS                 ");
		System.out.println("*-------------------------------------------------*");
		for(ComplaintDetails GCs:resultList) {
			System.out.println(" Complaint Status:            "+GCs.getComplaintStatus());
			System.out.println(" Complaint User ID:           "+GCs.getComplaintUserId());
			System.out.println(" Complaint Type:              "+GCs.getComplaintType());
			System.out.println(" Full Complaint:              "+GCs.getFullComplaint());			
			System.out.println(" Complaint Date:              "+GCs.getComplaintDate());
			System.out.println(" Complaint User Email:        "+GCs.getComplaintUserEmail());
			System.out.println(" Complaint User Contact:      "+GCs.getComplaintUserContact());
			System.out.println(" Complaint User Address:      "+GCs.getComplaintUserAddress());
		}
	}
	
	public void deleteComplaint() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		int cID,result;
		System.out.println("*****************************************************");
		System.out.println("                   WITHDRAW GIVEN COMPLAINT                        ");
		System.out.println("*****************************************************");
		System.out.println("Enter Your Complaint ID: ");
		cID = Integer.parseInt(br.readLine());
		GCD.withdrawComplaint(cID);
	}
	
	public void convertToPdf() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, DocumentException {
		int cID;
		System.out.println("*****************************************************");
		System.out.println("                 GIVEN COMPLAINT TO PDF CONVERSION                      ");
		System.out.println("*****************************************************");
		System.out.println("Enter Your Complaint ID: ");
		cID = Integer.parseInt(br.readLine());
		PDFConversion.convertingToPdf(cID);
		System.out.println("PDF HAS BEEN GENERATED SUCCESSFULLY");
		System.out.println("----------------------------------------------------");
		System.out.println();
	}
}
