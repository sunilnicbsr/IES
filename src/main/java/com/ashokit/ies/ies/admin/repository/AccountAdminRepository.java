package com.ashokit.ies.ies.admin.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.ies.admin.entity.AccountAdminEntity;

public interface AccountAdminRepository extends JpaRepository<AccountAdminEntity, Serializable> {

	public AccountAdminEntity findByEmail(String email);

	public AccountAdminEntity findByEmailAndPwd(String email, String pwd);

}
