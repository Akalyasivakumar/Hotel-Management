package com.mkce.springbootbasics;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	//@RequestMapping(method = RequestMethod.POST, value = "/addStudent")
	@PostMapping("/additem")
	public String add(@RequestBody Hotel s) {
		hotelService.additem(s);
		return "Item Added Successfully";
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id)
	{
		hotelService.del(id);
		return "deleted";
	}
	@GetMapping("/get/{id}")
	public Optional get(@PathVariable long id)
	{
		return hotelService.g(id);
	}
	@PutMapping("/updateitem/{id}")
	public void updateitem(@PathVariable long id,@RequestBody Hotel a)
	{
	    hotelService.upi(id,a);
	}
}
