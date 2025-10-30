package com.rk.Salon.Offering.Service.Services;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.Salon.Offering.Service.Repository.OfferingRepository;
import com.rk.Salon.Offering.Service.dto.CategoryDTO;
import com.rk.Salon.Offering.Service.dto.SalonDTO;
import com.rk.Salon.Offering.Service.dto.ServiceOfferingDTO;
import com.rk.Salon.Offering.Service.modal.ServiceOffering;

@Service
public class ServiceOfferingServiceImpl implements ServiceOfferingService {
	
	@Autowired
	OfferingRepository offeringRepository;

	@Override
	public ServiceOffering createServiceOffering(SalonDTO salonDTO, ServiceOfferingDTO offeringDTO,
			CategoryDTO categoryDTO) {
		
		ServiceOffering serviceOffering = new ServiceOffering();
		serviceOffering.setName(offeringDTO.getName());
		serviceOffering.setDescription(offeringDTO.getDescription());
		serviceOffering.setImage(offeringDTO.getImage());
		serviceOffering.setSalonId(salonDTO.getId());
		serviceOffering.setCategoryId(categoryDTO.getId());
		serviceOffering.setPrice(offeringDTO.getPrice());
		serviceOffering.setDuration(offeringDTO.getDuration());
		return offeringRepository.save(serviceOffering);
	}

	@Override
	public ServiceOffering updateServiceOffering(Long serviceOfferingId, ServiceOffering serviceOffering) throws Exception {
		ServiceOffering existingOffering = offeringRepository.findById(serviceOfferingId).orElse(null);
		if(existingOffering == null ) {
			throw new Exception("Service Offering not found with id: " + serviceOfferingId);
		}
		
		existingOffering.setName(serviceOffering.getName());
		existingOffering.setDescription(serviceOffering.getDescription());
		existingOffering.setImage(serviceOffering.getImage());
		existingOffering.setPrice(serviceOffering.getPrice());
		existingOffering.setDuration(serviceOffering.getDuration());
		
		return offeringRepository.save(existingOffering);
	}

	@Override
	public Set<ServiceOffering> getAllServiceOfferingsBySalonId(Long salonId, Long categoryId) {
		 Set<ServiceOffering> offerings = offeringRepository.findBySalonId(salonId);
		    if (categoryId != null) {
		    	offerings = offerings.stream()
		    		    .filter(serviceoffer -> 
		    		        serviceoffer.getCategoryId() != null 
		    		        && serviceoffer.getCategoryId() == categoryId)
		    		    .collect(Collectors.toSet());
		    }
		    return offerings;
	}

	@Override
	public Set<ServiceOffering> getAllServiceOfferingsByIds(Set<Long> ids) {
		List<ServiceOffering> offerings = offeringRepository.findAllById(ids);
		return new HashSet<>(offerings);
	}

	@Override
	public ServiceOffering getServiceOfferingById(Long offeringId) throws Exception {
		// TODO Auto-generated method stub
		ServiceOffering serviceOffering = offeringRepository.findById(offeringId).orElse(null);
		
		if (serviceOffering == null) {
			throw new Exception("Service Offering not found with id: " + offeringId);
		}
		return serviceOffering;
	}

}
