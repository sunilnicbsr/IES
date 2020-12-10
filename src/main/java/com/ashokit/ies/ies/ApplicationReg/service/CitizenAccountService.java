package com.ashokit.ies.ies.ApplicationReg.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.ashokit.ies.ies.ApplicationReg.domain.CitizenAccountDomain;

@Service
public interface CitizenAccountService {
	
	public Map<String, Integer> registerCitizenAcc(CitizenAccountDomain cAcc);
	
	public String ssaWebRestCall(String ssn);

	public Iterable<CitizenAccountDomain> displayAllcAcc();

	public CitizenAccountDomain getC_accbyid(Integer cid);

	public boolean isC_AccountPresent(Integer cid);

	public boolean deleteC_Accountbyid(CitizenAccountDomain cAcc);

}
