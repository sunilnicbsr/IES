package com.ashokit.ies.ies.ED.Entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "ELIGIBILITY_DETAILS")
public class EDPlanInfoEntity {

	@Id
	@Column(name = "ed_trace__ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer edId;

	@Column(name = "Plan_Name")
	private String planName;

	@Column(name = "Plan_Status")
	private String planStatus; // granted or denied

	@Column(name = "Plan_Start_Date")
	private LocalDate planStartDate;  
	

	@Column(name = "Plan_End_Date")
	private LocalDate planEndDate;

	@Column(name = "Benifit_Amount")
	private String benefitAmt;

	@Column(name = "Denial_Reason")
	private String denialReason;

	@Column(name = "Case_Id")
	private Integer caseId;
	
	@Column(name = "Updated_Date")
	@UpdateTimestamp
	private Date updateddate;

	@CreationTimestamp
	@Column(name = "Created_Date")
	private Date createddate;

}
