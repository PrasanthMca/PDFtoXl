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
public class CasingDetails {

    /**
     * @return the PdfFileName
     */
    public String getPdfFileName() {
        return PdfFileName;
    }

    /**
     * @param PdfFileName the PdfFileName to set
     */
    public void setPdfFileName(String PdfFileName) {
        this.PdfFileName = PdfFileName;
    }

    CasingDetails(String aType, String aSize, String aWeight, String aGrade, String aFeet, String aPSI, String aSAX, String aTopofCMT,String aWell_Number,String aPdfFile
) {
           
          this.Well_Number = aWell_Number;
          this.Type =aType;
	  this.Size = aSize;
	  this.Weight = aWeight;
	  this.Grade = aGrade;
          this.Feet = aFeet;
	  this.PSI = aPSI;
	  this.SAX = aSAX;
          this.TopofCMT = aTopofCMT;
          this.PdfFileName = aPdfFile;
        
    }

    /**
     * @return the Well_Number
     */
    public String getWell_Number() {
        return Well_Number;
    }

    /**
     * @param Well_Number the Well_Number to set
     */
    public void setWell_Number(String Well_Number) {
        this.Well_Number = Well_Number;
    }

    /**
     * @return the Type
     */
    public String getType() {
        return Type;
    }

    /**
     * @param Type the Type to set
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     * @return the Size
     */
    public String getSize() {
        return Size;
    }

    /**
     * @param Size the Size to set
     */
    public void setSize(String Size) {
        this.Size = Size;
    }

    /**
     * @return the Weight
     */
    public String getWeight() {
        return Weight;
    }

    /**
     * @param Weight the Weight to set
     */
    public void setWeight(String Weight) {
        this.Weight = Weight;
    }

    /**
     * @return the Grade
     */
    public String getGrade() {
        return Grade;
    }

    /**
     * @param Grade the Grade to set
     */
    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    /**
     * @return the Feet
     */
    public String getFeet() {
        return Feet;
    }

    /**
     * @param Feet the Feet to set
     */
    public void setFeet(String Feet) {
        this.Feet = Feet;
    }

    /**
     * @return the PSI
     */
    public String getPSI() {
        return PSI;
    }

    /**
     * @param PSI the PSI to set
     */
    public void setPSI(String PSI) {
        this.PSI = PSI;
    }

    /**
     * @return the SAX
     */
    public String getSAX() {
        return SAX;
    }

    /**
     * @param SAX the SAX to set
     */
    public void setSAX(String SAX) {
        this.SAX = SAX;
    }

    /**
     * @return the TopofCMT
     */
    public String getTopofCMT() {
        return TopofCMT;
    }

    /**
     * @param TopofCMT the TopofCMT to set
     */
    public void setTopofCMT(String TopofCMT) {
        this.TopofCMT = TopofCMT;
    }
    
         private String Well_Number;
         private String Type;
	 private String Size;
	 private String Weight;
	 private String Grade;
         private String Feet;
	 private String PSI;
	 private String SAX;
         private String TopofCMT;
         private String PdfFileName;
	 
    
}
