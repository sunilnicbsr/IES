package com.ashokit.ies.ies.DC.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.ies.DC.Entity.SnapPlanEntity;

public interface DcSNAPRepository extends JpaRepository<SnapPlanEntity, Serializable> {
	public SnapPlanEntity findBycaseId(Integer caseId);
}
