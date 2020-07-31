package dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import utility.ConnectionManager;

public class GivenComplaintDetailsConverttoPDF {
	
public void convertingToPdf(int complaintID ) throws ClassNotFoundException, IOException, SQLException, DocumentException {
	Connection con = ConnectionManager.getConnection();
	PreparedStatement pt = con.prepareStatement("SELECT * FROM COMPLAINT_DETAILS WHERE COMPLAINT_ID = ?");
	pt.setInt(1, complaintID);
	ResultSet resultSet = pt.executeQuery();
	
	Document my_pdf = new Document();
	PdfWriter.getInstance(my_pdf, new FileOutputStream("ComplaintDetails.pdf"));
	my_pdf.open();
	
	Paragraph l1 = new Paragraph("***********************************************\n");
	l1.setAlignment(Paragraph.ALIGN_CENTER);
	my_pdf.add(l1);
	Paragraph p1 = new Paragraph(" COMPLAINT DETAILS ");
	p1.setAlignment(Paragraph.ALIGN_CENTER);
	my_pdf.add(p1);
	Paragraph l2 = new Paragraph("***********************************************\n\n");
	l2.setAlignment(Paragraph.ALIGN_CENTER);
	my_pdf.add(l2);
	
	while (resultSet.next()){
		int cID = resultSet.getInt(1);
		Paragraph g1 = new Paragraph(" COMPLAINT ID : "+cID+" "+"\n\n");
		g1.setAlignment(Paragraph.ALIGN_CENTER);
		my_pdf.add(g1);
		
		String cUserId = resultSet.getString(2);
		Paragraph g2 = new Paragraph(" COMPLAINT USER ID : "+cUserId+" "+"\n\n");
		g2.setAlignment(Paragraph.ALIGN_CENTER);
		my_pdf.add(g2);
		
		String cType = resultSet.getString(3);
		Paragraph g3 = new Paragraph(" COMPLAINT TYPE : "+cType+" "+"\n\n");
		g3.setAlignment(Paragraph.ALIGN_CENTER);
		my_pdf.add(g3);
		
		String fComplaint = resultSet.getString(4);
		Paragraph g4 = new Paragraph(" COMPLAINT BRIEF : "+fComplaint+" "+"\n\n");
		g4.setAlignment(Paragraph.ALIGN_CENTER);
		my_pdf.add(g4);
		
		String Cstatus = resultSet.getString(5);
		Paragraph g5 = new Paragraph(" COMPLAINT STATUS : "+Cstatus+" "+"\n\n");
		g5.setAlignment(Paragraph.ALIGN_CENTER);
		my_pdf.add(g5);
		
		LocalDate cDate = resultSet.getDate(6).toLocalDate();
		Paragraph g6 = new Paragraph(" COMPLAINT DATE : "+cDate+" "+"\n\n");
		g6.setAlignment(Paragraph.ALIGN_CENTER);
		my_pdf.add(g6);
		
		String cUEmail = resultSet.getString(7);
		Paragraph g7 = new Paragraph(" COMPLAINT USER EMAIL : "+cUEmail+" "+"\n\n");
		g7.setAlignment(Paragraph.ALIGN_CENTER);
		my_pdf.add(g7);
		
		long cContact = resultSet.getLong(8);
		Paragraph g8 = new Paragraph(" COMPLAINT USER CONTACT : "+cContact+" "+"\n\n");
		g8.setAlignment(Paragraph.ALIGN_CENTER);
		my_pdf.add(g8);
		
		String cUAddress = resultSet.getString(9);
		Paragraph g9 = new Paragraph(" COMPLAINT USER EMAIL ADDRESS : "+cUAddress+" "+"\n\n");
		g9.setAlignment(Paragraph.ALIGN_CENTER);
		my_pdf.add(g9);		
		
	}
	my_pdf.close();
	pt.close();
	con.close();
}
}
