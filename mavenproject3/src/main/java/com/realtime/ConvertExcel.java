package com.realtime;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ConvertExcel {
    public static ArrayList<Excel> excel = new ArrayList<Excel>();

    public static void crawlData() {
        try {
            Document doc = Jsoup.connect("http://chess-results.com/tnr380806.aspx?lan=1").get();
            Element trs = doc.select("table[class=CRs1]").get(0);
            Elements rows = trs.select("tr");

            for (Element row:rows){
                String coloumn0=row.select("td").get(0).text();
                String coloumn2=row.select("td").get(2).text();
                String coloumn3=row.select("td").get(3).text();
                String coloumn4=row.select("td").get(4).text();
                String coloumn5=row.select("td").get(5).text();
                String coloumn6=row.select("td").get(6).text();
                excel.add(new Excel(coloumn0,coloumn2,coloumn3,coloumn4,coloumn5,coloumn6));//store into arraylist
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convert(){
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("ChessResult");
        try {
            for (int i=0;i<excel.size();i++){
                XSSFRow row=sheet.createRow(i);//create excel,get value from arraylist

                XSSFCell cell=row.createCell(0);
                cell.setCellValue(excel.get(i).getColumn0());
                XSSFCell cell3=row.createCell(2);
                cell3.setCellValue(excel.get(i).getColumn2());
                XSSFCell cell4=row.createCell(3);
                cell4.setCellValue(excel.get(i).getColumn3());
                XSSFCell cell5=row.createCell(4);
                cell5.setCellValue(excel.get(i).getColumn4());
                XSSFCell cell6=row.createCell(5);
                cell6.setCellValue(excel.get(i).getColumn5());
                XSSFCell cell7=row.createCell(6);
                cell7.setCellValue(excel.get(i).getColumn6());
            }
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\250667-STIW3054-A181\\Assignment2.xlsx");
            workbook.write(fileOutputStream);
            workbook.close();
            System.out.println("Convert to excel successful");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





