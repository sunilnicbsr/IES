package com.ashokit.ies.ies.CO.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.ies.CO.Entity.CoBatchDtlsEntity;

public interface CObatchRepository extends JpaRepository<CoBatchDtlsEntity, Serializable> {

}
