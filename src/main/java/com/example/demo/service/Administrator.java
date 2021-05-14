package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.DriverBean;
import com.example.demo.model.RouteBean;
import com.example.demo.model.VehicleBean;

public interface Administrator {
	String addDriver(DriverBean driverBean);
	
	int deleteDriver(ArrayList<Integer> driverID) ;
  
	String addVehicle(VehicleBean vehicleBean);

	int deleteVehicle(ArrayList<Integer> vehicleID);
	
	VehicleBean viewVehicle(Integer vehicleID);
	//String deleteDriver(Integer driverID);
	
	List<VehicleBean> listAllVehicle();
	
	String addRoute(RouteBean routeBean);
	
	int deleteRoute(ArrayList<Integer> routeID) ;
	
	RouteBean viewRoute(Integer routeID) ;

	List<RouteBean> listAllRoute();
	
	boolean allotDriver(int reservationID, int driverID);
}
