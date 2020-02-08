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
public class Formation {

    /**
     * @return the Well_ID
     */
    public String getWell_ID() {
        return Well_ID;
    }

    /**
     * @param Well_ID the Well_ID to set
     */
    public void setWell_ID(String Well_ID) {
        this.Well_ID = Well_ID;
    }

    /**
     * @return the Formation
     */
    public String getFormation() {
        return Formation;
    }

    /**
     * @param Formation the Formation to set
     */
    public void setFormation(String Formation) {
        this.Formation = Formation;
    }

    /**
     * @return the Top
     */
    public String getTop() {
        return Top;
    }

    /**
     * @param Top the Top to set
     */
    public void setTop(String Top) {
        this.Top = Top;
    }

    /**
     * @return the PDFName
     */
    public String getPDFName() {
        return PDFName;
    }

    /**
     * @param PDFName the PDFName to set
     */
    public void setPDFName(String PDFName) {
        this.PDFName = PDFName;
    }
    
              private String Well_ID;
              private String Formation;
              private String Top;
              private String PDFName;

    Formation(String aWell_id, String aFormation, String aTop, String aPdfName) {
        
        this.Well_ID   = aWell_id;
        this.Formation = aFormation;
        this.Top       = aTop;
        this.PDFName   = aPdfName;
   
    }
}
