package com.FlyNow.service;

import com.FlyNow.dto.ReservationRequest;
import com.FlyNow.entities.Reservation;

public interface ReservationService {
	
	Reservation bookFlight(ReservationRequest request);

}
