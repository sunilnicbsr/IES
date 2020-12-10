package com.ashokit.ies.ies.DC.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ies.ApplicationReg.domain.CitizenAccountDomain;
import com.ashokit.ies.ies.DC.Domain.CreateCaseDomain;
import com.ashokit.ies.ies.DC.Domain.SelectPlanDomain;
import com.ashokit.ies.ies.DC.Service.DcService;

@Controller
public class DCCaseCreationController {

	@Autowired
	DcService dcService;

	@GetMapping(value = { "/DCdisplaycase" })
	public String index() {
		return "DCcheckApp";
	}

	@PostMapping("/createcase")
	public String handleSerachBtn(HttpServletRequest req, Model model) {

		String viewName = "";
		String appNo = req.getParameter("appno");

		CitizenAccountDomain status = dcService.CheckApplicationStatus(appNo);

		if (status != null) {
			model.addAttribute("formdata", status);
			viewName = "DCCreateCase";
		} else {
			model.addAttribute("errmsg", "Enter Correct Application Number");
			viewName = "DCcheckApp";
		}

		return viewName;

	}

	@GetMapping("/createcase")
	public String handleerrors(Model model) {
		CitizenAccountDomain cad = new CitizenAccountDomain();

		// logic to disable next button
		model.addAttribute("formdata", cad);
		return "DCCreateCase";

	}

	@PostMapping("/registercase")
	public String handleCreateCaseBtn(@ModelAttribute("formdata") CreateCaseDomain createCaseDomain,
			RedirectAttributes attr, Model model) {

		Map<Integer, Boolean> mapCase = dcService.registerCase(createCaseDomain);

		if (mapCase != null) {
			if (mapCase.isEmpty()) {
				attr.addFlashAttribute("err", "Something Went worong!!, Pls try later");
				return "redirect:/createcase";
			} else {
				List<String> plans = dcService.loadPlans();
				model.addAttribute("plans", plans);

				SelectPlanDomain selected = new SelectPlanDomain();

				selected.setCaseId((Integer) mapCase.keySet().toArray()[0]);
				selected.setFname(createCaseDomain.getFname());
				selected.setLname(createCaseDomain.getLname());

				model.addAttribute("plandata", selected);
				return "DCSelectPlan";
			}
		}

		else {
			attr.addFlashAttribute("err", "case already be registerd to this Application ");
			return "redirect:/createcase";
		}
	}

	@GetMapping("/registercase")
	public String handleErrorinregistration(Model model) {

		CitizenAccountDomain cad = new CitizenAccountDomain();

		// logic to disable next button
		model.addAttribute("formdata", cad);
		return "DCSelectPlan";

	}

}
