package com.example.demo.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookingRequest;
import com.example.demo.model.BookingStatus;
import com.example.demo.model.CredentialsBean;
import com.example.demo.model.ProfileBean;
import com.example.demo.model.ReservationBean;
import com.example.demo.model.RouteBean;
import com.example.demo.model.VehicleBean;
import com.example.demo.repository.CredentialsRepo;
import com.example.demo.repository.ProfileRepo;
import com.example.demo.repository.ReservationRepo;
import com.example.demo.repository.RouteRepo;
import com.example.demo.repository.Vehicle;

@Service
public class CustomerImpl implements Customer{
@Autowired
ReservationRepo rrRepo;
@Autowired
CredentialsRepo cRepo;
@Autowired
Vehicle vRepo;
@Autowired
RouteRepo rRepo;
@Autowired
ProfileRepo pRepo;

	
	public String bookVehicle(BookingRequest bookingRequest) {
		int vechileIdPassedByUser = bookingRequest.getVehicleId();
		
		Optional<VehicleBean> vb = vRepo.findById(vechileIdPassedByUser);
		VehicleBean  vBean;
		if(vb.isPresent())
		{
			vBean = vb.get();
		}
		else {
			return "No such Vehicle";
		}
		
		Optional<CredentialsBean> ub = cRepo.findById( bookingRequest.getUserId());
		CredentialsBean cbean;
		
		if(ub.isPresent())
		{
			cbean = ub.get();
		}
		else {
			return "No such User";
		}
		
		Optional<RouteBean> rb = rRepo.findBySourceAndDestination(bookingRequest.getBoardingPoint(), bookingRequest.getDropPoint());
		RouteBean rbean;
		
		if(rb.isPresent())
		{
			rbean = rb.get();
		}
		else {
			return "service is not available in selected route";
		}
		
		ReservationBean reserve = new ReservationBean();
		reserve.setJourneyDate(bookingRequest.getJourneyDate());
		reserve.setBoardingPoint(bookingRequest.getBoardingPoint());
		reserve.setDropPoint(bookingRequest.getDropPoint());
		reserve.setBookingDate(LocalDate.now());
		reserve.setBookingStatus(BookingStatus.PENDING);
		reserve.setRouteBean(rbean);
		reserve.setCredentialsBean(cbean);
		reserve.setVehicleBean(vBean);
		
		int totalfare=0;
		totalfare= vBean.getFarePerKm() * rbean.getDistance();
		
		reserve.setTotalFare(totalfare);
		
		rrRepo.save(reserve);
		return "added";}
	
	

	@Override
	public String registerUser(CredentialsBean crendentialBean) {
		// TODO Auto-generated method stub
		cRepo.save(crendentialBean);
		return "added";
	}



	@Override
	public ReservationBean viewBookingDetails(int reservationID) {
		
		return rrRepo.findById(reservationID).get();
		
	}
	
	public String addProfile(ProfileBean profileBean) {
		pRepo.save(profileBean);
		return "profile created";
	}
	
}
