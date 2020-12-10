package com.ashokit.ies.ies.CO.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.ies.CO.Entity.COTriggersEntity;

public interface COTriggersRepository extends JpaRepository<COTriggersEntity, Serializable> {

	public List<COTriggersEntity> findByTrgStatus(String trgStatus);

}
