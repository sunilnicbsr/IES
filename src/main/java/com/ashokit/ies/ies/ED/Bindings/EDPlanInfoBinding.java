package com.ashokit.ies.ies.ED.Bindings;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class EDPlanInfoBinding {

	private String planName;
	private String planStatus; // granted or denied
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private String benefitAmt;
	private Integer caseId;
	private String denialReason;
}
