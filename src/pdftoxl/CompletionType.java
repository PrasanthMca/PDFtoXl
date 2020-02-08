/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftoxl;

/**
 *
 * @author gokul_krishnan
 */
public class CompletionType {

    CompletionType(String aWell_id, String aCompletionTypeOption, String aPdfName) {


        this.apiNo = aWell_id;
        this.CompletionType = aCompletionTypeOption;
        this.PDfName = aPdfName;
    }

    /**
     * @return the PDfName
     */
    public String getPDfName() {
        return PDfName;
    }

    /**
     * @param PDfName the PDfName to set
     */
    public void setPDfName(String PDfName) {
        this.PDfName = PDfName;
    }
    private String apiNo = ""; 
    private String CompletionType = "";
    private String PDfName ="";
    
    
    
    
    public void setAPINo(String newApiNo){
        this.apiNo = newApiNo;
    }
    
    public void setCompletionType(String newCompletionType){
        this.CompletionType = newCompletionType;
    }
    
    public String getAPINo(){
        return this.apiNo;
    }
    
    public String getCompletionType(){
        return this.CompletionType;
    }
    
}
