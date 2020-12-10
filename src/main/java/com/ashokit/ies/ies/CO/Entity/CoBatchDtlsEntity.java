package com.ashokit.ies.ies.CO.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BATCH_RUN_DTLS")
public class CoBatchDtlsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_BATCH_RUN_SEQ")
	private Integer coBatchseq;

	@Column(name = "BATCH_NAME")
	private String batchName;

	@Column(name = "BATCH_RUN_STATUS")
	private String batchRunStatus;

	@Column(name = "INSTANCE_NUM")
	private Integer instance;

	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "START_DATE")
	private  Date startDate;

}
