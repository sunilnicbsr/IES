package com.ashokit.ies.ies.ApplicationReg.responseBinding;

import java.util.Date;

import lombok.Data;

@Data
public class CitizenRecord {

	private Long ssn;
	
	private String fname;

	private String lname;

	private String gender;

	private Date dob;

	private String state;
	
}
