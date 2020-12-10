package com.ashokit.ies.ies.ED.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.ies.ies.ED.Bindings.EDPlanInfoBinding;
import com.ashokit.ies.ies.ED.Service.EDData;
import com.ashokit.ies.ies.ED.Service.EDService;

@Controller
public class LoadEDPage {

	@Autowired
	EDService edService;

	@GetMapping("/edcall")
	public String handleSelectPlanNextBtn() {
		return "EDlandingPage";
	}

	@PostMapping("/edcall")
	public String handleEDBtn(HttpServletRequest req, Model model) {
		String caseNumber = req.getParameter("caseNumber");

		EDData edData = edService.findCaseId(Integer.parseInt(caseNumber));

		if (edData != null) {
			model.addAttribute("succ", "Pls Wait For Eligibility");
			EDPlanInfoBinding eligibility = edService.registerDetermineEligibility(edData);
			if (eligibility != null) {
				model.addAttribute("succ", "Your plan was " + eligibility.getPlanStatus()
						+ " A detailed ,reports will follow to your address");
				
				eligibility.setCaseId(Integer.parseInt(caseNumber));
				
				boolean isSaved = edService.registerAccount(eligibility);
			}

			else {

				model.addAttribute("err", "Something went wrong ,Pls try later");
			}

		} else {
			model.addAttribute("err", "Incorrect Case-number");

		}

		// fetch data from DC tables and put it into temp table
		// call ED rules API to fetch Plans Data
		// Insert Data into ED Elig detls
		// Insert Data into CO table
		return "EDlandingPage";
	}

}
