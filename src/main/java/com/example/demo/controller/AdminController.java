package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.model.DriverBean;
import com.example.demo.model.RouteBean;
import com.example.demo.model.VehicleBean;
import com.example.demo.repository.DriverRepo;
import com.example.demo.repository.RouteRepo;
import com.example.demo.repository.Vehicle;
import com.example.demo.service.Administrator;

@RestController
public class AdminController {

	@Autowired
	DriverRepo Drepo;
	@Autowired
	Vehicle vRepo;
	@Autowired
	RouteRepo rRepo;
	@Autowired
	Administrator admin;

	// testedok
	@PostMapping("/Driver")
	public DriverBean addDriver(@RequestBody DriverBean ataAdd) {
		admin.addDriver(ataAdd);
		return ataAdd;

	}

	// testedok
	@GetMapping("/Driver")

	public List<DriverBean> getDriver() {

		return Drepo.findAll();
	}

	// testedok
	@RequestMapping("/Driver/{driverId}")

	public Optional<DriverBean> getDriver(@PathVariable("driverId") int driverId) {

		return Drepo.findById(driverId);
	}

	// testedok
	@DeleteMapping("/Driver/{driverId}")
	public String deleteDriver(@PathVariable int driverId) {

		ArrayList<Integer> drivers = new ArrayList<Integer>();
		drivers.add(driverId);
		int numOfDriverDdeleted = admin.deleteDriver(drivers);
		return numOfDriverDdeleted + " Deleted";
	}

	// testedok
	@PutMapping("/Driver/{driverId}")
	public String modifyDriver(@RequestBody DriverBean driver, @PathVariable int driverId) {
		Optional<DriverBean> driverOptional = Drepo.findById(driverId);

		if (!driverOptional.isPresent()) {
			// ResponseEntity<Object> a = ResponseEntity.notFound().build();
			return "driver does not exist";
		}
		driver.setDriverId(driverId);

		Drepo.save(driver);
		// ResponseEntity<Object> b = ResponseEntity.noContent().build();
		return "driver updated";

	}

	// testedok
	@PostMapping("/Vehicle")
	public VehicleBean addVehicle(@RequestBody VehicleBean vehicle) {
//		D = new 
		admin.addVehicle(vehicle);
//		Drepo.save(ataadd);
		return vehicle;

	}

	// testedok
	@GetMapping("/Vehicle")

	public List<VehicleBean> getVehicle() {

		return admin.listAllVehicle();
	}

	// testedok
	@RequestMapping("/Vehicle/{vehicleId}")

	public VehicleBean getVehicle(@PathVariable("vehicleId") int vehicleId) {

		return admin.viewVehicle(vehicleId);
	}

	// testedok
	@DeleteMapping("/Vehicle/{vehicleId}")
	public String deleteVehicle(@PathVariable int vehicleId) {

		ArrayList<Integer> vehicle = new ArrayList<Integer>();
		vehicle.add(vehicleId);
		int numOfVehicleDdeleted = admin.deleteVehicle(vehicle);
		return numOfVehicleDdeleted + "Deleted";
	}

	// testedok
	@PutMapping("/Vehicle/{vehicleId}")
	public ResponseEntity<Object> modifyVehicle(@RequestBody VehicleBean vehicle, @PathVariable int vehicleId) {
		Optional<VehicleBean> vehicleOptional = vRepo.findById(vehicleId);

		if (!vehicleOptional.isPresent())
			return ResponseEntity.notFound().build();

		vehicle.setVehicleId(vehicleId);

		vRepo.save(vehicle);

		return ResponseEntity.noContent().build();
	}

	// testedok
	@PostMapping("/Route")
	public RouteBean addRoute(@RequestBody RouteBean route) {
//		D = new 
		admin.addRoute(route);
//		Drepo.save(ataadd);
		return route;

	}

	// testedok
	@DeleteMapping("/Route/{routeId}")
	public String deleteRoute(@PathVariable int routeId) {

		ArrayList<Integer> route = new ArrayList<Integer>();
		route.add(routeId);
		int numOfRouteDeleted = admin.deleteRoute(route);
		return numOfRouteDeleted + "Deleted";
	}

	// testedok
	@GetMapping("/Route")

	public List<RouteBean> getRoute() {

		return admin.listAllRoute();
	}

//testedok
	@RequestMapping("/Route/id/{routeId}")
	public RouteBean getRoute(@PathVariable("routeId") int routeId) {
		System.out.println("skdjhvsdkjhdsfhds");
		return admin.viewRoute(routeId);
	}

//testedok
	@GetMapping("/Route/{source}/{destination}")
	public Optional<RouteBean> getRouteBy(@PathVariable("source") String source,
			@PathVariable("destination") String destination) {

		return rRepo.findBySourceAndDestination(source, destination);

	}

//testedok
	@GetMapping("/Route/source/{source}")
	public Optional<RouteBean> getRouteBy(@PathVariable("source") String source) {

		return rRepo.findBySource(source);

	}

//testedok
	@PostMapping("/allot/{reservationId}/{driverid}")
	public boolean allotDriver(@PathVariable("reservationId") int reservationId,
			@PathVariable("driverid") int driverId) {

		boolean b = admin.allotDriver(reservationId, driverId);
		System.out.println(b);
		return b;

	}

}
