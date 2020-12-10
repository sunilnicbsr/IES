package com.ashokit.ies.ies.DC.Domain;

import java.util.Date;

import lombok.Data;

@Data
public class CreateCaseDomain {

	private Integer caseId;

	private Integer appId;

	private String fname;

	private String lname;

	private String dob;

	private String ssn;

	private String gender;

	private Long phno;

	private String email;

	private Date updateddate;

	private Date createddate;


}
