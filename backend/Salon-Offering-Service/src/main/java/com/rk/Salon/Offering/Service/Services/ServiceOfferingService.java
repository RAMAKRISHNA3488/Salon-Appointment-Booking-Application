package com.rk.Salon.Offering.Service.Services;

import java.util.List;
import java.util.Set;

import com.rk.Salon.Offering.Service.dto.CategoryDTO;
import com.rk.Salon.Offering.Service.dto.SalonDTO;
import com.rk.Salon.Offering.Service.dto.ServiceOfferingDTO;
import com.rk.Salon.Offering.Service.modal.ServiceOffering;

public interface ServiceOfferingService {
	
	ServiceOffering createServiceOffering(SalonDTO salonDTO,
			ServiceOfferingDTO offeringDTO,CategoryDTO categoryDTO );
	
	
	
	ServiceOffering updateServiceOffering(Long serviceOfferingId, ServiceOffering serviceOffering) throws Exception;
	
	
	Set<ServiceOffering> getAllServiceOfferingsBySalonId(Long salonId, Long categoryId);
	
	Set<ServiceOffering> getAllServiceOfferingsByIds(Set<Long> offeringIds);
	
	ServiceOffering getServiceOfferingById(Long offeringId) throws Exception;

}
