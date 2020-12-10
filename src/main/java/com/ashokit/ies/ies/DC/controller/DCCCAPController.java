package com.ashokit.ies.ies.DC.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ies.DC.Domain.CcapDtlsDomain;
import com.ashokit.ies.ies.DC.Service.DcService;

@Controller
public class DCCCAPController {

	@Autowired
	DcService dcService;

	@PostMapping("/ccap")
	public String handleaddBtn(@ModelAttribute("plandata") CcapDtlsDomain ccapDomain, RedirectAttributes attr) {

		Map<Integer, Boolean> mapCase = dcService.registerCcap(ccapDomain);

		if (ccapDomain.getCcapPlanId() == null) {
			if (mapCase != null) {
				CcapDtlsDomain ccapbyid = dcService.getCcapbyid((Integer) mapCase.keySet().toArray()[0]);
				String name = ccapbyid.getName();
				Integer caseid = ccapbyid.getCaseId();
				attr.addFlashAttribute("succ", "Child Data Added for CCAP");
				return "redirect:/ccap?caseid=" + caseid + "&name=" + name;
			} else {
				attr.addFlashAttribute("plandata", ccapDomain);
				attr.addFlashAttribute("err", "Something Went worong!!, Pls try Again later");
				return "redirect:/ccapeditpage";
			}
		} else

		{
			attr.addFlashAttribute("edit", "Plan updated succesfully");
			Integer caseid = ccapDomain.getCaseId();
			String name = ccapDomain.getName();
			return "redirect:/ccap?caseid=" + caseid + "&name=" + name;
		}

	}

	@GetMapping("/ccap")
	public String handleloading(@RequestParam("caseid") String caseid, @RequestParam("name") String name, Model model) {

		CcapDtlsDomain ccapDomain = new CcapDtlsDomain();
		ccapDomain.setCaseId(Integer.parseInt(caseid));
		ccapDomain.setName(name);
		ccapDomain.setPlanName("CCAP");
		model.addAttribute("plandata", ccapDomain);

		Iterable<CcapDtlsDomain> ccapPlans = dcService.displayAllCcaps();
		model.addAttribute("childDetails", ccapPlans);

		return "DCChildreansDetails";

	}

	@GetMapping("/ccapeditpage")
	public String handleedit(Model model) {

		Iterable<CcapDtlsDomain> ccapPlans = dcService.displayAllCcaps();
		model.addAttribute("childDetails", ccapPlans);

		return "DCChildreansDetails";

	}

	@GetMapping(value = "/editchilddetails")
	public String getContactbyId(@RequestParam("id") Integer ccapid, RedirectAttributes attr) {
		CcapDtlsDomain ccapDomain = dcService.getCcapbyid(ccapid);
		attr.addFlashAttribute("plandata", ccapDomain);

		return "redirect:/ccapeditpage";
	}

	@GetMapping(value = "/delchilddetails")
	public String deleteContact(@RequestParam("id") Integer ccapid, RedirectAttributes attr) {
		CcapDtlsDomain ccapbyid = dcService.getCcapbyid(ccapid);

		if (ccapbyid != null) {
			String name = ccapbyid.getName();
			Integer caseid = ccapbyid.getCaseId();
			dcService.deleteCcapbyid(ccapid);
			attr.addFlashAttribute("err", "Child Data for CCAP Deleted");
			return "redirect:/ccap?caseid=" + caseid + "&name=" + name;

		} else {
			attr.addFlashAttribute("err", "Something Went worong!!, Pls try Again later");
			return "redirect:/ccapeditpage";
		}
	}

	@PostMapping("/ccapplan")
	public String handleSelectPlanNextBtn(Model model) {
		model.addAttribute("succ", "Data Added to DB for C.C.A.P PLAN");
		return "EDlandingPage";
	}

}
