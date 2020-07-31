package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.DocumentException;

import dao.AllComplaintsSelection;
import dao.AllFirDetailsSelection;
import dao.ComplaintUpdation;
import dao.FirDetailsInsertion;
import dao.FirDetailsPDF;
import dao.GivenComplaintSelection;
import model.ComplaintDetails;
import model.FirDetails;

public class AdminChoice {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//Object Creation For ComplaintUpdation Class 
	ComplaintUpdation CU = new ComplaintUpdation();
	
	//Object Creation For the class GivenComplaintSelection
	GivenComplaintSelection GCS = new GivenComplaintSelection();
	
	//Object For Constructor ComplaintDetails
	ComplaintDetails CD = null;
	
	//Object Creation For AllCompaintsSelection Class
	AllComplaintsSelection ACS = new AllComplaintsSelection();
	
	//Object Creation For AllFirDetailsSelection Class
	AllFirDetailsSelection AFDS = new AllFirDetailsSelection();
	
	//Object For Constructor FirDetails
	FirDetails FD = null;
	
	//Object Creation For the class FirDetailsInsertion
	FirDetailsInsertion FDI = new FirDetailsInsertion();
	
	//Object Creation For the class FirDetailsPDF
	FirDetailsPDF FDP = new FirDetailsPDF();
	
	public void adminChoice() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, DocumentException {
		int choice;		
		do {
			System.out.println("*-------------------------------------------------*");
			System.out.println("                     ADMIN OPTIONS                   ");
			System.out.println("*-------------------------------------------------*");
			System.out.println(" 1. Display All Complaints ");
			System.out.println(" 2. Update Complaint Status ");
			System.out.println(" 3. Create FIR ");//FIR -> First Information Report
			System.out.println(" 4. Display FIR Details ");
			System.out.println(" 5. Generate FIR Details PDF ");
			System.out.println(" 6. Previous Menu ");
			System.out.println(" 7. Exit ");
			
			//System.out.println(" 4. Create Chargesheet ");
			//System.out.println(" 6. Display Chargesheet Details ");
			//System.out.println(" 7. Create Criminal Record ");
			//System.out.println(" 8. Update Criminal Record ");
			System.out.println();
			System.out.println("*-------------------------------------------------*");
			System.out.println("Enter Your Choice:");
			choice = Integer.parseInt(br.readLine());
			
			switch(choice) {
			case 1:// Displaying All Complaints
				displayAllComplaints();
				break;
			case 2:// Updating Complaint Status
				updateComplaintStatus();
				break;
			case 3:// Creating FIR
				createFir();
				break;
			case 11:// Creating Chargesheet
				createChargesheet();
				break;
			case 4:// Displaying All FIR Details
				showAllFirDetails();
				break;
			case 5:// Generate FIR Details PDF
				generateFirDetailsPdf();
				break;
			case 9:// Creating Criminal Record
				break;
			case 8:// Updating Criminal Record
				break;
			case 7:// Previous Menu
				break;
			case 6: // Exit
				System.out.println("--------------------------------");
				 System.out.println(" PROGRAM EXECUTION STOPPED ");
				 System.out.println("--------------------------------");
				 System.exit(0);
				
			}
		}
		while(choice>0 && choice <10);
	}
	
	public void displayAllComplaints() {
		System.out.println("*****************************************************");
		System.out.println("                   ALL COMPLAINT DETAILS                        ");
		System.out.println("*****************************************************");
		System.out.println();
		
		List<ComplaintDetails> resultList = new ArrayList<ComplaintDetails>();
		
		ACS.showAllComplaints();
		
		resultList = ACS.showAllComplaints();
		
		for (ComplaintDetails cd:resultList) {
			System.out.println("-----------------------------------------------------");
			System.out.println(" Complaint ID:                "+cd.getComplaintId());
			System.out.println(" Complaint Status:            "+cd.getComplaintStatus());
			System.out.println(" Complaint User ID:           "+cd.getComplaintUserId());
			System.out.println(" Complaint Type:              "+cd.getComplaintType());
			System.out.println(" Full Complaint:              "+cd.getFullComplaint());			
			System.out.println(" Complaint Date:              "+cd.getComplaintDate());
			System.out.println(" Complaint User Email:        "+cd.getComplaintUserEmail());
			System.out.println(" Complaint User Contact:      "+cd.getComplaintUserContact());
			System.out.println(" Complaint User Address:      "+cd.getComplaintUserAddress());
			System.out.println();
		}
		
	}
	
	public void updateComplaintStatus() throws NumberFormatException, IOException {
		int cID;
		System.out.println("Enter Complaint ID: ");
		cID = Integer.parseInt(br.readLine());
		CU.complaintUpdate(cID);
		System.out.println("----- COMPLAINT STATUS CHANGED ----- ");
	}
	
	public void createFir() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		int firId,firComplaintId;
		LocalDate firDate,firComplaintDate;
		String firComplaintUserId,firComplaintType,firFullComplaint,firComplaintUserEmail;
		String firComplaintUserAddress;
		boolean ans_result=false;
		long firComplaintUserContact;
		
		int minValue =20, maxValue=100;//For Setting Min and Max Range
		
		System.out.println("*****************************************************");
		System.out.println("                   CREATING FIR DETAILS                       ");
		System.out.println("*****************************************************");
		
		firId = (int)(Math.random()*(maxValue-minValue+1)+minValue);
		LocalDate myDate = LocalDate.now();
		firDate = myDate;
		
		System.out.println(" Enter FIR Complaint ID: ");
		firComplaintId = Integer.parseInt(br.readLine());
		
		//GCS.showGivenComplaintDetails(firComplaintId);
		List<ComplaintDetails> resultList = new ArrayList<ComplaintDetails>();
		
		//Result of showGivenComplaintDetails method will be stored on the resultList
		resultList = GCS.showGivenComplaintDetails(firComplaintId);
		
		for(ComplaintDetails GCs:resultList) {
			
			firComplaintUserId= GCs.getComplaintUserId();
			firComplaintType = GCs.getComplaintType();
			firFullComplaint = GCs.getFullComplaint();			
			firComplaintDate = GCs.getComplaintDate();
			firComplaintUserEmail = GCs.getComplaintUserEmail();
			firComplaintUserContact=GCs.getComplaintUserContact();
			firComplaintUserAddress = GCs.getComplaintUserAddress();
			
			
			//INITITALISING THE VALUES USING CONSTRUCTOR OBJECT
			FD = new FirDetails(firId,firComplaintId,firDate,firComplaintUserId,firComplaintType,firFullComplaint,firComplaintDate,firComplaintUserEmail,firComplaintUserContact,firComplaintUserAddress);
			ans_result = FDI.insertFirDetails(FD);
		}

		if(ans_result==true) {
			System.out.println("---------- FIR Created Successfully -------------");
			System.out.println("Your FIR ID is : "+firId+" ");
			System.out.println("Kindy Keep Note of this Complaint ID");
		}
		else {
			System.out.println("INVALID DETAILS");
		}
	}
	
	public void showAllFirDetails() {
		System.out.println("*****************************************************");
		System.out.println("                   FIR DETAILS                        ");
		System.out.println("*****************************************************");
		System.out.println();
		
		List<FirDetails> resultList = new ArrayList<FirDetails>();
		AFDS.showAllFirDetails();
		resultList = AFDS.showAllFirDetails();
		
		for (FirDetails fd:resultList) {
			System.out.println("-----------------------------------------------------");
			System.out.println(" FIR ID :                                                  "+fd.getFirId());
			System.out.println(" FIR Complaint ID :                                        "+fd.getFirComplaintId());
			System.out.println(" FIR Date :                                                "+fd.getFirDate());
			System.out.println(" FIR Complaint Giver ID :                                  "+fd.getFirComplaintUserId());
			System.out.println(" FIR Complaint Type :                                      "+fd.getFirComplaintType());			
			System.out.println(" FIR Full Complaint :                                      "+fd.getFirFullComplaint());
			System.out.println(" FIR Complaint Date :                                      "+fd.getFirComplaintDate());
			System.out.println(" FIR Complaint User Email :                                "+fd.getFirComplaintUserEmail());
			System.out.println(" FIR Complaint User Contact :                              "+fd.getFirComplaintUserContact());
			System.out.println(" FIR Complaint User Address :                              "+fd.getFirComplaintUserAddress());
			System.out.println();
		}
	}
	
	public void createChargesheet() throws IOException {
		
		int csId,csFirId,csComplaintID;
		LocalDate csDate,csFirDate,csComplaintDate;
		String csFirComplaintUserID,csFirComplaintType,csFirFullComplaint,csFirComplaintUserEmail,csFirComplaintUserContact,csFirComplaintUserAddress;
		String csAccusedName,csAccusedAddress;
		
		int minValue =20, maxValue=100;//For Setting Min and Max Range
		
		System.out.println("*****************************************************");
		System.out.println("                   CREATING CHARGESHEET                      ");
		System.out.println("*****************************************************");
		System.out.println("Enter Accused Name: ");
		csAccusedName = br.readLine();
		System.out.println("Enter Accused Address: ");
		csAccusedAddress = br.readLine();
		csId = (int)(Math.random()*(maxValue-minValue+1)+minValue);
		LocalDate myDate = LocalDate.now();
		csDate = myDate;
		System.out.println(" Enter FIR ID: ");
		csFirId = Integer.parseInt(br.readLine());
		
//		//GCS.showGivenComplaintDetails(firComplaintId);
//		List<ComplaintDetails> resultList = new ArrayList<ComplaintDetails>();
//				
//		//Result of showGivenComplaintDetails method will be stored on the resultList
//		resultList = GCS.showGivenComplaintDetails(firComplaintId);
//				
//				for(ComplaintDetails GCs:resultList) {
//					
//					firComplaintUserId= GCs.getComplaintUserId();
//					firComplaintType = GCs.getComplaintType();
//					firFullComplaint = GCs.getFullComplaint();			
//					firComplaintDate = GCs.getComplaintDate();
//					firComplaintUserEmail = GCs.getComplaintUserEmail();
//					firComplaintUserContact=GCs.getComplaintUserContact();
//					firComplaintUserAddress = GCs.getComplaintUserAddress();
//					
//					
//					//INITITALISING THE VALUES USING CONSTRUCTOR OBJECT
//					FD = new FirDetails(firId,firComplaintId,firDate,firComplaintUserId,firComplaintType,firFullComplaint,firComplaintDate,firComplaintUserEmail,firComplaintUserContact,firComplaintUserAddress);
//					ans_result = FDI.insertFirDetails(FD);
//				}
	}
	
	public void generateFirDetailsPdf() throws NumberFormatException, IOException, ClassNotFoundException, SQLException, DocumentException {
		int fID;
		System.out.println("*****************************************************");
		System.out.println("                  DOWNLOAD FIR DETAILS PDF                      ");
		System.out.println("*****************************************************");
		System.out.println("Enter Your FIR ID: ");		
		fID = Integer.parseInt(br.readLine());
		FDP.generateFirDetailsPDf(fID);
		System.out.println("PDF HAS BEEN GENERATED SUCCESSFULLY");
		System.out.println("----------------------------------------------------");
		System.out.println();
	}
	
}