/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavenproject.webtoexcel;

/**
 *
 * @author kartikesen
 */
public class format {
    private String header;
    private String data;
    
    public format(){
        
    }
    
    public format(String header, String data){
        this.header = header;
        this.data = data;
    }
    
    
    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }
    
    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
