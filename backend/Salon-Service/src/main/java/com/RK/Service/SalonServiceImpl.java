package com.RK.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RK.DTO.SalonDTO;
import com.RK.DTO.UserDTO;
import com.RK.Modal.Salon;
import com.RK.Repository.SalonRepository;

@Service
public class SalonServiceImpl implements SalonService {

	@Autowired
	private SalonRepository salonRepository;

	@Override
	public Salon createSalon(SalonDTO salon, UserDTO user) {
		Salon newSalon = new Salon();
		newSalon.setName(salon.getName());
		newSalon.setAddress(salon.getAddress());
		newSalon.setCity(salon.getCity());
		newSalon.setEmail(salon.getEmail());
		newSalon.setImages(salon.getImages());
		newSalon.setOwnerId(user.getId());
		newSalon.setOpenTime(salon.getOpenTime());
		newSalon.setCloseTime(salon.getCloseTime());
		newSalon.setPhoneNumber(salon.getPhoneNumber());
		return salonRepository.save(newSalon);
	}

	@Override
	public Salon updateSalon(SalonDTO salon, Long salonId, UserDTO user) throws Exception {

		Salon existingSalon = salonRepository.findById(salonId).orElse(null);
		if (existingSalon != null && salon.getOwnerId().equals(user.getId())) {
			existingSalon.setName(salon.getName());
			existingSalon.setAddress(salon.getAddress());
			existingSalon.setCity(salon.getCity());
			existingSalon.setEmail(salon.getEmail());
			existingSalon.setImages(salon.getImages());
			existingSalon.setOpenTime(salon.getOpenTime());
			existingSalon.setCloseTime(salon.getCloseTime());
			existingSalon.setPhoneNumber(salon.getPhoneNumber());
			existingSalon.setOwnerId(user.getId());
			return salonRepository.save(existingSalon);
		}
		throw new Exception("Salon not found");
	}

	@Override
	public List<Salon> getAllSalons() {
		return salonRepository.findAll();
	}

	@Override
	public Salon getSalonById(Long salonId) throws Exception {
		Salon salon = salonRepository.findById(salonId).orElse(null);

		if (salon == null) {
			throw new Exception("Salon not exist");
		}
		return salon;
	}

	@Override
	public Salon getSalonByOwnerId(Long ownerId) {
		return salonRepository.findByOwnerId(ownerId);
	}

	@Override
	public List<Salon> searchSalonsByCity(String city) {
		return salonRepository.searchSalons(city);
	}

}
