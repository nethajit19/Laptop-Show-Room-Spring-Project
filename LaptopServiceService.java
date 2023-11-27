package com.example.LoptopShowRoom.Service;

import java.util.List;
import java.util.Optional;

import com.example.LoptopShowRoom.Model.LaptopService;

public interface LaptopServiceService {
	
	List<LaptopService> showAllDetails();
	
	LaptopService addNewLaptopservice(LaptopService lap);
	
	Optional<LaptopService> searchcusid(Integer servno);
	
	void deletePageLapserv(int custid);

}
