package com.example.demo.service;

import com.example.demo.model.BookingRequest;
import com.example.demo.model.CredentialsBean;
import com.example.demo.model.ProfileBean;
import com.example.demo.model.ReservationBean;

public interface Customer {

	String bookVehicle(BookingRequest bookingRequest); 
	
	String registerUser(CredentialsBean crendentialBean);
	
	ReservationBean viewBookingDetails(int reservationID);
	
	String addProfile(ProfileBean profileBean);
}
