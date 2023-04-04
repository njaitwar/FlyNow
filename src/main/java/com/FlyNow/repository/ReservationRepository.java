package com.FlyNow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlyNow.entities.Reservation;
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}
