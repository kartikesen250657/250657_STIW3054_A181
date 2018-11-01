package com.realtime;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) {

        ConvertExcel.crawlData();
        ConvertExcel.convert();
        ConvertPdf.readExcel();
        ConvertPdf.convert();
    }
}
