/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftoxl;

/**
 *
 * @author prashanth_mani
 */
public class LinerDetails {

    public String getLinerWell_Number() {
        return LinerWell_Number;
    }

    public void setLinerWell_Number(String LinerWell_Number) {
        this.LinerWell_Number = LinerWell_Number;
    }

    public String getLinerType() {
        return LinerType;
    }

    public void setLinerType(String LinerType) {
        this.LinerType = LinerType;
    }

    public String getLinerSize() {
        return LinerSize;
    }

    public void setLinerSize(String LinerSize) {
        this.LinerSize = LinerSize;
    }

    public String getLinerWeight() {
        return LinerWeight;
    }

    public void setLinerWeight(String LinerWeight) {
        this.LinerWeight = LinerWeight;
    }

    public String getLinerGrade() {
        return LinerGrade;
    }

    public void setLinerGrade(String LinerGrade) {
        this.LinerGrade = LinerGrade;
    }

    public String getLinerLength() {
        return LinerLength;
    }

    public void setLinerLength(String LinerLength) {
        this.LinerLength = LinerLength;
    }

    public String getLinerPSI() {
        return LinerPSI;
    }

    public void setLinerPSI(String LinerPSI) {
        this.LinerPSI = LinerPSI;
    }

    public String getLinerSAX() {
        return LinerSAX;
    }

    public void setLinerSAX(String LinerSAX) {
        this.LinerSAX = LinerSAX;
    }

    public String getLinerTopDepth() {
        return LinerTopDepth;
    }

    public void setLinerTopDepth(String LinerTopDepth) {
        this.LinerTopDepth = LinerTopDepth;
    }

    public String getLinerBottomDepth() {
        return LinerBottomDepth;
    }

    public void setLinerBottomDepth(String LinerBottomDepth) {
        this.LinerBottomDepth = LinerBottomDepth;
    }
    
                             String LinerWell_Number="";
                             String LinerType="";
                             String LinerSize="";    
                             String LinerWeight="";
                             String LinerGrade="";
                             String LinerLength="";
                             String LinerPSI="";
                             String LinerSAX="";
                             String LinerTopDepth="";
                             String LinerBottomDepth="";
                             String PdfName="";

    public String getPdfName() {
        return PdfName;
    }

    public void setPdfName(String PdfName) {
        this.PdfName = PdfName;
    }

    public LinerDetails(String aLinerWell_Number,String aLinerType,String aLinerSize,String aLinerWeight, String aLinerGrade,
            String aLinerLength, String aLinerPSI,String aLinerSAX,String aLinerTopDepth,String aLinerBottomDepth,String aPdfName)
                            {
        
                              LinerWell_Number=aLinerWell_Number;
                              LinerType= aLinerType;
                              LinerSize=aLinerSize;    
                              LinerWeight=aLinerWeight;
                              LinerGrade=aLinerGrade;
                              LinerLength=aLinerLength;
                              LinerPSI=aLinerPSI;
                              LinerSAX=aLinerSAX;
                              LinerTopDepth=aLinerTopDepth;
                              LinerBottomDepth=aLinerBottomDepth;
                              PdfName = aPdfName;
 
                             }
    
}
