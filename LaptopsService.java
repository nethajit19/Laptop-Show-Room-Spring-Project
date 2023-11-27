package com.example.LoptopShowRoom.Service;

import java.util.List;
import java.util.Optional;

import com.example.LoptopShowRoom.Model.Laptops;

public interface LaptopsService {
	
	List<Laptops> showalldetails();
	
	Laptops addnewLaptops(Laptops laptops);
	
	Optional<Laptops> searchLaptop(String model);
	
	void deletePage(String mod);
	
	List<Laptops> showAllRecordsOfProcesser(String proceeser);

	List<Laptops> showallrecordsProcesserAndRam(String pro,int ram);
	
	List<Laptops> showAllLap(int count);
	

}
