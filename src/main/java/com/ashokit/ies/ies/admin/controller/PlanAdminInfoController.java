package com.ashokit.ies.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ies.admin.domain.PlanAdminDomain;
import com.ashokit.ies.ies.admin.service.PlanAdminService;
@Controller
public class PlanAdminInfoController {

	@Autowired
	PlanAdminService ps;

	@RequestMapping(value = "/addPlan", method = RequestMethod.GET)
	public String addPlan(Model model) {
		PlanAdminDomain plan = new PlanAdminDomain();
		model.addAttribute("formdata", plan);
		return "PlanAdminRegister";

	}

	 @RequestMapping(value = "/editPlan", method = RequestMethod.GET) 
	public String getContactbyId(@RequestParam("id") Integer pid, Model model) {
		PlanAdminDomain planAdminDomain = ps.getPlanbyid(pid);
		model.addAttribute("formdata", planAdminDomain);
		return "PlanAdminRegister";
	}

	@RequestMapping(value = "/delPlan", method = RequestMethod.GET)
	public String deleteContact(@RequestParam("id") Integer pid, RedirectAttributes attr) {
		if (ps.isPlanPresent(pid)) {
			ps.deletePlanbyid(pid);
			attr.addFlashAttribute("msg", "Plan deleted");
		}

		return "redirect:/display";
	}

}
