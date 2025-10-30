package com.rk.Salon.Offering.Service.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rk.Salon.Offering.Service.Services.ServiceOfferingService;
import com.rk.Salon.Offering.Service.modal.ServiceOffering;

@RestController
@RequestMapping("/api/service-offering")
public class ServiceOfferingController {
	
	@Autowired
	private ServiceOfferingService serviceOfferingService;
	
	@GetMapping("/salon/{salonid}")
	public ResponseEntity<Set<ServiceOffering>> getServiceOfferingsBySalonId(@PathVariable Long salonId,
			@RequestParam(required = false) Long categoryId){
		Set<ServiceOffering> serviceOfferings = serviceOfferingService
				.getAllServiceOfferingsBySalonId(salonId, categoryId);
		return ResponseEntity.ok(serviceOfferings);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ServiceOffering> getServiceOfferingById(@PathVariable Long id) throws Exception {
		ServiceOffering serviceOffering = serviceOfferingService.getServiceOfferingById(id);
		return ResponseEntity.ok(serviceOffering);
	}
	
	@GetMapping("/list/{ids}")
	public ResponseEntity<Set<ServiceOffering>> getServiceOfferingByIds(@PathVariable Set<Long> ids){
		Set<ServiceOffering> serviceOfferings = serviceOfferingService.getAllServiceOfferingsByIds(ids);
		return ResponseEntity.ok(serviceOfferings);
	}
	
	

}
