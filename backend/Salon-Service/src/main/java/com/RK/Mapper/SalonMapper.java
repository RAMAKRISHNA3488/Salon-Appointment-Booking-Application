package com.RK.Mapper;

import com.RK.DTO.SalonDTO;
import com.RK.Modal.Salon;

public class SalonMapper {
	
	public static SalonDTO mapToDTO(Salon salon) {
		SalonDTO salonDTO = new SalonDTO();
		salonDTO.setId(salon.getId());
		salonDTO.setName(salon.getName());
		salonDTO.setAddress(salon.getAddress());
		salonDTO.setCity(salon.getCity());
		salonDTO.setEmail(salon.getEmail());
		salonDTO.setImages(salon.getImages());
		salonDTO.setOwnerId(salon.getOwnerId());
		salonDTO.setOpenTime(salon.getOpenTime());
		salonDTO.setCloseTime(salon.getCloseTime());
		salonDTO.setPhoneNumber(salon.getPhoneNumber());
		return salonDTO;
	}

}
