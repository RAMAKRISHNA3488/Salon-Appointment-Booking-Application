package com.rk.Salon.Offering.Service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.Salon.Offering.Service.Services.ServiceOfferingService;
import com.rk.Salon.Offering.Service.dto.CategoryDTO;
import com.rk.Salon.Offering.Service.dto.SalonDTO;
import com.rk.Salon.Offering.Service.dto.ServiceOfferingDTO;
import com.rk.Salon.Offering.Service.modal.ServiceOffering;

@RestController
@RequestMapping("/api/salon-service-offering/salon-owner")
public class SalonServiceOffering {
	@Autowired
	private ServiceOfferingService serviceOfferingService;
	
	
	@PostMapping
	public ResponseEntity<ServiceOffering> createService(@RequestBody ServiceOfferingDTO serviceOfferingDTO){
		SalonDTO salonDTO = new SalonDTO();
		salonDTO.setId(1L);
		
		CategoryDTO categoryDTO = new CategoryDTO();
		
		categoryDTO.setId(serviceOfferingDTO.getCategoryId());
		
		ServiceOffering serviceOffering = serviceOfferingService.createServiceOffering(salonDTO, serviceOfferingDTO, categoryDTO);
		return ResponseEntity.ok(serviceOffering);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<ServiceOffering> updateServiceOffering(@PathVariable Long id, @RequestBody ServiceOffering serviceOffering) throws Exception{
		ServiceOffering updatedServiceOffering = serviceOfferingService.updateServiceOffering(id, serviceOffering);
		return ResponseEntity.ok(updatedServiceOffering);
	}
	
	

}
