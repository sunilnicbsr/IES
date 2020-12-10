package com.ashokit.ies.ies.ED.Bindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data

public class EDDataBinding {

	private Integer Childrens;
	private Integer ccapPlanId;
	private Integer ktPlanId;
	private Integer snapPlanId;
	private Integer caseId;
	private String name;
	private String workingEmp;
	private String qual;
	private String planName;
	
	private EDPlanInfoBinding planInfo;

}
