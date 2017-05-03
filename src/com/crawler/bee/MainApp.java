package com.crawler.bee;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.gnostice.pdfone.PdfDocument;
import com.gnostice.pdfone.PdfException;
import com.gnostice.pdfone.PdfImage;
import com.gnostice.pdfone.PdfPage;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class MainApp {
	public static final String DEST = "output/quickbrownfox1.pdf";

	static public void main(String args[]) throws IOException, DocumentException, PdfException {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		createPdf(DEST);
		
//		Document document = new Document();
//		document.setMargins(0, 0, 0, 0);
//        PdfWriter.getInstance(document, new FileOutputStream(DEST));
//        document.open();
//        Image img = Image.getInstance("C:/Users/lmduc_000/Downloads/vol 1 001-014/chapter-001-0001.jpg");
//        document.add(img);
//        document.close();
//        System.out.println("Done");

		File folder = new File("C:/Users/lmduc_000/Downloads");
		// func(folder);
	}

	private static void createPdf(String dest) throws IOException, PdfException, DocumentException {

		Document document = new Document();
		document.setMargins(0, 0, 0, 0);
		PdfWriter.getInstance(document, new FileOutputStream(dest));
		document.open();

		Image img = Image.getInstance("C:/Users/lmduc_000/Downloads/vol 1 001-014/chapter-001-0001.jpg");
		Rectangle one = new Rectangle(img.getWidth(), img.getHeight());
		document.setPageSize(one);
		document.newPage();
		document.add(img);
		
		Image img2 = Image.getInstance("C:/Users/lmduc_000/Downloads/vol 1 001-014/chapter-014-0201.png");
		Rectangle two = new Rectangle(img2.getWidth(), img2.getHeight());
		document.setPageSize(two);
		document.newPage();
		document.add(img2);
		
		document.close();


		// PdfPage page1 = new PdfPage(img.width(), img.height());
		// page1.drawImage(img, 0, 0);
		// doc.add(page1);
		// doc.save("PNGImageToPDF.pdf");
		// doc.close();
	}

	private static void func(File folder) throws IOException, PdfException {
		File[] listOfFiles = folder.listFiles();

		for (File f : listOfFiles) {
			if (f.isDirectory() && f.getName().contains("xxx")) {
				PdfDocument doc = new PdfDocument();
				File[] listOfImage = f.listFiles();

				for (File imageFile : listOfImage) {
					if (!imageFile.toString().contains(".db")) {
						BufferedImage bufImg = ImageIO.read(imageFile);
						PdfImage img = PdfImage.create(bufImg);
						PdfPage page = new PdfPage(img.width(), img.height());
						page.drawImage(img, 0, 0);
						doc.add(page);
					}
				}
				doc.save("PNGImageToPDF.pdf");
				doc.close();
			}
		}
	}
}
