package com.RK.Service;

import java.util.List;

import com.RK.DTO.SalonDTO;
import com.RK.DTO.UserDTO;
import com.RK.Modal.Salon;

public interface SalonService {

	Salon createSalon(SalonDTO salon, UserDTO user);
	
	Salon updateSalon(SalonDTO salon, Long salonId, UserDTO user) throws Exception;
	
	List<Salon> getAllSalons();
	
	Salon getSalonById(Long salonId) throws Exception;

	Salon getSalonByOwnerId(Long ownerId);
	
	List<Salon> searchSalonsByCity(String city);
	
	
}
