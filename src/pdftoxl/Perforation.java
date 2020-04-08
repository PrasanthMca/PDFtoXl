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
public class Perforation {

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

    Perforation(String awell_id,String aFormationName,String aCode,String aClass, String aFrom, String aTo, String aOrderNo, String aUnitSize, String aFractureTreatments, String aAcidVolumes, String aPdfName) {

        this.Well_ID = awell_id;
        this.From = aFrom;
        this.To = aTo;
        this.OrderNo = aOrderNo;
        this.UnitSize = aUnitSize;
        this.FractureTreatments = aFractureTreatments;
        this.AcidVolumes = aAcidVolumes;
        this.PDFName = aPdfName;
        this.FormationName = aFormationName;
        this.Code = aCode;
        this.Class=aClass;

    }
    
    

    /**
     * @param Well_ID the Well_ID to set
     */
    public void setWellType(String Class) {
        this.Class = Class;
    }
     public String getWellType() {
        return Class;
    }
     public String getCode() {
        return Code;
    }

    /**
     * @param Well_ID the Well_ID to set
     */
    public void setCode(String Code) {
        this.Code = Code;
    }
 public String getFormationName() {
        return FormationName;
    }

    /**
     * @param Well_ID the Well_ID to set
     */
    public void setFormationName(String Formation_Name) {
        this.FormationName = Formation_Name;
    }
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
     * @return the From
     */
    public String getFrom() {
        return From;
    }

    /**
     * @param From the From to set
     */
    public void setFrom(String From) {
        this.From = From;
    }

    /**
     * @return the To
     */
    public String getTo() {
        return To;
    }

    /**
     * @param To the To to set
     */
    public void setTo(String To) {
        this.To = To;
    }

    /**
     * @return the OrderNo
     */
    public String getOrderNo() {
        return OrderNo;
    }

    /**
     * @param OrderNo the OrderNo to set
     */
    public void setOrderNo(String OrderNo) {
        this.OrderNo = OrderNo;
    }

    /**
     * @return the FractureTreatments
     */
    public String getFractureTreatments() {
        return FractureTreatments;
    }

    /**
     * @param FractureTreatments the FractureTreatments to set
     */
    public void setFractureTreatments(String FractureTreatments) {
        this.FractureTreatments = FractureTreatments;
    }

    /**
     * @return the AcidVolumes
     */
    public String getUnitSize() {
        return UnitSize;
    }

    /**
     * @param To the To to set
     */
    public void setUnitSize(String Unit_Size) {
        this.UnitSize = Unit_Size;
    }

    public String getAcidVolumes() {
        return AcidVolumes;
    }

    /**
     * @param AcidVolumes the AcidVolumes to set
     */
    public void setAcidVolumes(String AcidVolumes) {
        this.AcidVolumes = AcidVolumes;
    }

    private String Well_ID;
    private String From;
    private String To;
    private String OrderNo;
    private String FractureTreatments;
    private String AcidVolumes;
    private String PDFName;
    private String UnitSize;
    private String FormationName;
    private String Code;
      private String Class;

}
