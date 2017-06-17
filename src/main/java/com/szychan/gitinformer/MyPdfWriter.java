package com.szychan.gitinformer;

import java.io.FileNotFoundException;
import java.util.Arrays;

import javax.json.JsonArray;
import javax.json.JsonObject;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;


public class MyPdfWriter {

	public static void WriteUserRepositoriesToPdf(String userName, JsonArray jsonArray) throws FileNotFoundException{
		
		PdfWriter writer = new PdfWriter("data.pdf");
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);
		
		document.add(new Paragraph(userName));
		
		Table table = new Table(new float[]{1,1});
		
		table.addHeaderCell("Repository Name");
		table.addHeaderCell("Last Updated");
		
		for(JsonObject jsonObject : jsonArray.getValuesAs(JsonObject.class)){
        	//sonObject projectName = jsonObject.getJsonObject("name");
        	System.out.println(Arrays.asList(
        	        jsonObject.get("name").toString(),jsonObject.get("updated_at").toString()));
        	table.addCell(jsonObject.get("name").toString());
        	table.addCell(jsonObject.get("updated_at").toString());
        }
		
		document.add(table);
	
		document.close();
		
	}
}
