package com.ashokit.ies.ies.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "Account_Entity")

@SQLDelete(sql = "UPDATE Account_Entity SET Soft_Delete=true WHERE Account_Id=?") 

//override delete command with update
//@Where(clause = "Soft_Delete = false") // remove if you want to show all records

//to show the records for both soft-deleted and not-deleted entries we can use following

@FilterDef(name = "deletedAccount_EntityFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedAccount_EntityFilter", condition = "deleted = :isDeleted")
public class AccountAdminEntity {

	@Id
	@Column(name = "Account_Id")
	@GeneratedValue
	private Integer accId;

	@Column(name = "First_Name")
	private String fname;

	@Column(name = "Last_Name")
	private String lname;

	@Column(name = "Email")
	private String email;

	@Column(name = "Password")
	private String pwd;

	@Column(name = "SSN_No")
	private String ssn;

	@Column(name = "MobileNumber")
	private Long phno;

	@Column(name = "DateofBirth")
	private String dob;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "Role")
	private String role;

	@Column(name = "Updated_Date")
	@UpdateTimestamp
	private Date updateddate;

	@CreationTimestamp
	@Column(name = "Created_Date")
	private Date createddate;

	@Column(name = "Account_Status")
	private String accstatus;
	
	@Column(name = "Soft_Delete")
	private Boolean deleted;

}
