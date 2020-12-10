package com.ashokit.ies.ies.ApplicationReg.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.ies.ApplicationReg.entity.CitizenAccountEntity;

public interface CitizenAccountRepository extends JpaRepository<CitizenAccountEntity, Serializable> {

	/*
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Query("update CitizenAccountEntity u set u.deleted = :deleted where u.cId = :cId"
	 * ) void updateEntry(@Param(value = "cId") Integer cId, @Param(value =
	 * "deleted") Boolean deleted);
	 */

}
