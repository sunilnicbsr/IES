package com.ashokit.ies.ies.DC.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DC_KT_Works_Plan_Dtls")
public class KTWorksEntity {

	@Id
	@Column(name = "KT_Works_Plan_Id")
	@GeneratedValue
	private Integer ktPlanId;

	@Column(name = "Case_Number",unique = true)
	private Integer caseId;

	@Column(name = "Name")
	private String name;
	
	@Column(name = "Plan_Name")
	private String planName;
   
	@Column(name = "Qualification")
	private String qual;
	
	@Column(name = "Year_Of_Passing")
	private String year;

	@Column(name = "Grades_Secured")
	private String grade;

}
