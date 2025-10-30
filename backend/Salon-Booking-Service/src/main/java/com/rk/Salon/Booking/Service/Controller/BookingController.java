package com.rk.Salon.Booking.Service.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rk.Salon.Booking.Service.Mapper.BookingMapper;
import com.rk.Salon.Booking.Service.Services.BookingService;
import com.rk.Salon.Booking.Service.dto.BookingDTO;
import com.rk.Salon.Booking.Service.dto.BookingRequest;
import com.rk.Salon.Booking.Service.dto.BookingSlotDTO;
import com.rk.Salon.Booking.Service.dto.SalonDTO;
import com.rk.Salon.Booking.Service.dto.ServiceOfferingDTO;
import com.rk.Salon.Booking.Service.dto.UserDTO;
import com.rk.Salon.Booking.Service.modal.Booking;
import com.rk.Salon.Booking.Service.modal.BookingStatus;
import com.rk.Salon.Booking.Service.modal.SalonReport;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping
	public ResponseEntity<Booking> createBooking(@RequestParam Long salonId, @RequestBody BookingRequest bookingRequest)
			throws Exception {
		UserDTO user = new UserDTO();
		user.setId(1L); // Dummy user for illustration
		SalonDTO salon = new SalonDTO();
		salon.setId(salonId);
		salon.setOpenTime(LocalTime.now());
		salon.setCloseTime(LocalTime.now().plusHours(12));
		Set<ServiceOfferingDTO> serviceDTOSet = new HashSet<ServiceOfferingDTO>();
		ServiceOfferingDTO serviceOfferingDTO = new ServiceOfferingDTO();
		serviceOfferingDTO.setId(1L);
		serviceOfferingDTO.setPrice(399.0);
		serviceOfferingDTO.setDuration(60);
		serviceOfferingDTO.setName("Hair Cut for Men");
		serviceDTOSet.add(serviceOfferingDTO);

		Booking booking = bookingService.createBooking(bookingRequest, user, salon, serviceDTOSet);

		return ResponseEntity.ok(booking);

	}

	@GetMapping("/customer")
	public ResponseEntity<Set<BookingDTO>> getBookingsByCustomer() {
		List<Booking> bookings = bookingService.getBookingsByCustomerId(1L);
		return ResponseEntity.ok(getBookingDTOs(bookings));
	}

	@GetMapping("/salon")
	public ResponseEntity<Set<BookingDTO>> getBookingsBySalon() {
		List<Booking> bookings = bookingService.getBookingsBySalon(1L);
		return ResponseEntity.ok(getBookingDTOs(bookings));
	}

	private Set<BookingDTO> getBookingDTOs(List<Booking> bookings) {
		return bookings.stream().map(booking -> {
			return BookingMapper.toDTO(booking);
		}).collect(Collectors.toSet());
	}

	@GetMapping("/bookingId")
	public ResponseEntity<BookingDTO> getBookingsById(@PathVariable Long bookingId) {
		Booking bookings = bookingService.getBookingById(bookingId);
		return ResponseEntity.ok(BookingMapper.toDTO(bookings));
	}

	@PutMapping("/{bookingId}/status")
	public ResponseEntity<BookingDTO> updateBookingStatus(@PathVariable Long bookingId,
			@RequestParam BookingStatus status) {

		Booking booking = bookingService.updateBooking(bookingId, status);

		return ResponseEntity.ok(BookingMapper.toDTO(booking));
	}

	@GetMapping("/slots/salon/{salonId}/date/{date}")
	public ResponseEntity<List<BookingSlotDTO>> getBookedSlot(@PathVariable Long salonId,
			@RequestParam(required = false) LocalDate date) {
		List<Booking> bookings = bookingService.getBookingsbyDate(date, salonId);

		List<BookingSlotDTO> slotDTOs = bookings.stream().map(booking -> {
			BookingSlotDTO slotDTO = new BookingSlotDTO();
			slotDTO.setStartTime(booking.getStartTime());
			slotDTO.setEndTime(booking.getEndTime());
			return slotDTO;
		}).collect(Collectors.toList());

		return ResponseEntity.ok(slotDTOs);
	}

	@GetMapping("/report")
	public ResponseEntity<SalonReport> getSalonReport() {
		SalonReport report = bookingService.getSalonReport(1L);
		return ResponseEntity.ok(report);
	}
}
