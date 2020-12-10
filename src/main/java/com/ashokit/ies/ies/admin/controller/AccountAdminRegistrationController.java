package com.ashokit.ies.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ies.admin.domain.AccountAdminDomain;
import com.ashokit.ies.ies.admin.service.AccountAdminService;

@Controller
public class AccountAdminRegistrationController {

	@Autowired
	AccountAdminService accService;

	/*
	 * @ModelAttribute public void loadFormData(Model model) { AccountAdminDomain
	 * acc = new AccountAdminDomain(); model.addAttribute("formdata", acc); }
	 */

	@GetMapping("/register")
	public String loadRegForm(Model model) {
		AccountAdminDomain acc = new AccountAdminDomain();
		model.addAttribute("formdata", acc);
		return "accountRegistrationAdminPage";
	}

	@GetMapping("/uniqueMailCheck")
	public @ResponseBody String isEmailUnique(@RequestParam("email") String email) {

		return accService.isUniqueEmail(email) == true ? "Unique Email" : "Email Already Exists";

	}

	@PostMapping("/accountRegistration")
	public String handleRegisterBtn(@ModelAttribute("formdata") AccountAdminDomain acc, RedirectAttributes attr) {

		boolean isSaved = accService.registerAccount(acc);
		if (acc.getAccId() == null) {
			if (isSaved) {
				attr.addFlashAttribute("succ", "Registration almost completed, Check your mail for final step!!");
			} else {
				attr.addFlashAttribute("err", "Something Went worong!!, Pls try later");
			}
		} else {
			attr.addFlashAttribute("editmsg", "Account updated succesfully, Check your mail for final step!!");

		}
		return "redirect:/register";

		/*
		 * if (accService.registerAccount(acc)) model.addAttribute("succ",
		 * "Registration almost completed, Check your mail for final step!!"); else
		 * model.addAttribute("err", "Something Went worong!!, Pls try later");
		 * 
		 * return "accountRegistrationAdminPage";
		 */
	}

	@RequestMapping(value = "/displayAccounts", method = RequestMethod.GET)
	public String hyperlinkHandler(Model model) {
		Iterable<AccountAdminDomain> accounts = accService.displayAllAccounts();
		model.addAttribute("accounts", accounts);
		return "accountAdminInfo";

	}

}
