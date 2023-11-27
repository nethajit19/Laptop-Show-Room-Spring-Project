   package com.example.LoptopShowRoom.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.LoptopShowRoom.Model.Laptops;
import com.example.LoptopShowRoom.Service.LaptopsService;

@Controller 
public class LaptopController {
	
	@Autowired
	private LaptopsService lapserv;
	
	@GetMapping("/")
	public String homePage()
	{
		return "index";
	}
	
	@GetMapping("/view")
	public String viewPage(Model model)
	{
		model.addAttribute("alllaptops",lapserv.showalldetails());
		return "view";
	}
	
	@GetMapping("/add")
	public String addPage(Model model)
	{
		model.addAttribute("obj",new Laptops());
		return "add";
	}
	
	@PostMapping("/add")
	public String searchPage(@ModelAttribute("obj") Laptops laptops)
	{
		Optional<Laptops> opt=lapserv.searchLaptop(laptops.getModel());
		
		if(opt.isEmpty())
		{
			lapserv.addnewLaptops(laptops);
			return "redirect:/view";
		}
		
		else
		{
			return "redirect:/add?failed";
			
		}
		
	}
	
	
	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable("id") String mod,Model model)
	{
		model.addAttribute("obj",lapserv.searchLaptop(mod));
		return "edit";
	}
	
	@PostMapping("/edit")
	public String updatePage(@ModelAttribute("obj") Laptops laptops)
	{
		lapserv.addnewLaptops(laptops);
		return "redirect:/view";
	}
	
	@GetMapping("/delete/{id}")
	public String deletepa(@PathVariable("id") String mod)
	{
		lapserv.deletePage(mod);
		return "redirect:/view";
	}
	
	@GetMapping("view/search/processer-wise")
	public String searchPoseer(@RequestParam("key") String pro,Model model)
	{
    	model.addAttribute("alllaptops",lapserv.showAllRecordsOfProcesser(pro));
	    return "view";
	}
	
	@GetMapping("view/search/processer-ram-wise")
	public String searchProceeserAndRam(@RequestParam("open") String pros ,@RequestParam("hint") Integer ram,Model model)
	{
		model.addAttribute("alllaptops",lapserv.showallrecordsProcesserAndRam(pros, ram));
		return "/view";
		
	}
	
	@GetMapping("view/search/count-wise")
	public String lapcount(@RequestParam("take")int num,Model model)
	{
		model.addAttribute("alllaptops", lapserv.showAllLap(num));
		return "view";
	}
	
	
	
	
	
	
	
	
	
	

}
