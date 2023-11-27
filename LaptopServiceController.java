package com.example.LoptopShowRoom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.LoptopShowRoom.Model.LaptopService;
import com.example.LoptopShowRoom.Service.LaptopServiceService;

@Controller
public class LaptopServiceController {
	
	@Autowired
	private LaptopServiceService servu;
	
	@GetMapping("/serviceview")
	public String lapServPage(Model model)
	{
		model.addAttribute("alllapservice",servu.showAllDetails());
		return "/servicelap/view";
	}
	
	@GetMapping("/serviceform")
	public String addPage(Model model)
	{
		model.addAttribute("servobj", new LaptopService());
		return "/servicelap/add";
	}
	
	@PostMapping("/serviceform")
	public String submitPage(@ModelAttribute("servobj") LaptopService laps)
	{
		servu.addNewLaptopservice(laps);
		return "redirect:/serviceview";
	}
	
	@GetMapping("/service/edit/{id}")
	public String editPage(@PathVariable("id") Integer cusid,Model model)
	{
		model.addAttribute("servobj",servu.searchcusid(cusid));
		return "/servicelap/edit";
	}
	
	@PostMapping("/service/edit")
	public String updatePage(@ModelAttribute("servobj") LaptopService lup)
	{
		servu.addNewLaptopservice(lup);
		return "redirect:/serviceview";
	}
	
	@GetMapping("/service/delete/{id}")
	public String deletePage(@PathVariable("id") Integer cussei)
	{
		servu.deletePageLapserv(cussei);
		return "redirect:/serviceview";
	}
	
	
	

}
