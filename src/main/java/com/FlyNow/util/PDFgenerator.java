package com.FlyNow.util;

import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.FlyNow.entities.Reservation;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class PDFgenerator {
	

	    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
	            Font.BOLD);
	   
	     private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.BOLD);

	    public void generatePDF(String filePath,String name,String emailId,String phone,
	    		String operatingAirlines,String deparatureDate,String deparatureCity,String arrivalCity) {
	    	
	        try {
	            Document document = new Document();
	            
	            PdfWriter.getInstance(document, new FileOutputStream(filePath));
	            document.open();
	            
	            addMetaData(document);
	            
	     addTitleAndTable(document,name,emailId,phone,operatingAirlines,
	    		 deparatureDate,deparatureCity,arrivalCity);
	           
	            document.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    private static void addMetaData(Document document) {
	    	
	    	document.addTitle("My First PDF");
	    	document.addSubject("Using iText");
	    	document.addKeywords("Java,PDF,iText");
	    	document.addAuthor("chetan bhagat");
	    	document.addCreator("chetan bhagat");
	    	 }
	    
	    private static void addTitleAndTable(Document document ,String name , String emailId,String phone,
	    			String operatingAirlines,String deaparatureDate , String deparatureCity , 
	    						String arrivalCity) throws DocumentException {
	    	
	    	Paragraph preface = new Paragraph();
	    	
	    	preface.add(new Paragraph("Flight Booking Details",catFont));
	    	
	    	preface.add(new Paragraph(
	    		"Report generated by:"+"Flight Reservation Company"+new Date(),smallBold));
	    	
	    	document.add(preface);
	    	document.add(Chunk.NEWLINE);
	    	document.add(Chunk.NEWLINE);
	    	
	    	PdfPTable table = new PdfPTable(2);
	    	table.setWidthPercentage(100);
	    	
	    	PdfPCell c1 = new PdfPCell(new Phrase("Passenger Detail"));
	    	c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	c1.setColspan(2);
	    	table.addCell(c1);
	    	
	    	table.addCell("Passenger Name");
	    	table.addCell(name);
	    	table.addCell("Email Id");
	    	table.addCell(emailId);
	    	table.addCell("Phone Number");
	    	table.addCell(phone);
	    	
	    	document.add(table);
	    	
	    	PdfPTable table1 = new PdfPTable(2);
	    	table1.setWidthPercentage(100);
	    	
	    	PdfPCell c2 = new PdfPCell(new Phrase("Flight Details"));
	    	c2.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	c2.setColspan(2);
	    	table.addCell(c2);
	    	
	    	table1.addCell("Operating Airlines");
	    	table1.addCell(operatingAirlines);
	    	table1.addCell("Deparature Date");
	    	table1.addCell(deaparatureDate);
	    	table1.addCell("Deparature City");
	    	table1.addCell(deparatureCity);
	    	table1.addCell("Arrival City");
	    	table1.addCell(arrivalCity);
	    	
	    	document.add(table1);
	    	document.close();
	    	
	    }
		public void generateItinerary(Reservation reservation, String filePath) {
			
			
		}
}
