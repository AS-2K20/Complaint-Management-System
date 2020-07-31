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

public class FirDetailsPDF {
	public void generateFirDetailsPDf(int firId) throws ClassNotFoundException, IOException, SQLException, DocumentException {
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pt = con.prepareStatement("SELECT * FROM FIR_DETAILS WHERE FIR_ID = ?");
		pt.setInt(1, firId);
		ResultSet resultSet = pt.executeQuery();
	
		Document my_pdf = new Document();
		PdfWriter.getInstance(my_pdf, new FileOutputStream("FirDetails.pdf"));
		my_pdf.open();
		
		Paragraph l1 = new Paragraph("***********************************************\n");
		l1.setAlignment(Paragraph.ALIGN_CENTER);
		my_pdf.add(l1);
		Paragraph p1 = new Paragraph(" FIR DETAILS ");
		p1.setAlignment(Paragraph.ALIGN_CENTER);
		my_pdf.add(p1);
		Paragraph l2 = new Paragraph("***********************************************\n\n");
		l2.setAlignment(Paragraph.ALIGN_CENTER);
		my_pdf.add(l2);
		
		while (resultSet.next()){
			int fID = resultSet.getInt(1);
			Paragraph g1 = new Paragraph(" FIR ID : "+fID+" "+"\n\n");
			g1.setAlignment(Paragraph.ALIGN_CENTER);
			my_pdf.add(g1);
			
			int fCId = resultSet.getInt(2);
			Paragraph g10 = new Paragraph(" COMPLAINT ID : "+fCId+" "+"\n\n");
			g10.setAlignment(Paragraph.ALIGN_CENTER);
			my_pdf.add(g10);
			
			LocalDate fDate = resultSet.getDate(3).toLocalDate();
			Paragraph g11 = new Paragraph(" FIR DATE : "+fDate+" "+"\n\n");
			g11.setAlignment(Paragraph.ALIGN_CENTER);
			my_pdf.add(g11);
			
			String fcUserId = resultSet.getString(4);
			Paragraph g2 = new Paragraph(" COMPLAINT GIVER ID : "+fcUserId+" "+"\n\n");
			g2.setAlignment(Paragraph.ALIGN_CENTER);
			my_pdf.add(g2);
			
			String fcType = resultSet.getString(5);
			Paragraph g3 = new Paragraph(" COMPLAINT TYPE : "+fcType+" "+"\n\n");
			g3.setAlignment(Paragraph.ALIGN_CENTER);
			my_pdf.add(g3);
			
			String ffComplaint = resultSet.getString(6);
			Paragraph g4 = new Paragraph(" COMPLAINT BRIEF : "+ffComplaint+" "+"\n\n");
			g4.setAlignment(Paragraph.ALIGN_CENTER);
			my_pdf.add(g4);
									
			LocalDate cDate = resultSet.getDate(7).toLocalDate();
			Paragraph g6 = new Paragraph(" COMPLAINT DATE : "+cDate+" "+"\n\n");
			g6.setAlignment(Paragraph.ALIGN_CENTER);
			my_pdf.add(g6);
			
			String cUEmail = resultSet.getString(8);
			Paragraph g7 = new Paragraph(" COMPLAINT GIVER EMAIL : "+cUEmail+" "+"\n\n");
			g7.setAlignment(Paragraph.ALIGN_CENTER);
			my_pdf.add(g7);
			
			long cContact = resultSet.getLong(9);
			Paragraph g8 = new Paragraph(" COMPLAINT GIVER CONTACT : "+cContact+" "+"\n\n");
			g8.setAlignment(Paragraph.ALIGN_CENTER);
			my_pdf.add(g8);
			
			String cUAddress = resultSet.getString(10);
			Paragraph g9 = new Paragraph(" COMPLAINT GIVER EMAIL ADDRESS : "+cUAddress+" "+"\n\n");
			g9.setAlignment(Paragraph.ALIGN_CENTER);
			my_pdf.add(g9);		
			
		}
		my_pdf.close();
		pt.close();
		con.close();		
	}
}
