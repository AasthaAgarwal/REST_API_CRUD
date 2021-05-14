package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
/**
 * 
 * @author Aastha Agarwal
 * This class is for Vehicle.
 */
@Entity
@Table(name="Vehicle")
@TableGenerator(name="tab", initialValue=1000, allocationSize=0)
public class VehicleBean {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	@Column(name = "vehicle_id")
	int vehicleId;
	String name;
	VehicleType type;	
	String registrationNumber;
	int seatingCapacity;
	int farePerKm;
	
	@OneToOne(mappedBy = "vehicleBean")
	private ReservationBean reservationBean;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public int getFarePerKm() {
		return farePerKm;
	}
	public void setFarePerKm(int farePerKm) {
		this.farePerKm = farePerKm;
	}
	

}
