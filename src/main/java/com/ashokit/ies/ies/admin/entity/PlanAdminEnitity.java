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
@Table(name = "Plan_Details")
@SQLDelete(sql = "UPDATE Plan_Details SET Soft_Delete=true WHERE Plan_Id=?") 

//override delete command with update
//@Where(clause = "Soft_Delete = false") // remove if you want to show all records

//to show the records for both soft-deleted and not-deleted entries we can use following

@FilterDef(name = "deletedPlan_DetailsFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedPlan_DetailsFilter", condition = "deleted = :isDeleted")

public class PlanAdminEnitity {

	@Id
	@Column(name = "Plan_Id")
	@GeneratedValue
	private Integer pid;

	@Column(name = "Plan_Name")
	private String planName;

	@Column(name = "Plan_Description")
	private String planDesp;

	@Column(name = "Plan_Start_Date")
	private String planStartDate;

	@Column(name = "Plan_End_Date")
	private String planEndDate;

	@Column(name = "Plan_Updated_Date")
	@UpdateTimestamp
	private Date updateddate;

	@CreationTimestamp
	@Column(name = "Plan_Created_Date")
	private Date createddate;

	@Column(name = "Soft_Delete")
	private Boolean deleted;

}
