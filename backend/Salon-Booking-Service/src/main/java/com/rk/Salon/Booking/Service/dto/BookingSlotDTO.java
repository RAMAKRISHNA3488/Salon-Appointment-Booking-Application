package com.rk.Salon.Booking.Service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingSlotDTO {

	private LocalDateTime startTime;

	private LocalDateTime endTime;

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

}
