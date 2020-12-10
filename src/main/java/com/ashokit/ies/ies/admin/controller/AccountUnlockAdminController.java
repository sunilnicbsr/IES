package com.ashokit.ies.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.ies.ies.admin.domain.UnlockAccountDomain;
import com.ashokit.ies.ies.admin.service.AccountAdminService;

@Controller
public class AccountUnlockAdminController {

	@Autowired
	AccountAdminService accService;

	@GetMapping("/unlockAcc")
	public String loadUnlockAccForm(@RequestParam("email") String email, Model model) {
		UnlockAccountDomain unlck = new UnlockAccountDomain();
		unlck.setEmail(email);
		model.addAttribute("unlockobj", unlck);

		return "accountUnlockAdminpage";
	}

	@PostMapping("/unlockAcc")
	public String handleSubmitBtn(@ModelAttribute("unlockobj") UnlockAccountDomain unlockAcc, Model model) {
		if (accService.isTempPwdValid(unlockAcc.getEmail(), unlockAcc.getTempPwd())) {
			String msg = accService.unlockAccount(unlockAcc.getEmail(), unlockAcc.getCnfrmPwd())
					? "Account Unlocked go to <a href=\"/ies/login\">Login Here</a>"
					: "Something Went worong!!, Pls try later";
			model.addAttribute("succ", msg);
		} else {
			model.addAttribute("err", "Enter Valid Password");
		}

		return "accountUnlockAdminpage";
	}

}
