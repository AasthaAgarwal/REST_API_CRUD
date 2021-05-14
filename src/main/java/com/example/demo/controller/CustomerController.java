package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookingRequest;
import com.example.demo.model.CredentialsBean;
import com.example.demo.model.ProfileBean;
import com.example.demo.model.ReservationBean;
import com.example.demo.model.VehicleBean;
import com.example.demo.service.CustomerImpl;

@RestController
public class CustomerController {

	@Autowired
	CustomerImpl cust;
	
	//testedok
	@PostMapping("/booking")
	public String bookVehicle(@RequestBody BookingRequest bookingRequest) {
	
		String val = cust.bookVehicle(bookingRequest);
		System.out.println(val);
	return val;
		
	}
	
	//testedok
	@PostMapping("/register")
	public CredentialsBean registerUser(@RequestBody CredentialsBean credential) {
		
	cust.registerUser(credential);
	
	return credential;
	
}
	
	//testedok
@RequestMapping("/booking/{reservationId}")
	
	public ReservationBean viewBookingDetails(@PathVariable("reservationId") int reservationId){
		
		return cust.viewBookingDetails(reservationId);
	}

@PostMapping("/profileCreation")
public ProfileBean addProfile(@RequestBody ProfileBean profileBean) {
	cust.addProfile(profileBean);
	return profileBean;
}



}
