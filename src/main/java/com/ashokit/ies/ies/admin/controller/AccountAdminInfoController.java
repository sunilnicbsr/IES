package com.ashokit.ies.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ies.admin.domain.AccountAdminDomain;
import com.ashokit.ies.ies.admin.service.AccountAdminService;

@Controller
public class AccountAdminInfoController {

	@Autowired
	AccountAdminService accService;

	@RequestMapping(value = "/addaccount", method = RequestMethod.GET)
	public String addPlan(Model model) {
		AccountAdminDomain acc = new AccountAdminDomain();
		model.addAttribute("formdata", acc);
		return "accountRegistrationAdminPage";

	}

	@RequestMapping(value = "/editaccount", method = RequestMethod.GET)
	public String getContactbyId(@RequestParam("id") Integer aid, Model model) {

		AccountAdminDomain accountAdminDomain = accService.getAccountbyid(aid);
		model.addAttribute("formdata", accountAdminDomain);
		return "accountRegistrationAdminPage";
	}

	@RequestMapping(value = "/delaccount", method = RequestMethod.GET)
	public String deleteContact(@RequestParam("id") Integer id, RedirectAttributes attr) {

		if (accService.isAccountPresent(id)) {
			accService.deleteAccountbyid(id);
			attr.addFlashAttribute("msg", "Plan deleted");
		}

		return "redirect:displayAccounts";

	}

}
