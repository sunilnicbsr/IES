package com.ashokit.ies.ies.DC.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "DC_Case_Entity")
public class CreateCaseEntity {

	@Id
	@Column(name = "Case_Id")
	@GeneratedValue
	private Integer caseId;

	@Column(name = "Application_Number")
	private Integer appId;

	@Column(name = "First_Name")
	private String fname;

	@Column(name = "Last_Name")
	private String lname;

	@Column(name = "DateofBirth")
	private String dob;

	@Column(name = "SSN_No")
	private String ssn;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "MobileNumber")
	private Long phno;

	@Column(name = "Email")
	private String email;

	@Column(name = "Updated_Date")
	@UpdateTimestamp
	private Date updateddate;

	@CreationTimestamp
	@Column(name = "Created_Date")
	private Date createddate;

}
