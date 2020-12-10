package com.ashokit.ies.ies.DC.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DC_Snap_Plan_Dtls")
public class SnapPlanEntity {

	@Id
	@Column(name = "Snap_Plan_Id")
	@GeneratedValue
	private Integer snapPlanId;

	@Column(name = "Case_Number",unique = true)
	private Integer caseId;

	@Column(name = "Name")
	private String name;
	
	@Column(name = "Plan_Name")
	private String planName;
   
	@Column(name = "Is_Working_Employee")
	private String workingEmp;

	@Column(name = "Other_Income")
	private String otherIncome;


}
