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
public class PackerDetails {
    
       
    String well_id ="";
    String PackerDepth ="";
    String PackerBrandType ="";
       String PdfName="";

    public String getWell_id() {
        return well_id;
    }

    public void setWell_id(String well_id) {
        this.well_id = well_id;
    }

    public String getPackerDepth() {
        return PackerDepth;
    }

    public void setPackerDepth(String PackerDepth) {
        this.PackerDepth = PackerDepth;
    }

    public String getPackerBrandType() {
        return PackerBrandType;
    }

    public void setPackerBrandType(String PackerBrandType) {
        this.PackerBrandType = PackerBrandType;
    }

    public String getPdfName() {
        return PdfName;
    }

    public void setPdfName(String PdfName) {
        this.PdfName = PdfName;
    }

    PackerDetails(String awell_id, String aPackerDepth, String aPackerBrandType ,String aPdfName) {
             well_id =awell_id;
     PackerDepth =aPackerDepth;
     PackerBrandType =aPackerBrandType;
      PdfName = aPdfName;
        
    }
    
}
