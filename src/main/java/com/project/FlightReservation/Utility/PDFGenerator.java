package com.project.FlightReservation.Utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.project.FlightReservation.Entities.Reservation;

@Component
public class PDFGenerator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);
	
	public void generateItinerary(Reservation reservation, String filePath)
	{
		LOGGER.info("Inside generateItinerary() Method");
	
	Document doc = new Document();

	try {
		PdfWriter.getInstance(doc, new FileOutputStream(filePath));
		
		doc.open();
		
		LOGGER.info("Trying To Add Data To Document");
		doc.add(generateTable(reservation));
		
		doc.close();
		
	} catch (FileNotFoundException | DocumentException e) {
		LOGGER.error("Exception in generateItinerary() "+e);
	}
	
	
	}

	private PdfPTable generateTable(Reservation reservation) 
	{
		LOGGER.info("Inside generateTable() Method");
		PdfPTable pdf = new PdfPTable(2);
		
		PdfPCell cell;
		
		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		pdf.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		pdf.addCell(cell);
		
		pdf.addCell("Flight Number");
		pdf.addCell(reservation.getFlight().getFlightNumber());
		
		pdf.addCell("Operating Airlines");
		pdf.addCell(reservation.getFlight().getOperatingAirlines());
		
		pdf.addCell("Departure City");
		pdf.addCell(reservation.getFlight().getDepartureCity());
		
		pdf.addCell("Arrival City");
		pdf.addCell(reservation.getFlight().getArrivalCity());
		
		pdf.addCell("Estimated Departure Time");
		pdf.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
		
		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		pdf.addCell(cell);
		
		pdf.addCell("Passenger FirstName");
		pdf.addCell(reservation.getPassenger().getFirstName());
		
		pdf.addCell("Passenger LastName");
		pdf.addCell(reservation.getPassenger().getLastName());
		
		pdf.addCell("Passenger Email");
		pdf.addCell(reservation.getPassenger().getEmail());
		
		pdf.addCell("Passenger Phone");
		pdf.addCell(reservation.getPassenger().getPhone());
		
		
		
		return pdf;
	}
}
