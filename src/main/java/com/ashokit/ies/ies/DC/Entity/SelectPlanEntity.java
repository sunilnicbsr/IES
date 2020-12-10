package com.ashokit.ies.ies.DC.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DC_Case_Plans")
public class SelectPlanEntity {

	@Id
	@Column(name = "Selected_Plan_Id")
	@GeneratedValue
	private Integer selectedPlanId;

	
	@Column(name = "Case_Number",unique = true)//unique have effect on table creation
	private Integer caseId;

	@Column(name = "First_Name")
	private String fname;

	@Column(name = "Last_Name")
	private String lname;

	@Column(name = "Plan")
	private String plan;

}
