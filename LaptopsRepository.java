package com.example.LoptopShowRoom.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.LoptopShowRoom.Model.Laptops;

public interface LaptopsRepository extends JpaRepository<Laptops,String> 
{
	
	List<Laptops> findByProcesser(String processer);
	
	List<Laptops> findByProcesserAndRam(String Processer,Integer ram);
	
	@Query(value="select * from Laptops where ram>=?1 " ,nativeQuery = true)
	List<Laptops> findlap(Integer count);
	

}
