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
public class PlugDetails {
    
    String well_id ="";
    String PlugDepth ="";
    String PlugType ="";

    public String getPdfName() {
        return PdfName;
    }

    public void setPdfName(String PdfName) {
        this.PdfName = PdfName;
    }
       String PdfName="";

    public String getWell_id() {
        return well_id;
    }

    public void setWell_id(String well_id) {
        this.well_id = well_id;
    }

    public String getPlugDepth() {
        return PlugDepth;
    }

    public void setPlugDepth(String PlugDepth) {
        this.PlugDepth = PlugDepth;
    }

    public String getPlugType() {
        return PlugType;
    }

    public void setPlugType(String PlugType) {
        this.PlugType = PlugType;
    }

    PlugDetails(String awell_id, String aPlugDepth, String aPlugType,String aPdfName) {
        
            well_id =awell_id;
            PlugDepth =aPlugDepth;
            PlugType =aPlugType;
             PdfName = aPdfName;
       
    }
    
    
}
