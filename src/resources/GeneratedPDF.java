package resources;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.parser.clipper.Path;

public class GeneratedPDF {

	public static void makePdf(ResultSet rs) throws DocumentException, FileNotFoundException, SQLException {
	
			String fileName="E:\\java\\university project\\generatedPDF\\studentList.pdf";
	
			Document document = new Document();
			PdfWriter pdfwriter = PdfWriter.getInstance(document, new FileOutputStream(fileName));

			document.open();
			
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLUE);
			
			Chunk chunk = new Chunk("Student List\n\n", font);
			
			document.add(chunk);
			
			document.add(new Paragraph(20, "\u00a0"));
			
			LineSeparator ls = new LineSeparator();
			document.add(new Chunk(ls));
			
			document.add(new Paragraph(20, "\u00a0"));
			
			PdfPTable table = new PdfPTable(5);	
			table.addCell("SL");
			table.addCell("Name");
			table.addCell("Email");
			table.addCell("Mobile");
			table.addCell("Gendar");
			rs= rs;
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String gendar = rs.getString("gendar");
				table.addCell(id);
				table.addCell(name);
				table.addCell(email);
				table.addCell(mobile);
				table.addCell(gendar);
			}
			
			
			document.add(table);
			
			document.close();


			try {

				File pdfFile = new File(fileName);
				if (pdfFile.exists()) {

					if (Desktop.isDesktopSupported()) {
						Desktop.getDesktop().open(pdfFile);
					} else {
						System.out.println("Awt Desktop is not supported!");
					}

				} else {
					System.out.println("File is not exists!");
				}


			  } catch (Exception ex) {
				ex.printStackTrace();
			  }		
	}

	public static void makePdf2(ResultSet rs) throws DocumentException, FileNotFoundException, SQLException {
		
		String fileName="E:\\java\\university project\\generatedPDF\\coursesList.pdf";

		Document document = new Document();
		PdfWriter pdfwriter = PdfWriter.getInstance(document, new FileOutputStream(fileName));

		document.open();
		
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLUE);
		
		Chunk chunk = new Chunk("Courses List\n\n", font);
		
		document.add(chunk);
		
		document.add(new Paragraph(20, "\u00a0"));
		
		LineSeparator ls = new LineSeparator();
		document.add(new Chunk(ls));
		
		document.add(new Paragraph(20, "\u00a0"));
		
		PdfPTable table = new PdfPTable(5);	
		table.addCell("SL");
		table.addCell("Title");
		table.addCell("Code");
		table.addCell("Price");
		table.addCell("Cradit Houres");
		rs= rs;
		while(rs.next()) {
			String id = rs.getString("id");
			String title = rs.getString("title");
			String code = rs.getString("code");
			String price = rs.getString("price");
			String credit_houre = rs.getString("credit_houre");
			table.addCell(id);
			table.addCell(title);
			table.addCell(code);
			table.addCell(price);
			table.addCell(credit_houre);
		}
		
		
		document.add(table);
		
		document.close();


		try {

			File pdfFile = new File(fileName);
			if (pdfFile.exists()) {

				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(pdfFile);
				} else {
					System.out.println("Awt Desktop is not supported!");
				}

			} else {
				System.out.println("File is not exists!");
			}


		  } catch (Exception ex) {
			ex.printStackTrace();
		  }		
}

}
