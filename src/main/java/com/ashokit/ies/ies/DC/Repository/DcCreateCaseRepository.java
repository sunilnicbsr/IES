package com.ashokit.ies.ies.DC.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.ies.DC.Entity.CcapPlanEntity;
import com.ashokit.ies.ies.DC.Entity.CreateCaseEntity;

public interface DcCreateCaseRepository extends JpaRepository<CreateCaseEntity, Serializable> {
	public CcapPlanEntity findBycaseId(Integer caseId);
}
