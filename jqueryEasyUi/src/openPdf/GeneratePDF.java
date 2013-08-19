package openPdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class GeneratePDF {

	public static void main(String[] args) {
		try {
			OutputStream file = new FileOutputStream(new File("C:\\Documents and Settings\\Administrator\\桌面\\搜索引擎-原理、技术与系统.pdf"));

			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			document.add(new Paragraph("Hello Kiran"));
			document.add(new Paragraph(new Date().toString()));

			document.close();
			file.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
