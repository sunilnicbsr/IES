package com.ashokit.ies.ies.ED.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ashokit.ies.ies.CO.Entity.COTriggersEntity;
import com.ashokit.ies.ies.CO.Repository.COTriggersRepository;
import com.ashokit.ies.ies.DC.Entity.CcapPlanEntity;
import com.ashokit.ies.ies.DC.Entity.KTWorksEntity;
import com.ashokit.ies.ies.DC.Entity.SnapPlanEntity;
import com.ashokit.ies.ies.DC.Repository.DcCCAPRepository;
import com.ashokit.ies.ies.DC.Repository.DcKTWorksRepository;
import com.ashokit.ies.ies.DC.Repository.DcSNAPRepository;
import com.ashokit.ies.ies.ED.Bindings.EDDataBinding;
import com.ashokit.ies.ies.ED.Bindings.EDPlanInfoBinding;
import com.ashokit.ies.ies.ED.Entity.EDPlanInfoEntity;
import com.ashokit.ies.ies.ED.Repository.EDRepository;

@Service
public class EDServiceImpl implements EDService {

	@Autowired
	DcSNAPRepository dcSnapRepo;

	@Autowired
	DcKTWorksRepository ktRepo;

	@Autowired
	DcCCAPRepository ccapRepo;

	@Autowired
	EDRepository edRepo;

	@Autowired
	COTriggersRepository coRepo;

	@Override
	public EDData findCaseId(Integer id) {
		SnapPlanEntity snapPlanEntity = dcSnapRepo.findBycaseId(id);

		KTWorksEntity ktWorksEntity = ktRepo.findBycaseId(id);

		CcapPlanEntity ccapPlanEntity = ccapRepo.findBycaseId(id);

		EDData edData = new EDData();

		if (snapPlanEntity == null && ktWorksEntity == null && ccapPlanEntity == null) {
			// TODO throw exception or return null
			return null;
		}

		if (snapPlanEntity != null) {
			edData.setCaseId(snapPlanEntity.getCaseId());
			edData.setSnapPlanId(snapPlanEntity.getSnapPlanId());

			edData.setName(snapPlanEntity.getName());
			edData.setPlanName(snapPlanEntity.getPlanName());

			edData.setWorkingEmp(snapPlanEntity.getWorkingEmp());

			return edData;
		}

		if (ktWorksEntity != null) {

			edData.setCaseId(ktWorksEntity.getCaseId());
			edData.setKtPlanId(ktWorksEntity.getKtPlanId());
			edData.setName(ktWorksEntity.getName());
			edData.setPlanName(ktWorksEntity.getPlanName());
			edData.setQual(ktWorksEntity.getQual());

			return edData;
		}

		if (ccapPlanEntity != null) {

			edData.setCaseId(ccapPlanEntity.getCaseId());
			edData.setName(ccapPlanEntity.getName());
			edData.setPlanName(ccapPlanEntity.getPlanName());
			edData.setCcapPlanId(ccapPlanEntity.getCcapPlanId());
			edData.setChildrens(ccapPlanEntity.getChildrens());
			return edData;
		}

		return null;

	}

	@Override
	public EDPlanInfoBinding registerDetermineEligibility(EDData edData) {

		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:9999/determineElig";
		EDDataBinding edDataBinding = new EDDataBinding();
		BeanUtils.copyProperties(edData, edDataBinding);

		ResponseEntity<EDPlanInfoBinding> entity = rt.postForEntity(url, edDataBinding, EDPlanInfoBinding.class);
		//System.out.println(entity + "{{{{{{{{{{{{{{{{{{{{");
		int i = entity.getStatusCodeValue();

		if (i == 200) {

			//System.out.println(entity.getBody() + "{{{{{{{{{{{{{{{{{{{{");
			return entity.getBody();

		}
		return null;

	}

	@Override
	public boolean registerAccount(EDPlanInfoBinding eligibility) {

		COTriggersEntity coEntity = new COTriggersEntity();
		coEntity.setTrgStatus("PENDING");
		coEntity.setCaseId(eligibility.getCaseId());

		EDPlanInfoEntity entity = new EDPlanInfoEntity();
		BeanUtils.copyProperties(eligibility, entity);

		EDPlanInfoEntity savedEntity = edRepo.save(entity);
		coRepo.save(coEntity);
		if (savedEntity != null && (savedEntity.getEdId() != null)) {
			return true;
		}
		return false;
	}

}
