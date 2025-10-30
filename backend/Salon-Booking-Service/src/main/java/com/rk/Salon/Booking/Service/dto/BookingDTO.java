package com.rk.Salon.Booking.Service.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.rk.Salon.Booking.Service.modal.BookingStatus;

public class BookingDTO {
	
	private Long id;
	
	private Long salonId;
	
	private Long customerId;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private Set<Long> serviceIds;
	
	private BookingStatus status = BookingStatus.PENDING;

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
	
    
	

}
