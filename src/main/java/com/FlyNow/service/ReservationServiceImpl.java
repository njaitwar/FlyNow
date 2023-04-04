package com.FlyNow.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FlyNow.dto.ReservationRequest;
import com.FlyNow.entities.Flight;
import com.FlyNow.entities.Passenger;
import com.FlyNow.entities.Reservation;
import com.FlyNow.repository.FlightRepository;
import com.FlyNow.repository.PassengerRepository;
import com.FlyNow.repository.ReservationRepository;
import com.FlyNow.util.PDFgenerator;


@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setMiddleName(request.getMiddleName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		passengerRepo.save(passenger);
		
		long flightId = request.getFlightId();
		Optional<Flight> findById = flightRepo.findById(flightId);
		@SuppressWarnings("unused")
		Flight flight = findById.get();
		
		Reservation reservation = new Reservation();
		reservation.setPassenger(passenger);
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		
		Reservation save = reservationRepo.save(reservation);
		
		PDFgenerator pdf = new PDFgenerator();
		String filePath = "C:\\Users\\admin\\itinery\\reservations"+save.getId()+".pdf";
		pdf.generateItinerary(reservation ,filePath);
		
		
		
//		pdf.generatePDF(filePath+reservation.getId()+".pdf", request.getFirstName(), request.getEmail(),
//				request.getPhone(), flight.getOperatingAirlines(), 
//				flight.getDateOfDeparature(), flight.getDeparatureCity(), flight.getArrivalCity());
		
		return save;
	}

}
