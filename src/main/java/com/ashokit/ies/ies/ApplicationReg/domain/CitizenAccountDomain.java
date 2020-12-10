package com.ashokit.ies.ies.ApplicationReg.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CitizenAccountDomain {
	
	private Integer appId;

	private String fname;

	private String lname;

	private String email;

	private String dob;

	private String gender;
	
	private String ssn;

	private Long phno;

	private Date updateddate;

	private Date createddate;

	private Boolean deleted;

}
