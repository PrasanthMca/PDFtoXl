/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftoxl;

/**
 *
 * @author karthik_selvam
 */
public class ProductionZoneDetails {
    
    public ProductionZoneDetails(String Wellid, String OTCProductioNo )
    {
        this.Well_ID = Wellid;
        this.OTCProductionUnitNo = OTCProductioNo;
    }
    String Well_ID;
    private String OTCProductionUnitNo;
    
        public String getWell_ID() {
		return Well_ID;
	}

	public void setWell_ID(String well_ID) {
		this.Well_ID = well_ID;
	}
        public String getOTCProductionUnitNo() {
		return OTCProductionUnitNo;
	}

	public void setOTCProductionUnitNo(String OTCProductionUnitNo) {
		this.OTCProductionUnitNo= OTCProductionUnitNo;
	}

    
    
    
}