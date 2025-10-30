package com.rk.Salon.Booking.Service.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.rk.Salon.Booking.Service.dto.BookingRequest;
import com.rk.Salon.Booking.Service.dto.SalonDTO;
import com.rk.Salon.Booking.Service.dto.ServiceOfferingDTO;
import com.rk.Salon.Booking.Service.dto.UserDTO;
import com.rk.Salon.Booking.Service.modal.Booking;
import com.rk.Salon.Booking.Service.modal.BookingStatus;
import com.rk.Salon.Booking.Service.modal.SalonReport;

public interface BookingService {
	
	Booking createBooking(BookingRequest booking, UserDTO userDTO,
			SalonDTO salonDTO, Set<ServiceOfferingDTO> serviceOfferingDTOs) throws Exception;
	
	Booking getBookingById(Long id);
	
	List<Booking> getBookingsByCustomerId(Long customerId);
	
	List<Booking> getBookingsBySalon(Long salonId);
	
	Booking updateBooking(Long bookingId, BookingStatus status);
	
	List<Booking> getBookingsbyDate(LocalDate date, Long salonId);
	
	SalonReport getSalonReport(Long salonId);

}
