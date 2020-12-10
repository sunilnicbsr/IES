package com.ashokit.ies.ies.admin.service;

import org.springframework.stereotype.Service;

import com.ashokit.ies.ies.admin.domain.AccountAdminDomain;

@Service
public interface AccountAdminService {

	public boolean isUniqueEmail(String email);

	public boolean registerAccount(AccountAdminDomain account);

	public String generateTempPwd();

	public String getRegSuccMailBody(AccountAdminDomain account);

	public boolean sendRegSuccEmail(String to, String subject, String body);

	public Iterable<AccountAdminDomain> displayAllAccounts();

	public AccountAdminDomain getAccountbyid(Integer aid);

	public void deleteAccountbyid(Integer aid);

	boolean isAccountPresent(Integer aid);

	public boolean isTempPwdValid(String email, String tempPwd);

	public boolean unlockAccount(String email, String cnfrmPwd);

	public String recoverPassword(String email);

	public String getRecoverPwdEmailBody(AccountAdminDomain account);

	public String sendPwdToEmail(String email, String subject, String body);

	public String loginCheck(String email, String pwd);

}
