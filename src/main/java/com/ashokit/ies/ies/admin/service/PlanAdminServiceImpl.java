package com.ashokit.ies.ies.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.ies.ApplicationReg.domain.CitizenAccountDomain;
import com.ashokit.ies.ies.ApplicationReg.entity.CitizenAccountEntity;
import com.ashokit.ies.ies.admin.domain.PlanAdminDomain;
import com.ashokit.ies.ies.admin.entity.PlanAdminEnitity;
import com.ashokit.ies.ies.admin.repository.PlanAdminRespository;

@Service
public class PlanAdminServiceImpl implements PlanAdminService {

	@Autowired
	PlanAdminRespository planRepo;

	@Autowired
	EntityManager entityManager;

	@Override
	public boolean registerPlan(PlanAdminDomain plan) {

		PlanAdminEnitity entity = new PlanAdminEnitity();
		BeanUtils.copyProperties(plan, entity);
		PlanAdminEnitity svdentity = planRepo.save(entity);
		return svdentity.getPid() != null;
	}

	public Iterable<PlanAdminEnitity> findAllFilter(boolean isDeleted) {
		Session session = entityManager.unwrap(Session.class);
		Filter filter = session.enableFilter("deletedPlan_DetailsFilter");
		filter.setParameter("isDeleted", isDeleted);
		Iterable<PlanAdminEnitity> all = planRepo.findAll();
		session.disableFilter("deletedPlan_DetailsFilter");
		return all;
	}

	@Override
	public Iterable<PlanAdminDomain> displayAllPlans() {
		List<PlanAdminDomain> plans = new ArrayList<PlanAdminDomain>();
		// fetch all contacts fromDB
		Iterable<PlanAdminEnitity> all = planRepo.findAll();
		// coping every entry to contactlist
		for (PlanAdminEnitity element : all) {
			PlanAdminDomain p = new PlanAdminDomain();
			BeanUtils.copyProperties(element, p);
			plans.add(p);
		}
		return plans;
	}

	@Override
	public PlanAdminDomain getPlanbyid(Integer pid) {
		Optional<PlanAdminEnitity> optional = planRepo.findById(pid);// fetching data fromDB using cid sent by
																		// controller
		PlanAdminDomain p = new PlanAdminDomain();// to store data fetched from DB to POJO and send to controller
		if (optional.isPresent())// null check
		{
			PlanAdminEnitity entity = optional.get();// get optional data as entity
			BeanUtils.copyProperties(entity, p);// copy entity to pojo
			return p;
		}

		return null;// else return null
	}

	@Override
	public boolean isPlanPresent(Integer pid) {
		boolean ispresent = planRepo.existsById(pid);
		return ispresent;
	}

	@Override
	public void deletePlanbyid(Integer pid) {
		planRepo.deleteById(pid);
	}
}
