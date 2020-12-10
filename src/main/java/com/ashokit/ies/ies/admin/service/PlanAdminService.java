package com.ashokit.ies.ies.admin.service;

import org.springframework.stereotype.Service;

import com.ashokit.ies.ies.admin.domain.PlanAdminDomain;

@Service
public interface PlanAdminService {

	public boolean registerPlan (PlanAdminDomain plan);

	public Iterable<PlanAdminDomain> displayAllPlans();

	public PlanAdminDomain getPlanbyid(Integer pid);

	public boolean isPlanPresent(Integer pid);

	public void deletePlanbyid(Integer pid);

}
