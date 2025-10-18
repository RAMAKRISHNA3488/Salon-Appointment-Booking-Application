package com.RK.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RK.DTO.SalonDTO;
import com.RK.DTO.UserDTO;
import com.RK.Mapper.SalonMapper;
import com.RK.Modal.Salon;
import com.RK.Service.SalonService;

@RestController
@RequestMapping("/api/salons")
public class SalonController {

	@Autowired
	private SalonService salonService;
	
	@PostMapping
	public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO) {
		UserDTO user = new UserDTO();
		user.setId(1L); // Dummy user, replace with actual user retrieval logic
		Salon createdSalon = salonService.createSalon(salonDTO,user);
		SalonDTO salonDTO1 = SalonMapper.mapToDTO(createdSalon);
		return ResponseEntity.ok(salonDTO1);
	}
	
	@PatchMapping("/{salonId}")
	public ResponseEntity<SalonDTO> updateSalon(@PathVariable Long salonId, @RequestBody SalonDTO salonDTO) throws Exception {
		UserDTO user = new UserDTO();
		user.setId(1L); // Dummy user, replace with actual user retrieval logic
		
		Salon salon = salonService.updateSalon(salonDTO, salonId, user);
		SalonDTO salonDTO1 = SalonMapper.mapToDTO(salon);
		return ResponseEntity.ok(salonDTO1);
	}
	
	@GetMapping
	public ResponseEntity<List<SalonDTO>> getSalon(){
		List<Salon> salons = salonService.getAllSalons();
		
		List<SalonDTO> salonDTOS = salons.stream().map((salon) -> {
			SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
			return salonDTO;
		}).toList();
		return ResponseEntity.ok(salonDTOS);
	}
	
	@GetMapping("/{salonId}")
	public ResponseEntity<SalonDTO> getSalonById(@PathVariable Long salonId) throws Exception {
		Salon salon = salonService.getSalonById(salonId);
		SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
		return ResponseEntity.ok(salonDTO);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<SalonDTO>> searchSalons(@RequestParam String city){
		List<Salon> salons = salonService.searchSalonsByCity(city);
		
		List<SalonDTO> salonDTOS = salons.stream().map((salon) -> {
			SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
			return salonDTO;
		}).toList();
		return ResponseEntity.ok(salonDTOS);
	}
	
	
	@GetMapping("/owner")
	public ResponseEntity<SalonDTO> getSalonByOwnerId(@PathVariable Long ownerId) throws Exception {
		UserDTO dto = new UserDTO();
		dto.setId(1L);
		Salon salon = salonService.getSalonByOwnerId(dto.getId());
		SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
		return ResponseEntity.ok(salonDTO);
	}
	
}
