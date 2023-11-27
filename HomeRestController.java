package com.example.LoptopShowRoom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LoptopShowRoom.Model.Laptops;
import com.example.LoptopShowRoom.Service.LaptopsService;


@RestController
public class HomeRestController {
	
	@Autowired
	private LaptopsService lap;
	
	@GetMapping(path="/api/laptops" ,produces = {"application/xml" ,"application/json"})
	public List<Laptops> showAlldetails()
	{
		return lap.showalldetails();
	}
	
	@GetMapping("/api/laptop/{id}")
	public Optional<Laptops> searchModel(@PathVariable("id") String model)
	{
		return lap.searchLaptop(model);
	}
	
	@PostMapping(path="/api/laptop" , consumes = "application/json")
	public Laptops addLaptops(@RequestBody Laptops laps)
	{
		Optional<Laptops> opt=lap.searchLaptop(laps.getModel());
		
		if(opt.isEmpty())
		{
			return lap.addnewLaptops(laps);
		}
		
		else
		{
			return new Laptops();
		}
	}  
	
	@PutMapping("/api/laptop")
	public Laptops updatePage(@RequestBody Laptops lapss)
	{
		Optional<Laptops> opt=lap.searchLaptop(lapss.getModel());
		
		if(opt.isPresent())
		{
			return lap.addnewLaptops(lapss);
		}
		else
		{
			return new Laptops();
		}
	}
	
	@DeleteMapping("/api/laptop/{id}")
	public Optional<Laptops> deleteLap(@PathVariable("id") String model)
	{
		Optional<Laptops> opt=lap.searchLaptop(model);
		
		if(opt.isPresent())
		{
			lap.deletePage(model);
			return opt;
		}
		
		else
		{
			return Optional.ofNullable(new Laptops());
		}
	}
	
	
	

}
