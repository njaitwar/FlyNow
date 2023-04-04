package com.FlyNow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FlyNow.entities.Passenger;
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
