package com.ashokit.ies.ies.DC.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ies.DC.Domain.CcapDtlsDomain;
import com.ashokit.ies.ies.DC.Domain.KTWorksDtlsDomain;
import com.ashokit.ies.ies.DC.Domain.SelectPlanDomain;
import com.ashokit.ies.ies.DC.Domain.SnapDtlsDomain;
import com.ashokit.ies.ies.DC.Service.DcService;

@Controller
public class DCSelectPlanController {

	@Autowired
	DcService dcService;

	@PostMapping("/selectedplan")
	public String handleSelectPlanNextBtn(@ModelAttribute("plandata") SelectPlanDomain selected,
			RedirectAttributes attr, Model model) {

		Map<Integer, Boolean> mapCase = dcService.registerPlan(selected);

		if (mapCase.isEmpty()) {
			attr.addFlashAttribute("err", "Something Went worong!!, Pls try Again later");
			return "redirect:/registercase";

		} else {

			String plan = selected.getPlan();

			switch (plan) {
			case "SNAP":

				SnapDtlsDomain snapDomain = new SnapDtlsDomain();
				snapDomain.setCaseId(selected.getCaseId());
				snapDomain.setName(selected.getFname() + "" + selected.getLname());
				snapDomain.setPlanName("SNAP");

				model.addAttribute("plandata", snapDomain);

				return "DCIncomeDetails";

			case "CCAP":

				CcapDtlsDomain ccapDomain = new CcapDtlsDomain();
				ccapDomain.setCaseId(selected.getCaseId());
				ccapDomain.setName(selected.getFname() + "" + selected.getLname());
				ccapDomain.setPlanName("CCAP");

				attr.addFlashAttribute("plandata", ccapDomain);
				return "redirect:/ccap?caseid="+selected.getCaseId()+"&name="+selected.getFname() + "" + selected.getLname();
				
			case "KTWORKS":

				List<String> grades = new ArrayList<String>();
				grades.add("A+");
				grades.add("A");
				grades.add("A-");
				grades.add("B+");
				grades.add("B");
				grades.add("B-");
				grades.add("C+");
				grades.add("C");
				grades.add("C-");
				model.addAttribute("grades", grades);

				List<String> quals = new ArrayList<String>();
				quals.add("HIGHSCHOOL");
				quals.add("INTERMEDIATE");
				quals.add("Diploma");
				quals.add("Certification");
				quals.add("GRADUATION");
				quals.add("POSTGRADUATION");
				quals.add("Doctorate");
				model.addAttribute("qualifications", quals);

				KTWorksDtlsDomain ktDomain = new KTWorksDtlsDomain();
				ktDomain.setCaseId(selected.getCaseId());
				ktDomain.setName(selected.getFname() + "" + selected.getLname());
				ktDomain.setPlanName("KTWORKS");

				model.addAttribute("plandata", ktDomain);

				return "DCEdcuationDetails";
			default:
				attr.addFlashAttribute("err", "Inncorrect plan Selected, Please Enter Correct Plan");

				return "redirect:/registercase";
			}

		}
	}

}
