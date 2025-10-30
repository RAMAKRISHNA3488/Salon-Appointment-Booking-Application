package com.rk.Salon.Booking.Service.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.Salon.Booking.Service.Repository.BookingRepository;
import com.rk.Salon.Booking.Service.dto.BookingRequest;
import com.rk.Salon.Booking.Service.dto.SalonDTO;
import com.rk.Salon.Booking.Service.dto.ServiceOfferingDTO;
import com.rk.Salon.Booking.Service.dto.UserDTO;
import com.rk.Salon.Booking.Service.modal.Booking;
import com.rk.Salon.Booking.Service.modal.BookingStatus;
import com.rk.Salon.Booking.Service.modal.SalonReport;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public Booking createBooking(BookingRequest booking, UserDTO user, SalonDTO salon,
			Set<ServiceOfferingDTO> serviceDTOSet) throws Exception {
		int totalDuration = serviceDTOSet.stream().mapToInt(ServiceOfferingDTO::getDuration).sum();

		LocalDateTime bookingStartTime = booking.getStartTime();

		LocalDateTime bookingEndTime = bookingStartTime.plusMinutes(totalDuration);

		Boolean isSlotAvailable = isTimeSlotAvailable(salon, bookingStartTime, bookingEndTime);

		Double totalPrice = serviceDTOSet.stream().mapToDouble(ServiceOfferingDTO::getPrice).sum();

		Set<Long> idList = serviceDTOSet.stream().map(ServiceOfferingDTO::getId).collect(Collectors.toSet());

		Booking newBooking = new Booking();

		newBooking.setCustomerId(user.getId());
		newBooking.setSalonId(salon.getId());
		newBooking.setServiceIds(idList);
		newBooking.setStatus(BookingStatus.PENDING);
		newBooking.setStartTime(bookingStartTime);
		newBooking.setEndTime(bookingEndTime);
		newBooking.setTotalPrices(totalPrice.intValue());

		return bookingRepository.save(newBooking);
	}

	public Boolean isTimeSlotAvailable(SalonDTO salonDTO, LocalDateTime bookingStartTime, LocalDateTime bookingEndTime)
			throws Exception {

		List<Booking> existingBookings = getBookingsBySalon(salonDTO.getId());

		LocalDateTime salonOpenTime = salonDTO.getOpenTime().atDate(bookingStartTime.toLocalDate());
		LocalDateTime salonCloseTime = salonDTO.getCloseTime().atDate(bookingStartTime.toLocalDate());

		if (bookingStartTime.isBefore(salonOpenTime) || bookingEndTime.isAfter(salonCloseTime)) {
			throw new Exception("Booking time is outside salon operating hours.");
		}
		for (Booking existingBooking : existingBookings) {
			LocalDateTime existingStartTime = existingBooking.getStartTime();
			LocalDateTime existingEndTime = existingBooking.getEndTime();

			if (bookingStartTime.isBefore(existingEndTime) && bookingEndTime.isAfter(existingStartTime)) {
				throw new Exception("The selected time slot is not available. Choose a different time.");
			}

			if (bookingStartTime.equals(existingStartTime) || bookingEndTime.equals(existingEndTime)) {
				throw new Exception("The selected time slot is not available. Choose a different time.");
			}
		}
		return true;

	}

	@Override
	public Booking getBookingById(Long id) {
		Booking booking = bookingRepository.findById(id).orElse(null);
		if (booking == null) {
			throw new RuntimeException("Booking not found with id: " + id);
		}

		return booking;
	}

	@Override
	public List<Booking> getBookingsByCustomerId(Long customerId) {
		return bookingRepository.findByCustomerId(customerId);
	}

	@Override
	public List<Booking> getBookingsBySalon(Long salonId) {
		return bookingRepository.findBySalonId(salonId);
	}

	@Override
	public Booking updateBooking(Long bookingId, BookingStatus status) {
		Booking booking = getBookingById(bookingId);
		booking.setStatus(status);
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getBookingsbyDate(LocalDate date, Long salonId) {

		List<Booking> allBookings = getBookingsBySalon(salonId);
		if (date == null) {
			return allBookings;
		}

		return allBookings.stream()
				.filter(booking -> isSameDate(booking.getStartTime(), date) || isSameDate(booking.getEndTime(), date))
				.collect(Collectors.toList());

	}

	private boolean isSameDate(LocalDateTime dateTime, LocalDate date) {
		return dateTime.toLocalDate().isEqual(date);
	}

	@Override
	public SalonReport getSalonReport(Long salonId) {
		// TODO Auto-generated method stub
		List<Booking> bookings = getBookingsBySalon(salonId);
		// Calculate total bookings
		Double totalEarnings = bookings.stream().mapToDouble(Booking::getTotalPrices).sum();

		Integer totalBookings = bookings.size();

		List<Booking> cancelledBookings = bookings.stream()
				.filter(booking -> booking.getStatus().equals(BookingStatus.CANCELLED))
				.collect(Collectors.toList());
		
		double totalRefunds = cancelledBookings.stream().mapToDouble(Booking::getTotalPrices).sum();
		
		SalonReport report = new SalonReport();
		report.setId(salonId);
		report.setCancelledBookings(cancelledBookings.size());
		report.setTotalBookings(totalEarnings.intValue());
		report.setTotalEarnings(totalEarnings);
		report.setTotalrefunds(totalRefunds);
		report.setTotalBookings(totalBookings);
		return report;
	}

}
