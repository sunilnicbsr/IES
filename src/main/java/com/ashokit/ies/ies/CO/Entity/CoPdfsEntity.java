package com.ashokit.ies.ies.CO.Entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CO_PDFS")
public class CoPdfsEntity {
	@Id
	@Column(name = "CO_PDF_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer coPdfId;

	@Column(name = "PLAN_STATUS")
	String planStatus;

	@Column(name = "CASE_Number")
	String caseNumber;

	@Column(name = "PDF_DOCUMENT")
	private Blob pdfDoc;

	@Column(name = "PLAN_NAME")
	String planName;

}
