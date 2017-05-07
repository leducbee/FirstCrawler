package com.crawler.bee;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

public class MainApp {

	public static void main(String args[]) throws IOException, DocumentException {
		PdfGeneratorMechanism pdfGenerator = new PdfGeneratorMechanism();
		pdfGenerator.setSavedFolderPath("C:/Users/lmduc_000/Downloads/pdf/");
		pdfGenerator.setScannedFolderPath("C:/Users/lmduc_000/Downloads");
		pdfGenerator.setSignalScannedFolderPath("vol-10-");
		pdfGenerator.setFileType("pdf");
		
		pdfGenerator.generate();
	}
}
