package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ReservationBean;

public interface ReservationRepo extends JpaRepository<ReservationBean, Integer>{

}
