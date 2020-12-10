package com.ashokit.ies.ies.admin.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PlanAdminDomain {

	private Integer pid;

	private String planName;

	private String planDesp;

	private String planStartDate;

	private String planEndDate;

	private Date updateddate;

	private Date createddate;

	private Boolean deleted;

}
