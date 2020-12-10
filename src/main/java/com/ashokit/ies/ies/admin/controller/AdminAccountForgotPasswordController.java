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
public class AdminAccountForgotPasswordController {
	@Autowired
	AccountAdminService accService;

	@GetMapping("/forgotPwd")
	public String loadForm() {
		return "AdminAccountforgotPwd";
	}

	@PostMapping("/forgotPwd")
	public String handleForgotPwdSubmtBtn(HttpServletRequest req, Model model) {

		String email = req.getParameter(AppConstants.EMAIL);

		String status = accService.recoverPassword(email);

		if (status.equals(AppConstants.ERROR)) {

			model.addAttribute("err", "Enter Valid Email ID");

		} else {

			String msg = status.equals(AppConstants.SUCCESS) == true ? "Check Your Email for recovered password"
					: "Something went wrong,Password not recovered";

			model.addAttribute("succ", msg);

		}

		return "AdminAccountforgotPwd";
	}
}