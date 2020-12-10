package com.ashokit.ies.ies.CO.Entity;

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
@Table(name = "CO_Triggers_Table")
public class COTriggersEntity {
	
	@Id
	@Column(name = "Trgid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trgId;

	@Column(name = "Case_Number")
	private Integer caseId;

	@Column(name = "Trg_Status")
	private String trgStatus; // running or pending

	@Column(name = "Updated_Date")
	@UpdateTimestamp
	private Date updateddate;

	@CreationTimestamp
	@Column(name = "Created_Date")
	private Date createddate;

}
