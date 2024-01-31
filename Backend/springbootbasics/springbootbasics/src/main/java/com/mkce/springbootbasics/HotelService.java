package com.mkce.springbootbasics;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	public void additem(Hotel s) {
		 hotelRepository.save(s);
	}
	public void del(long id)
	{
		hotelRepository.deleteById(id);
	}
	public Optional g(long id)
	{
	    return hotelRepository.findById(id);
	}
	public void upi(long id,Hotel a)
	{
       Optional<Hotel> m=hotelRepository.findById(id);
       if(m.isPresent())
       {
    	   Hotel o=m.get();
    	   o.setDate(a.getDate());
    	   o.setItem_id(a.getItem_id());
    	   o.setName(a.getName());
    	   o.setPrice(a.getPrice());
    	   hotelRepository.save(o);
       }
	}
}  
