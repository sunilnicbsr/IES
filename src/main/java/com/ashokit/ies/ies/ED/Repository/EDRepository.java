package com.ashokit.ies.ies.ED.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.ies.ED.Entity.EDPlanInfoEntity;

public interface EDRepository extends JpaRepository<EDPlanInfoEntity, Serializable> {

}
