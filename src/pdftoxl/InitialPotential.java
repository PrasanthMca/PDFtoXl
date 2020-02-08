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
public class InitialPotential {

    InitialPotential(String awell_id, String aTesData, String aOilVolume, String aOilRate, String aGasVolume, String aGasRate, String aWaterVolume, 
            String aFlowType, String aFlowPressure, String aChoke, String aBHPressure, String aRemark,String aPdfName) {


        
          this.Well_ID = awell_id;
         this.TesData  = aTesData ;
	 this.OilVolume = aOilVolume;
	 this. OilRate = aOilRate;
	 this.GasVolume = aGasVolume;
         this. GasRate = aGasRate;
	 this.WaterVolume = aWaterVolume;
	 this.FlowType = aFlowType;
         this.FlowPressure = aFlowPressure;
         this.Choke = aChoke;
         this.BHPressure = aBHPressure;
         this.Remark = aRemark;
         this.PDFName = aPdfName;


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
     * @return the TesData
     */
    public String getTesData() {
        return TesData;
    }

    /**
     * @param TesData the TesData to set
     */
    public void setTesData(String TesData) {
        this.TesData = TesData;
    }

    /**
     * @return the OilVolume
     */
    public String getOilVolume() {
        return OilVolume;
    }

    /**
     * @param OilVolume the OilVolume to set
     */
    public void setOilVolume(String OilVolume) {
        this.OilVolume = OilVolume;
    }

    /**
     * @return the OilRate
     */
    public String getOilRate() {
        return OilRate;
    }

    /**
     * @param OilRate the OilRate to set
     */
    public void setOilRate(String OilRate) {
        this.OilRate = OilRate;
    }

    /**
     * @return the GasVolume
     */
    public String getGasVolume() {
        return GasVolume;
    }

    /**
     * @param GasVolume the GasVolume to set
     */
    public void setGasVolume(String GasVolume) {
        this.GasVolume = GasVolume;
    }

    /**
     * @return the GasRate
     */
    public String getGasRate() {
        return GasRate;
    }

    /**
     * @param GasRate the GasRate to set
     */
    public void setGasRate(String GasRate) {
        this.GasRate = GasRate;
    }

    /**
     * @return the WaterVolume
     */
    public String getWaterVolume() {
        return WaterVolume;
    }

    /**
     * @param WaterVolume the WaterVolume to set
     */
    public void setWaterVolume(String WaterVolume) {
        this.WaterVolume = WaterVolume;
    }

    /**
     * @return the FlowType
     */
    public String getFlowType() {
        return FlowType;
    }

    /**
     * @param FlowType the FlowType to set
     */
    public void setFlowType(String FlowType) {
        this.FlowType = FlowType;
    }

    /**
     * @return the FlowPressure
     */
    public String getFlowPressure() {
        return FlowPressure;
    }

    /**
     * @param FlowPressure the FlowPressure to set
     */
    public void setFlowPressure(String FlowPressure) {
        this.FlowPressure = FlowPressure;
    }

    /**
     * @return the Choke
     */
    public String getChoke() {
        return Choke;
    }

    /**
     * @param Choke the Choke to set
     */
    public void setChoke(String Choke) {
        this.Choke = Choke;
    }

    /**
     * @return the BHPressure
     */
    public String getBHPressure() {
        return BHPressure;
    }

    /**
     * @param BHPressure the BHPressure to set
     */
    public void setBHPressure(String BHPressure) {
        this.BHPressure = BHPressure;
    }

    /**
     * @return the Remark
     */
    public String getRemark() {
        return Remark;
    }

    /**
     * @param Remark the Remark to set
     */
    public void setRemark(String Remark) {
        this.Remark = Remark;
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
         private String TesData;
	 private String OilVolume;
	 private String OilRate;
	 private String GasVolume;
         private String GasRate;
	 private String WaterVolume;
	 private String FlowType;
         private String FlowPressure;
         private String Choke;
         private String BHPressure;
         private String Remark;
         private String PDFName;
         
    
}
