package com.ashokit.ies.ies.ApplicationReg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ashokit.ies.ies.ApplicationReg.domain.CitizenAccountDomain;
import com.ashokit.ies.ies.ApplicationReg.entity.CitizenAccountEntity;
import com.ashokit.ies.ies.ApplicationReg.repository.CitizenAccountRepository;
import com.ashokit.ies.ies.ApplicationReg.responseBinding.CitizenRecord;

@Service
public class CitizenAccountServiceImpl implements CitizenAccountService {
	@Autowired
	CitizenAccountRepository cRepo;
	@Autowired
	EntityManager entityManager;

	@Override
	public Map<String, Integer> registerCitizenAcc(CitizenAccountDomain cAcc) {
		// use map to catch hold of id

		Map<String, Integer> hm = new HashMap<String, Integer>();

		String ssn = cAcc.getSsn();
		cAcc.setDeleted(false);
		String test = ssaWebRestCall(ssn);
		// call rest rest resource
		if (test != "") {
			if (test.equalsIgnoreCase("KT") || test.equalsIgnoreCase("kentucky")) {

				CitizenAccountEntity entity = new CitizenAccountEntity();
				BeanUtils.copyProperties(cAcc, entity);
				CitizenAccountEntity svdentity = cRepo.save(entity);

				Integer id = svdentity.getAppId() != null ? hm.put("", svdentity.getAppId())
						: hm.put("Something is wrong", svdentity.getAppId());
				return hm;
			} else {
				hm.put("Citizen not of KENTUCKY, Pls Visit Nearest " + test + " DHS Department", null);
				return hm;
			}
		} else {
			hm.put("Incorrect SSN, Pls provide correct credentials", null);
			return hm;
		}
	}

	@Override
	public String ssaWebRestCall(String ssn) {
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:9090/verify/" + ssn;
		try {
			ResponseEntity<CitizenRecord> entity = rt.getForEntity(url, CitizenRecord.class);
			// System.out.println(entity);
			int i = entity.getStatusCodeValue();

			if (i == 200) {

				// System.out.println(entity.getBody().getState()); System.out.println(entity);
				return entity.getBody().getState();

			} else if (i == 400) {
				return "";
			}
		} catch (Exception e) {
			return "";
		}

		return "";

	}

	/*
	 * public Iterable<CitizenAccountEntity> findAllFilter(boolean isDeleted) {
	 * Session session = entityManager.unwrap(Session.class); Filter filter =
	 * session.enableFilter("deletedCitizen_AccountFilter");
	 * filter.setParameter("isDeleted", isDeleted); Iterable<CitizenAccountEntity>
	 * all = cRepo.findAll(); session.disableFilter("deletedCitizen_AccountFilter");
	 * return all; }
	 */

	@Override
	public Iterable<CitizenAccountDomain> displayAllcAcc() {
		List<CitizenAccountDomain> accounts = new ArrayList<CitizenAccountDomain>();
		Iterable<CitizenAccountEntity> all = cRepo.findAll();

		for (CitizenAccountEntity element : all) {
			CitizenAccountDomain c = new CitizenAccountDomain();
			BeanUtils.copyProperties(element, c);
			accounts.add(c);
		}
		return accounts;
	}

	@Override
	public CitizenAccountDomain getC_accbyid(Integer cid) {
		Optional<CitizenAccountEntity> optional = cRepo.findById(cid);
		CitizenAccountDomain c = new CitizenAccountDomain();
		if (optional.isPresent())// null check
		{
			CitizenAccountEntity entity = optional.get();
			BeanUtils.copyProperties(entity, c);
			return c;
		}

		return null;// else return null
	}

	@Override
	public boolean isC_AccountPresent(Integer cid) {
		boolean ispresent = cRepo.existsById(cid);
		return ispresent;
	}

	@Override
	public boolean deleteC_Accountbyid(CitizenAccountDomain cAcc) {

		Boolean flip = !cAcc.getDeleted();
		cAcc.setDeleted(flip);
		CitizenAccountEntity entity = new CitizenAccountEntity();
		BeanUtils.copyProperties(cAcc, entity);
		cRepo.save(entity);

		return flip;

	}

}
