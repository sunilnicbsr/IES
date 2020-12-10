package com.ashokit.ies.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ies.admin.domain.PlanAdminDomain;
import com.ashokit.ies.ies.admin.service.PlanAdminService;

@Controller
public class PlanAdminDisplayController {
	@Autowired
	PlanAdminService ps;

	@RequestMapping(value = "/plan", method = RequestMethod.GET)
	public String loadpage(Model model) {

		PlanAdminDomain plan = new PlanAdminDomain();

		model.addAttribute("formdata", plan);
		return "PlanAdminRegister";

	}

	@RequestMapping(value = "/savePlan", method = RequestMethod.POST)
	public String submitBtnHandler(@ModelAttribute("formdata") PlanAdminDomain plan, RedirectAttributes attr) {
		boolean savePlan = ps.registerPlan(plan);
		if (plan.getPid() == null) {
			if (savePlan) {
				attr.addFlashAttribute("msg", "Plan saved");
			} else {
				attr.addFlashAttribute("errmsg", "Something is wrong");
			}
		} else {
			attr.addFlashAttribute("editmsg", "Plan updated succesfully");

		}
		return "redirect:/plan";
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String hyperlinkHandler(Model model) {
		Iterable<PlanAdminDomain> plans = ps.displayAllPlans();
		model.addAttribute("plans", plans);
		return "planAdminInfo";

	}

}
