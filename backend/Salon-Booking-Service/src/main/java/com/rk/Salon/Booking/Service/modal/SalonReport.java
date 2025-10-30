package com.rk.Salon.Booking.Service.modal;

public class SalonReport {
	
	private Long id;
	
	private String salonName;
	
	private Double totalEarnings;
	
	private Integer totalBookings;
	
	private Integer cancelledBookings;
	
	private Double totalrefunds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSalonName() {
		return salonName;
	}

	public void setSalonName(String salonName) {
		this.salonName = salonName;
	}

	public Double getTotalEarnings() {
		return totalEarnings;
	}

	public void setTotalEarnings(Double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public Integer getTotalBookings() {
		return totalBookings;
	}

	public void setTotalBookings(Integer totalBookings) {
		this.totalBookings = totalBookings;
	}

	public Integer getCancelledBookings() {
		return cancelledBookings;
	}

	public void setCancelledBookings(Integer cancelledBookings) {
		this.cancelledBookings = cancelledBookings;
	}

	public Double getTotalrefunds() {
		return totalrefunds;
	}

	public void setTotalrefunds(Double totalrefunds) {
		this.totalrefunds = totalrefunds;
	}


}
