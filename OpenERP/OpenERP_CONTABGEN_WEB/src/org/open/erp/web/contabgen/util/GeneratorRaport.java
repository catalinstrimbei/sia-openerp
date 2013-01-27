package org.open.erp.web.contabgen.util;

import java.io.FileOutputStream;
import java.util.Date;

import org.open.erp.services.contabgen.rapoarte.BilantContabil;
import org.open.erp.services.contabgen.rapoarte.Raport;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratorRaport {
	
	static BilantContabil bilantContabil = null;
	
	private static String FILE = "c:/temp/Raport.pdf";
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
			Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
			Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.BOLD);

	public static void genereaza(Raport raport) {
		
		if(raport instanceof BilantContabil){
			bilantContabil=(BilantContabil) raport;
		}
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			addMetaData(document);
			addTitlePage(document);
			addContent(document,bilantContabil);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private static void addMetaData(Document document) {
		document.addTitle("Raport Contabilitate Generala");
	}

	private static void addTitlePage(Document document)
			throws DocumentException {
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Bilant contabil", catFont));

		addEmptyLine(preface, 1);
		preface.add(new Paragraph(
				"Generat de: " + System.getProperty("user.name") + ", " + new Date(),smallBold));
		addEmptyLine(preface, 3);
		addEmptyLine(preface, 8);
		document.add(preface);
	}

	private static void addContent(Document document, Raport raport) throws DocumentException {
		Anchor anchor = new Anchor("", catFont);
		anchor.setName("");
		
		Chapter catPart = new Chapter(new Paragraph(anchor), 1);

		Paragraph subPara = new Paragraph("", subFont);
		Section subCatPart = catPart.addSection(subPara);

		subPara = new Paragraph("", subFont);
		subCatPart = catPart.addSection(subPara);
		
		Paragraph paragraph = new Paragraph();
		addEmptyLine(paragraph, 5);
		subCatPart.add(paragraph);
		createTable(subCatPart,raport);
		document.add(catPart);
	}

	private static void createTable(Section subCatPart,Raport raport)
			throws BadElementException {
		PdfPTable table = new PdfPTable(3);

		
		PdfPCell c1 = new PdfPCell(new Phrase(raport.getDenumire()));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Total Activ"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Total Pasiv"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		table.addCell("");
		table.addCell(String.valueOf(((BilantContabil)raport).getTotalActiv()));
		table.addCell("");
		table.addCell(String.valueOf(((BilantContabil)raport).getTotalPasiv()));

		subCatPart.add(table);

	}

	
	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}