package com.rk.Salon.Offering.Service.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.Salon.Offering.Service.modal.ServiceOffering;

public interface OfferingRepository extends JpaRepository<ServiceOffering, Long> {

	Set<ServiceOffering> findBySalonId(Long salonId);
}
