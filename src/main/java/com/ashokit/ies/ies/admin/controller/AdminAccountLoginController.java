package com.ashokit.ies.ies.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.ies.ies.admin.service.AccountAdminService;
import com.ashokit.ies.ies.constants.AppConstants;

@Controller
public class AdminAccountLoginController {

	@Autowired
	AccountAdminService accService;

	@GetMapping(value = {"/login" })
	public String index() {
		return "AccountAdminLoginPage";
	}

	@PostMapping("/signin")
	public String handleSignInBtn(HttpServletRequest req, Model model) {

		String viewName = "";
		String email = req.getParameter(AppConstants.EMAIL);
		String pwd = req.getParameter("pwd");

		String checkStatus = accService.loginCheck(email, pwd);

		if (checkStatus.equals(AppConstants.SUCCESS)) {
			model.addAttribute(AppConstants.EMAIL, email);
			viewName = "IESdashboard";
		} else {
			model.addAttribute("err", checkStatus);
			viewName = "AccountAdminLoginPage";
		}

		return viewName;

	}

}