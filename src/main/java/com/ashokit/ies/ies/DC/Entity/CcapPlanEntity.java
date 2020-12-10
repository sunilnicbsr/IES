package com.ashokit.ies.ies.DC.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "DC_CCAP_Plan_Dtls")
public class CcapPlanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CCAP_Plan_Id")
	private Integer ccapPlanId;

	@Column(name = "Case_Number")
	private Integer caseId;

	@Column(name = "Applicant_Name")
	private String name;
	
	@Column(name = "Plan_Name")
	private String planName;
	
	@Column(name = "No_Of_Childrens")
	private Integer Childrens;

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "assessment", cascade =
	 * CascadeType.ALL, orphanRemoval = true) private List<ChildDetailsforCcap>
	 * childDetails;
	 */

	@Column(name = "Child_Gender")
	private String childGender;

	@Column(name = "Child_Name")
	private String childName;

	@Column(name = "Child_DOB")
	private String childDob;

	@Column(name = "Child_SSN")
	private String childSsn;

}
