package com.ashokit.ies.ies.ApplicationReg.entity;

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
@Table(name = "Citizen_Account_Entity")
/*
 * @SQLDelete(sql =
 * "UPDATE Citizen_Account_Entity SET Soft_Delete=true WHERE Citizen_Id=?")
 * 
 * // override delete command with update //@Where(clause =
 * "Soft_Delete = false") // remove if you want to show all records
 * 
 * //to show the records for both soft-deleted and not-deleted entries we can
 * use following
 * 
 * @FilterDef(name = "deletedCitizen_AccountFilter", parameters = @ParamDef(name
 * = "isDeleted", type = "boolean"))
 * 
 * @Filter(name = "deletedCitizen_AccountFilter", condition =
 * "deleted = :isDeleted")
 */
public class CitizenAccountEntity {
	@Id
	@Column(name = "Citizen_Application_Id")
	@GeneratedValue
	private Integer appId;

	@Column(name = "First_Name")
	private String fname;

	@Column(name = "Last_Name")
	private String lname;

	@Column(name = "Email")
	private String email;

	@Column(name = "DateofBirth")
	private String dob;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "SSN_No")
	private String ssn;

	@Column(name = "MobileNumber")
	private Long phno;

	@Column(name = "Updated_Date")
	@UpdateTimestamp
	private Date updateddate;

	@CreationTimestamp
	@Column(name = "Created_Date")
	private Date createddate;

	@Column(name = "Soft_Delete")
	private Boolean deleted;

}
