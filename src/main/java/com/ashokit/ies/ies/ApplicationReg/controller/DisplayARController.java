package com.ashokit.ies.ies.ApplicationReg.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ies.ApplicationReg.domain.CitizenAccountDomain;
import com.ashokit.ies.ies.ApplicationReg.service.CitizenAccountService;

@Controller
public class DisplayARController {

	@Autowired
	CitizenAccountService cs;

	@RequestMapping(value = "/AccountRegistration", method = RequestMethod.GET)
	public String loadpage(Model model) {

		CitizenAccountDomain cAcc = new CitizenAccountDomain();

		model.addAttribute("formdata", cAcc);

		return "CitizenApplicationRegistration";

	}

	@RequestMapping(value = "/saveCitizenAccount", method = RequestMethod.POST)
	public String submitBtnHandler(@ModelAttribute("formdata") CitizenAccountDomain cAcc, RedirectAttributes attr) {
		Map<String, Integer> saveAcc = cs.registerCitizenAcc(cAcc);
	
		if (cAcc.getAppId() == null) {
			if (saveAcc.containsKey("")) {
				attr.addFlashAttribute("msg", "Application Number "+saveAcc.get("").toString()+" Plan Saved succesfully");
			} else {
			
				attr.addFlashAttribute("errmsg", saveAcc.keySet().toArray()[0]);
			}
		} else {
			attr.addFlashAttribute("editmsg", "Application Number  "+cAcc.getAppId()+" Plan updated succesfully");

		}
		return "redirect:/AccountRegistration";
	}

	@RequestMapping(value = "/displayCitizenAccounts", method = RequestMethod.GET)
	public String hyperlinkHandler(Model model) {
		Iterable<CitizenAccountDomain> applicants = cs.displayAllcAcc();
		model.addAttribute("applicants", applicants);
		return "CitizenApplicationInfo";

	}

}
