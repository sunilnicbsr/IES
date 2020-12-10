package com.ashokit.ies.ies.ED.Domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EdPlanInfoDomain {

	private String planName;
	private String planStatus; // granted or denied
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private String benefitAmt;
	private Integer caseId;
	private String denialReason;
}
