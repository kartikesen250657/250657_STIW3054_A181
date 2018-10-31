package com.mavenproject.exceltopdf;

/**
 *
 * @author kartikesen
 */
public class Format {

    
    private String name;
    private String number;
    private String fideID;
    private String fed;
    private String rtg;
    private String clubCty;

   
    public Format() {

    }

    public Format(String name, String number, String fideID, String fed, String rtg, String clubCty) {
        
        this.name = name;
        this.number = number;
        this.fideID = fideID;
        this.fed = fed;
        this.rtg = rtg;
        this.clubCty = clubCty;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
    
    public void setFideID(String fideID){
        this.fideID = fideID;
    }
    
    public String getFideID(){
        return fideID;
    }
    
    public void setFed (String fed){
        this.fed = fed;
    }
    
    public String getFed(){
        return fed;
    }
    
    public void setRtg (String rtg){
        this.rtg = rtg;
    }
    
    public String getRtg(){
        return rtg;
    }
    
    public void setClubCty (String clubCty){
        this.clubCty = clubCty;
    }
    
    public String getClubCty(){
        return clubCty;
    }
}
