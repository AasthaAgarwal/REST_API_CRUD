package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookingStatus;
import com.example.demo.model.CredentialsBean;
import com.example.demo.model.DriverBean;
import com.example.demo.model.ReservationBean;
import com.example.demo.model.RouteBean;
import com.example.demo.model.VehicleBean;
import com.example.demo.repository.DriverRepo;
import com.example.demo.repository.ReservationRepo;
import com.example.demo.repository.RouteRepo;
import com.example.demo.repository.Vehicle;

@Service
public class AdministratorImpl implements Administrator{
	@Autowired
	DriverRepo dRepo;
	@Autowired
	Vehicle vRepo;
	@Autowired
	RouteRepo rRepo;
	@Autowired
	ReservationRepo rrRepo;
	
	@Override
	public String addDriver(DriverBean driverBean) {
		// TODO Auto-generated method stub
		dRepo.save(driverBean);
		return "Driver Added";
	}
	//@Override
	//public String deleteDriver(Integer driverID) {
		// TODO Auto-generated method stub
	//	DriverBean db = dRepo.getOne(driverID);
	//	dRepo.delete(db);
	//	return "deleted";
//	}
	
	@Override
	public int deleteDriver(ArrayList<Integer> driverID) {

		
		int countOfDeletedDrivers = 0;
		for(int driver:driverID)
		{
			DriverBean db = dRepo.getOne(driver);
			dRepo.delete(db);
			countOfDeletedDrivers++;
		}
		
		return countOfDeletedDrivers;
	}

	@Override
	public String addVehicle(VehicleBean vehicleBean) {
		
		vRepo.save(vehicleBean);
		return "vehicle Added";
		}
	
		@Override
        public int deleteVehicle(ArrayList<Integer> vehicleID) {
		
		int countOfDeletedVehicle = 0;
		for(int vehicle:vehicleID)
		{
			VehicleBean vb = vRepo.getOne(vehicle);
			vRepo.delete(vb);
			countOfDeletedVehicle++;
		}
		
		return countOfDeletedVehicle;	
	}

		@Override
		public VehicleBean viewVehicle(Integer vehicleID) {
			// TODO Auto-generated method stub
			
			return vRepo.findById(vehicleID).get();
		}
		
		@Override
		public List<VehicleBean> listAllVehicle() {
	        return vRepo.findAll();
	    }
	
		@Override
		public String addRoute(RouteBean routeBean) {
			
			rRepo.save(routeBean);
			return "route Added";
		}

		@Override
		public int deleteRoute(ArrayList<Integer> routeID) {
			int countOfDeletedRoute = 0;
			for(int route:routeID)
			{
				RouteBean rb = rRepo.getOne(route);
				rRepo.delete(rb);
				countOfDeletedRoute++;
			}
			
			return countOfDeletedRoute;
		}
		
		@Override
		public RouteBean viewRoute(Integer routeID) {
			// TODO Auto-generated method stub
			System.out.print("ABCD");
			return rRepo.findById(routeID).get();
		}
	
		@Override
		public List<RouteBean> listAllRoute() {
	        return rRepo.findAll();
	    }

		@Override
		public boolean allotDriver(int reservationID, int driverID) {
			
			Optional<ReservationBean> rb = rrRepo.findById(reservationID);
			ReservationBean rbean;
			
			if(rb.isPresent())
			{
				rbean = rb.get();
			}
			else {
				return false;
			}
			
			Optional<DriverBean> db = dRepo.findById(driverID);
			DriverBean dbean;
			
			if(db.isPresent())
			{
				dbean = db.get();
			}
			else {
				return false;
			}
			
			rbean.setBookingStatus(BookingStatus.CONFIRMED);
			rbean.setDriverBean(dbean);
			rrRepo.save(rbean);
			
			return true;
		}
	
	
}
