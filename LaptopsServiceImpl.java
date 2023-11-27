package com.example.LoptopShowRoom.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LoptopShowRoom.Model.Laptops;
import com.example.LoptopShowRoom.Repository.LaptopsRepository;

@Service 
public class LaptopsServiceImpl implements LaptopsService {
	
	@Autowired
	private LaptopsRepository respo;

	@Override
	public List<Laptops> showalldetails() {
		
		return respo.findAll();
	}

	@Override
	public Laptops addnewLaptops(Laptops laptops) {
		
		return respo.save(laptops);
	}

	@Override
	public Optional<Laptops> searchLaptop(String model) {
		
		return respo.findById(model);
	}

	@Override
	public void deletePage(String mod) {
		
		respo.deleteById(mod);
	}

	@Override
	public List<Laptops> showAllRecordsOfProcesser(String proceeser) {
	
		return respo.findByProcesser(proceeser);
	}

	@Override
	public List<Laptops> showallrecordsProcesserAndRam(String pro, int ram) {
		
		return respo.findByProcesserAndRam(pro, ram);
	}

	@Override
	public List<Laptops> showAllLap(int count) {
	    
		return respo.findlap(count);
	}

}
