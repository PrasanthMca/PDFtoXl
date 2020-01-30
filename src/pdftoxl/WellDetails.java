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

public class WellDetails {
	public String getWell_ID() {
		return Well_ID;
	}

	public void setWell_ID(String well_ID) {
		Well_ID = well_ID;
	}

	public String getOperator_Name() {
		return Operator_Name;
	}

	public void setOperator_Name(String operator_Name) {
		Operator_Name = operator_Name;
	}

	public String getOperator_Number() {
		return Operator_Number;
	}

	public void setOperator_Number(String operator_Number) {
		Operator_Number = operator_Number;
	}

	public String getWell_Name() {
		return Well_Name;
	}

	public void setWell_Name(String well_Name) {
		Well_Name = well_Name;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getDatum_Elevation() {
		return Datum_Elevation;
	}

	public void setDatum_Elevation(String datum_Elevation) {
		Datum_Elevation = datum_Elevation;
	}

	public String getGround_Elevation() {
		return Ground_Elevation;
	}

	public void setGround_Elevation(String ground_Elevation) {
		Ground_Elevation = ground_Elevation;
	}

	public String getPlugback_Depth() {
		return Plugback_Depth;
	}

	public void setPlugback_Depth(String plugback_Depth) {
		Plugback_Depth = plugback_Depth;
	}

	public String getTotal_Depth() {
		return Total_Depth;
	}

	public void setTotal_Depth(String total_Depth) {
		Total_Depth = total_Depth;
	}

	public String getSpud_Date() {
		return Spud_Date;
	}

	public void setSpud_Date(String spud_Date) {
		Spud_Date = spud_Date;
	}

	public String getCompletion_Date() {
		return Completion_Date;
	}

	public void setCompletion_Date(String completion_Date) {
		Completion_Date = completion_Date;
	}

	public String getFirstProDate() {
		return FirstProDate;
	}

	public void setFirstProDate(String firstProDate) {
		FirstProDate = firstProDate;
	}

	public String getDrill_Type() {
		return Drill_Type;
	}

	public void setDrill_Type(String drill_Type) {
		Drill_Type = drill_Type;
	}

	public String getDrill_Started() {
		return Drill_Started;
	}

	public void setDrill_Started(String drill_Started) {
		Drill_Started = drill_Started;
	}

	public String getDrill_Finished() {
		return Drill_Finished;
	}

	public void setDrill_Finished(String drill_Finished) {
		Drill_Finished = drill_Finished;
	}

	private String Well_ID;
	 private String Operator_Name;
	 private String Operator_Number;
	 private String Well_Name;
	 public String getWell_Number() {
		return Well_Number;
	}

	public void setWell_Number(String well_Number) {
		Well_Number = well_Number;
	}

	public String getWell_Type() {
		return Well_Type;
	}

	public void setWell_Type(String well_Type) {
		Well_Type = well_Type;
	}

	private String Well_Number;
	 private String Well_Type;
	 private String Status;
	 private String Datum_Elevation;
	 private String Ground_Elevation;
	 private String Plugback_Depth;
	 private String Total_Depth;
	 private String Spud_Date;
	 private String Completion_Date;
	 private String FirstProDate;
	 private String Drill_Type;
	 private String Drill_Started;
	 private String Drill_Finished;
	
	 public WellDetails(String well_id2, String operator_name2, String operator_number2, String well_name2,
			String well_number2, String status2,String classname, String datum_elevation2, String ground_elevation2,
			String plugback_depth2, String spud_date2, String completion_date2, String firstprodate2,
			String total_depth2, String drill_type2, String drill_started2, String drill_finished2) {
		 
		 this.Well_ID = well_id2;
		 this.Operator_Name = operator_name2;
		 this.Operator_Number = operator_number2;
		 this.Well_Name = well_name2;
		 this.Well_Number = well_number2;
		 this.Well_Type = classname;
		 this.Status = status2;
		 this.Datum_Elevation = datum_elevation2;
		 this.Ground_Elevation = ground_elevation2;
		 this.Plugback_Depth = plugback_depth2;
		 this.Spud_Date = spud_date2;
		 this.Completion_Date = completion_date2;
		 this.FirstProDate = firstprodate2;
		 this.Total_Depth = total_depth2;
		 this.Drill_Type = drill_type2;
		 this.Drill_Started = drill_started2;
		 this.Drill_Finished = drill_finished2;
		 
		 
	
	}

	 

}

