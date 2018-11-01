package com.realtime;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ConvertPdf {
    public static ArrayList<Excel> excelData = new ArrayList<Excel>();

    public static void readExcel(){
        try {
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\250667-STIW3054-A181\\Assignment2.xlsx");
            XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet=workbook.getSheet("ChessResult");
            Iterator<Row> rows=sheet.iterator();

            while (rows.hasNext()){
                Row row = rows.next();//read rows from excel document
                String column0=row.getCell(0).toString();
                String column2 = row.getCell(2).toString();
                String column3 = row.getCell(3).toString();
                String column4 = row.getCell(4).toString();
                String column5 = row.getCell(5).toString();
                String column6 = row.getCell(6).toString();
                excelData.add(new Excel(column0,column2,column3,column4,column5,column6));//store into arraylist
            }
            workbook.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convert(){
        try {
            Document document = new Document();
            PdfPTable table = new PdfPTable(new float[]{3, 12, 4, 4, 4, 9});//content size of pdf table

                for (int i = 0; i < ConvertPdf.excelData.size(); i++) {//get value from arraylist
                    table.addCell(ConvertPdf.excelData.get(i).getColumn0());
                    table.addCell(ConvertPdf.excelData.get(i).getColumn2());
                    table.addCell(ConvertPdf.excelData.get(i).getColumn3());
                    table.addCell(ConvertPdf.excelData.get(i).getColumn4());
                    table.addCell(ConvertPdf.excelData.get(i).getColumn5());
                    table.addCell(ConvertPdf.excelData.get(i).getColumn6());
                }
                PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\250667-STIW3054-A181\\Assignment2.pdf"));
                document.open();
                document.add(table);
                document.close();
                System.out.println("Convert to pdf successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
