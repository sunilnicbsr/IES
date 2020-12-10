package com.ashokit.ies.ies.admin.domain;

import java.util.Date;

import lombok.Data;

@Data
public class AccountAdminDomain {

	private Integer accId;

	private String fname;

	private String lname;

	private String email;

	private String pwd;

	private String ssn;

	private Long phno;

	private String dob;

	private String gender;

	private String role;

	private Date updateddate;

	private Date createddate;

	private String accstatus;
	
	private Boolean deleted;

}
