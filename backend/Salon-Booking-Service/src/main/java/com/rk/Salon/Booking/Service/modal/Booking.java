package com.rk.Salon.Booking.Service.modal;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long salonId;
	
	private Long customerId;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	@ElementCollection
	private Set<Long> serviceIds;
	
	private BookingStatus status = BookingStatus.PENDING;
	
	private int totalPrices;
	
	public Booking() {
	}
	

	public Booking(Long id, Long salonId, Long customerId, LocalDateTime startTime, LocalDateTime endTime,
			Set<Long> serviceIds, BookingStatus status, int totalPrices) {
		super();
		this.id = id;
		this.salonId = salonId;
		this.customerId = customerId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.serviceIds = serviceIds;
		this.status = status;
		this.totalPrices = totalPrices;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSalonId() {
		return salonId;
	}

	public void setSalonId(Long salonId) {
		this.salonId = salonId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Set<Long> getServiceIds() {
		return serviceIds;
	}

	public void setServiceIds(Set<Long> serviceIds) {
		this.serviceIds = serviceIds;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	public int getTotalPrices() {
		return totalPrices;
	}

	public void setTotalPrices(int totalPrices) {
		this.totalPrices = totalPrices;
	}
	
}
