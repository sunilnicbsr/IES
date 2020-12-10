package com.ashokit.ies.ies.DC.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.ies.ApplicationReg.domain.CitizenAccountDomain;
import com.ashokit.ies.ies.ApplicationReg.entity.CitizenAccountEntity;
import com.ashokit.ies.ies.ApplicationReg.repository.CitizenAccountRepository;
import com.ashokit.ies.ies.DC.Domain.CcapDtlsDomain;
import com.ashokit.ies.ies.DC.Domain.CreateCaseDomain;
import com.ashokit.ies.ies.DC.Domain.KTWorksDtlsDomain;
import com.ashokit.ies.ies.DC.Domain.SelectPlanDomain;
import com.ashokit.ies.ies.DC.Domain.SnapDtlsDomain;
import com.ashokit.ies.ies.DC.Entity.CcapPlanEntity;
import com.ashokit.ies.ies.DC.Entity.CreateCaseEntity;
import com.ashokit.ies.ies.DC.Entity.KTWorksEntity;
import com.ashokit.ies.ies.DC.Entity.SelectPlanEntity;
import com.ashokit.ies.ies.DC.Entity.SnapPlanEntity;
import com.ashokit.ies.ies.DC.Repository.DcCCAPRepository;
import com.ashokit.ies.ies.DC.Repository.DcCreateCaseRepository;
import com.ashokit.ies.ies.DC.Repository.DcKTWorksRepository;
import com.ashokit.ies.ies.DC.Repository.DcSNAPRepository;
import com.ashokit.ies.ies.DC.Repository.DcSelectPlanRepository;
import com.ashokit.ies.ies.admin.domain.PlanAdminDomain;
import com.ashokit.ies.ies.admin.entity.PlanAdminEnitity;
import com.ashokit.ies.ies.admin.repository.PlanAdminRespository;

@Service
public class DcServiceImpl implements DcService {

	@Autowired
	CitizenAccountRepository cRepo;

	@Autowired
	DcCreateCaseRepository dcCreateCaseRepo;

	@Autowired
	DcSelectPlanRepository dcSelectPlanRepo;

	@Autowired
	DcSNAPRepository dcSnapRepo;

	@Autowired
	DcKTWorksRepository ktRepo;

	@Autowired
	DcCCAPRepository ccapRepo;

	@Autowired
	PlanAdminRespository planRepo;

	@Override
	public CitizenAccountDomain CheckApplicationStatus(String appNo) {
		Optional<CitizenAccountEntity> optional = cRepo.findById(Integer.parseInt(appNo));
		CitizenAccountDomain c = new CitizenAccountDomain();
		if (optional.isPresent()) {
			CitizenAccountEntity entity = optional.get();
			BeanUtils.copyProperties(entity, c);
			return c;
		}

		return null;

	}

	@Override
	public Map<Integer, Boolean> registerCase(CreateCaseDomain createCaseDomain) {

		try {
			CreateCaseEntity entity = new CreateCaseEntity();

			Map<Integer, Boolean> isSavedMap = new HashMap<>();
			BeanUtils.copyProperties(createCaseDomain, entity);
			CreateCaseEntity svdentity = dcCreateCaseRepo.save(entity);
			boolean issaved = svdentity.getCaseId() != null;
			if (issaved) {
				isSavedMap.put(svdentity.getCaseId(), issaved);
				return isSavedMap;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;

		}
	}

	@Override
	public List<String> loadPlans() {

		List<String> plans = new ArrayList<>();

		List<PlanAdminEnitity> all = planRepo.findAll();
		all.forEach(e -> {
			plans.add(e.getPlanName());
		});

		return plans;
	}

	@Override
	public Map<Integer, Boolean> registerPlan(SelectPlanDomain selected) {
		SelectPlanEntity entity = new SelectPlanEntity();

		Map<Integer, Boolean> savedMap = new HashMap<>();
		BeanUtils.copyProperties(selected, entity);
		SelectPlanEntity svdentity = dcSelectPlanRepo.save(entity);
		boolean isSaved = svdentity.getSelectedPlanId() != null;
		if (isSaved) {
			savedMap.put(svdentity.getCaseId(), isSaved);
			return savedMap;
		} else {
			return null;
		}

	}

	@Override
	public Map<Integer, Boolean> registerSnap(SnapDtlsDomain snapDomain) {
		SnapPlanEntity entity = new SnapPlanEntity();
		Map<Integer, Boolean> savedMap = new HashMap<>();
		BeanUtils.copyProperties(snapDomain, entity);
		SnapPlanEntity svdentity = dcSnapRepo.save(entity);
		boolean isSaved = svdentity.getSnapPlanId() != null;
		if (isSaved) {
			savedMap.put(svdentity.getCaseId(), isSaved);
			return savedMap;
		} else {
			return null;
		}

	}

	@Override
	public Map<Integer, Boolean> registerKTPlan(KTWorksDtlsDomain ktDomain) {

		KTWorksEntity entity = new KTWorksEntity();

		Map<Integer, Boolean> savedMap = new HashMap<>();

		BeanUtils.copyProperties(ktDomain, entity);
		KTWorksEntity svdentity = ktRepo.save(entity);

		boolean isSaved = svdentity.getKtPlanId() != null;

		if (isSaved) {
			savedMap.put(svdentity.getCaseId(), isSaved);
			return savedMap;
		} else {
			return null;
		}
	}

	@Override
	public Map<Integer, Boolean> registerCcap(CcapDtlsDomain ccapDomain) {
		CcapPlanEntity entity = new CcapPlanEntity();

		Map<Integer, Boolean> savedMap = new HashMap<>();

		BeanUtils.copyProperties(ccapDomain, entity);
		CcapPlanEntity svdentity = ccapRepo.save(entity);

		boolean isSaved = svdentity.getCcapPlanId() != null;

		if (isSaved) {
			savedMap.put(svdentity.getCcapPlanId(), isSaved);
			return savedMap;
		} else {
			return null;
		}
	}

	@Override
	public Iterable<CcapDtlsDomain> displayAllCcaps() {
		List<CcapDtlsDomain> ccaps = new ArrayList<CcapDtlsDomain>();

		Iterable<CcapPlanEntity> all = ccapRepo.findAll();

		for (CcapPlanEntity element : all) {
			CcapDtlsDomain p = new CcapDtlsDomain();
			BeanUtils.copyProperties(element, p);
			ccaps.add(p);
		}
		return ccaps;
	}

	@Override
	public CcapDtlsDomain getCcapbyid(Integer ccapPlanId) {
		Optional<CcapPlanEntity> optional = ccapRepo.findById(ccapPlanId);// fetching data fromDB using cid sent by
		// controller
		CcapDtlsDomain p = new CcapDtlsDomain();// to store data fetched from DB to POJO and send to controller
		if (optional.isPresent())// null check
		{
			CcapPlanEntity entity = optional.get();// get optional data as entity
			BeanUtils.copyProperties(entity, p);// copy entity to pojo
			return p;
		}

		return null;
	}

	@Override
	public boolean isCcapPresent(Integer ccapPlanId) {

		return ccapRepo.existsById(ccapPlanId);
	}

	@Override
	public void deleteCcapbyid(Integer ccapPlanId) {

		ccapRepo.deleteById(ccapPlanId);

	}

}
