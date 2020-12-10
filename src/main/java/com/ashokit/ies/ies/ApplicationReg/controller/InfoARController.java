package com.ashokit.ies.ies.ApplicationReg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ies.ApplicationReg.domain.CitizenAccountDomain;
import com.ashokit.ies.ies.ApplicationReg.service.CitizenAccountService;

@Controller
public class InfoARController {
	@Autowired
	CitizenAccountService cs;

	@RequestMapping(value = "/addApplicant", method = RequestMethod.GET)
	public String addPlan(Model model) {
		CitizenAccountDomain cAcc = new CitizenAccountDomain();
		model.addAttribute("formdata", cAcc);
		return "CitizenApplicationRegistration";

	}

	@RequestMapping(value = "/editApplicant", method = RequestMethod.GET)
	public String getContactbyId(@RequestParam("id") Integer cid, Model model) {
		CitizenAccountDomain cAcc = cs.getC_accbyid(cid);
		model.addAttribute("formdata", cAcc);
		return "CitizenApplicationRegistration";
	}

	@RequestMapping(value = "/delApplicant", method = RequestMethod.GET)
	public String deleteContact(@RequestParam("id") Integer cid, RedirectAttributes attr) {
		if (cs.isC_AccountPresent(cid)) {
			CitizenAccountDomain citizenAccountDomain = cs.getC_accbyid(cid);
			boolean isdeleted = cs.deleteC_Accountbyid(citizenAccountDomain);
			String message = isdeleted ? "Applicant Record deactivated" : "Applicant Record activated";
			attr.addFlashAttribute("msg", message);
		}
		else {
			attr.addFlashAttribute("msg", "Record Not Found");
		}

		return "redirect:/displayCitizenAccounts";
	}

}
