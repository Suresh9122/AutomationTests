package com.ReadingDataFromPDFExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class PDFreader {
	public static void main(String[] args) throws Exception {
		File doc = new File("C:\\Users\\haris\\Downloads\\Suresh Resume updated.pdf");
		
		FileInputStream fis = new FileInputStream(doc);
		
		//17th line we will get count of pages in the pdf
		PDDocument pdfDocument = PDDocument.load(fis);
		System.out.println(pdfDocument.getPages().getCount());
		//20th line we are creating object of the pdfStripper,used to read the pdf
		PDFTextStripper pdfReader = new PDFTextStripper();
		
		//line 22 to 23 will use to read the particular page
		pdfReader.setStartPage(1);
		pdfReader.setEndPage(1);
		
		// we are specifying the pdf document name to read the particular pdf by using pdfStripper
		String docText = pdfReader.getText(pdfDocument);
		System.out.println(docText);
		
		pdfDocument.close();
		fis.close();
	}

}
