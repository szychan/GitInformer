package com.szychan.gitinformer;

import java.io.FileNotFoundException;

import javax.json.JsonArray;
import javax.json.JsonObject;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

/**
 * The Class MyPdfWriter provides writing pdf functionality.
 */
public class MyPdfWriter {

	/**
	 * Write user repositories to pdf.
	 *
	 * @param userName
	 *            the user name
	 * @param jsonArray
	 *            the json array
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public static void WriteUserRepositoriesToPdf(String userName, JsonArray jsonArray) throws FileNotFoundException {

		PdfWriter writer = new PdfWriter(userName + ".pdf");
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);

		document.add(new Paragraph("Repositories owner : " + userName));

		Table table = new Table(new float[] { 1, 1 });

		table.addHeaderCell(new Cell().add(new Paragraph("Repository Name")).setBackgroundColor(Color.BLUE));
		table.addHeaderCell(new Cell().add(new Paragraph("Update Date")).setBackgroundColor(Color.BLUE));

		for (JsonObject jsonObject : jsonArray.getValuesAs(JsonObject.class)) {

			table.addCell(StringUtils.removePrimes(jsonObject.get("name").toString()));
			table.addCell(StringUtils.normalizeDateTime(jsonObject.get("updated_at").toString()));
		}

		document.add(table);

		document.close();

	}
}
