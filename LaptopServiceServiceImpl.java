package com.example.LoptopShowRoom.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LoptopShowRoom.Model.LaptopService;
import com.example.LoptopShowRoom.Repository.LaptopServiceRepository;

@Service
public class LaptopServiceServiceImpl implements LaptopServiceService {
	
	@Autowired
	private LaptopServiceRepository respo;

	@Override
	public List<LaptopService> showAllDetails() {
		
		return respo.findAll();
	}

	@Override
	public LaptopService addNewLaptopservice(LaptopService lap) {
		
		return respo.save(lap);
	}

	@Override
	public Optional<LaptopService> searchcusid(Integer servno) {
		
		return respo.findById(servno);
	}

	@Override
	public void deletePageLapserv(int custid) {
		
		respo.deleteById(custid);
	}

}
