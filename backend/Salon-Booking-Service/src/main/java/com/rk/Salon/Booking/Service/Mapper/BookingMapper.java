package com.rk.Salon.Booking.Service.Mapper;

import com.rk.Salon.Booking.Service.dto.BookingDTO;
import com.rk.Salon.Booking.Service.modal.Booking;

public class BookingMapper {

	public static BookingDTO toDTO(Booking booking) {
		BookingDTO bookingDTO = new BookingDTO();

		bookingDTO.setId(booking.getId());
		bookingDTO.setCustomerId(booking.getCustomerId());
		bookingDTO.setStatus(booking.getStatus());
		bookingDTO.setSalonId(booking.getSalonId());
		bookingDTO.setStartTime(booking.getStartTime());
		bookingDTO.setEndTime(booking.getEndTime());
		bookingDTO.setServiceIds(booking.getServiceIds());

		return bookingDTO;

	}

}
