package com.ashokit.ies.ies.admin.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.ies.admin.domain.AccountAdminDomain;
import com.ashokit.ies.ies.admin.entity.AccountAdminEntity;
import com.ashokit.ies.ies.admin.entity.PlanAdminEnitity;
import com.ashokit.ies.ies.admin.repository.AccountAdminRepository;
import com.ashokit.ies.ies.constants.AppConstants;
import com.ashokit.ies.ies.utils.EmailUtils;

@Service
public class AccountAdminServiceImpl implements AccountAdminService {
	@Autowired
	AccountAdminRepository accRepo;

	@Autowired
	private EmailUtils emailutil;
	
	@Autowired
	EntityManager entityManager;

	@Override
	public boolean isUniqueEmail(String email) {
		AccountAdminEntity entity = accRepo.findByEmail(email);

		return !(entity != null && (entity.getAccId() != null));
	}

	@Override
	public boolean registerAccount(AccountAdminDomain account) {

		account.setAccstatus("LOCKED");
		account.setPwd(generateTempPwd());
		AccountAdminEntity entity = new AccountAdminEntity();
		BeanUtils.copyProperties(account, entity);
		AccountAdminEntity savedEntity = accRepo.save(entity);
		if (savedEntity != null && (savedEntity.getAccId() != null)) {
			String to = account.getEmail();
			String subject = "--------Confirm Your Mail------";
			String body = getRegSuccMailBody(account);
			return emailutil.sendEmail(to, subject, body) ? true : false;
		}
		return false;
	}

	@Override
	public String generateTempPwd() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "!@#$%^&*?" + "0123456789"
				+ "abcdefghijklmnopqrstuvxyz";
		StringBuilder temppwd = new StringBuilder(6);

		for (int i = 0; i < 6; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			temppwd.append(AlphaNumericString.charAt(index));
		}

		return temppwd.toString();
	}

	@Override
	public String getRegSuccMailBody(AccountAdminDomain account) {
		String fileName = "UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt";
		List<String> replacedLines = null;
		String mailBody = null;
		try {
			Path path = Paths.get(fileName, "");
			Stream<String> lines = Files.lines(path);

			replacedLines = lines.map(line -> line.replace(AppConstants.FNAME, account.getFname())

					.replace(AppConstants.LNAME, account.getLname()).replace(AppConstants.TEMPPWD, account.getPwd())
					.replace(AppConstants.EMAILPLC, account.getEmail())).collect(Collectors.toList());

			mailBody = String.join("", replacedLines);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mailBody;
	}

	@Override
	public boolean sendRegSuccEmail(String to, String subject, String body) {

		return emailutil.sendEmail(to, subject, body);
	}

	public Iterable<AccountAdminEntity> findAllFilter(boolean isDeleted) {
		Session session = entityManager.unwrap(Session.class);
		Filter filter = session.enableFilter("deletedAccount_EntityFilter");
		filter.setParameter("isDeleted", isDeleted);
		Iterable<AccountAdminEntity> all = accRepo.findAll();
		session.disableFilter("deletedAccount_EntityFilter");
		return all;
	}
	
	
	@Override
	public List<AccountAdminDomain> displayAllAccounts() {
		List<AccountAdminDomain> accounts = new ArrayList<AccountAdminDomain>();
		// fetch all contacts fromDB
		Iterable<AccountAdminEntity> all = accRepo.findAll();

		for (AccountAdminEntity element : all) {
			AccountAdminDomain p = new AccountAdminDomain();
			BeanUtils.copyProperties(element, p);
			accounts.add(p);
		}
		return accounts;
	}

	@Override
	public AccountAdminDomain getAccountbyid(Integer aid) {
		Optional<AccountAdminEntity> optional = accRepo.findById(aid);// fetching data fromDB using cid sent by
		// controller
		AccountAdminDomain p = new AccountAdminDomain();// to store data fetched from DB to POJO and send to controller
		if (optional.isPresent())// null check
		{
			AccountAdminEntity entity = optional.get();// get optional data as entity
			BeanUtils.copyProperties(entity, p);// copy entity to pojo
			return p;
		}

		return null;// else return null
	}

	@Override
	public void deleteAccountbyid(Integer aid) {
		accRepo.deleteById(aid);

	}

	@Override
	public boolean isAccountPresent(Integer pid) {
		boolean ispresent = accRepo.existsById(pid);
		return ispresent;
	}

	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {
		AccountAdminEntity entity = accRepo.findByEmailAndPwd(email, tempPwd);

		return (entity != null && (entity.getAccId() != null));

	}

	@Override
	public boolean unlockAccount(String email, String password) {
		AccountAdminEntity entity = accRepo.findByEmail(email);

		if (entity != null && (entity.getAccId() != null)) {
			entity.setPwd(password);
			entity.setAccstatus("UNLOCKED");
			AccountAdminEntity savedentity = accRepo.save(entity);
			return (savedentity != null && (savedentity.getAccId() != null));

		}
		return false;
	}

	@Override
	public String recoverPassword(String email) {
		// check email valid or not
		AccountAdminEntity entity = accRepo.findByEmail(email);
		if (entity != null && (entity.getAccId() != null)) {
			AccountAdminDomain acc = new AccountAdminDomain();
			;
			BeanUtils.copyProperties(entity, acc);
			String to = acc.getEmail();
			String subject = "--------Recover Your Password------";
			String body = getRecoverPwdEmailBody(acc);
			return emailutil.sendEmail(to, subject, body) ? "SUCCESS" : "FAILED";
		}
		return "ERROR";
	}

	@Override
	public String getRecoverPwdEmailBody(AccountAdminDomain account) {
		String fileName = "RECOVERY_PASSWORD_EMAIL-BODY-TEMPLATE.txt";
		List<String> replacedLines = null;
		String mailBody = null;
		try {
			Path path = Paths.get(fileName, "");
			Stream<String> lines = Files.lines(path);

			replacedLines = lines.map(line -> line.replace(AppConstants.FNAME, account.getFname())
					.replace(AppConstants.LNAME, account.getLname()).replace(AppConstants.PWD, account.getPwd()))
					.collect(Collectors.toList());

			mailBody = String.join("", replacedLines);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mailBody;
	}

	@Override
	public String sendPwdToEmail(String to, String subject, String body) {
		return emailutil.sendEmail(to, subject, body) == true ? AppConstants.SUCCESS : AppConstants.FAILED;
	}

	@Override
	public String loginCheck(String email, String pwd) {

		String status = "";

		AccountAdminEntity entity = accRepo.findByEmailAndPwd(email, pwd);

		if (entity != null) {
			if (entity.getAccstatus().equals(AppConstants.UNLOCKED)) {
				status = AppConstants.SUCCESS;
			} else {
				status = AppConstants.LOCKED_MESSAGE;
			}
		} else {
			status = AppConstants.INVALID_CREDENTIALS_MESSAGE;
		}

		return status;
	}

}
