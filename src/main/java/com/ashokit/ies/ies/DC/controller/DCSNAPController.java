package com.ashokit.ies.ies.DC.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ies.DC.Domain.CcapDtlsDomain;
import com.ashokit.ies.ies.DC.Domain.SnapDtlsDomain;
import com.ashokit.ies.ies.DC.Service.DcService;

@Controller
public class DCSNAPController {

	@Autowired
	DcService dcService;

	@PostMapping("/snapplan")
	public String handleSelectPlanNextBtn(@ModelAttribute("plandata")SnapDtlsDomain snapDomain,RedirectAttributes attr,Model model) {

		Map<Integer, Boolean> mapCase = dcService.registerSnap(snapDomain);

		if (mapCase.isEmpty()) {
			attr.addFlashAttribute("err", "Something Went worong!!, Pls try Again later");
			return "redirect:snapplanget";

		} else {
			model.addAttribute("succ", "Data Added to DB for SNAP");
			return "EDlandingPage";
		}
	}
	
	@GetMapping("/snapplanget")
	public String handleSelectPlanDoublePostingNextBtn(Model model) {
		SnapDtlsDomain snapDomain=new SnapDtlsDomain();
		model.addAttribute("plandata",snapDomain);

		return "DCIncomeDetails";


	}

}
