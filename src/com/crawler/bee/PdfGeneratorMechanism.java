package com.crawler.bee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.activation.FileTypeMap;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGeneratorMechanism {
	private String savedFolderPath;
	private String scannedFolderPath;
	private String signalScannedFolderPath;
	private String fileType;

	public PdfGeneratorMechanism() {
		savedFolderPath = "";
		scannedFolderPath = "";
		signalScannedFolderPath = "";
	}

	public void generate() throws IOException, DocumentException {
		System.out.println("Generating Started:");
		File scannedFolder = new File(scannedFolderPath);
		File[] listOfFiles = scannedFolder.listFiles();
		
		for (File f : listOfFiles) {
			if (f.isDirectory() && f.getName().contains(signalScannedFolderPath)) {
				// First, we should create a file pdf
				System.out.println("Generating file: " + f.getName() + "." + fileType + " ...");
				String destination = savedFolderPath.concat(f.getName()).concat(".").concat(fileType);

				File file = new File(destination);
				file.getParentFile().mkdirs();

				Document document = new Document();
				document.setMargins(0, 0, 0, 0);
				PdfWriter.getInstance(document, new FileOutputStream(destination));
				document.open();

				File[] listOfImage = f.listFiles();

				for (File imageFile : listOfImage) {
					if (!imageFile.toString().contains(".db")) {
						Image img = Image.getInstance(imageFile.getPath());
						Rectangle pageSize = new Rectangle(img.getWidth(), img.getHeight());
						document.setPageSize(pageSize);
						document.newPage();
						document.add(img);
					}
				}
				document.close();
				System.out.println(f.getName() + "." + fileType + " was generated\n");
			}
		}
		
		System.out.println("The process is complete!");
	}

	public void setSavedFolderPath(String savedFolderPath) {
		this.savedFolderPath = savedFolderPath;
	}

	public void setScannedFolderPath(String scannedFolderPath) {
		this.scannedFolderPath = scannedFolderPath;
	}

	public void setSignalScannedFolderPath(String signalScannedFolderPath) {
		this.signalScannedFolderPath = signalScannedFolderPath;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}