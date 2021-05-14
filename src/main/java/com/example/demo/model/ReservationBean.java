package com.example.demo.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="reservation")
@TableGenerator(name="tab", initialValue=1000, allocationSize=0)
public class ReservationBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	int reservationId;
//	int userId;
//	int vehicleId;
//	int routeId;
//	"yyyy-mm-dd"
	LocalDate bookingDate;
	LocalDate journeyDate;
//	int driverId;
BookingStatus bookingStatus;
	int totalFare;
	String boardingPoint;
	String dropPoint;
	
	public CredentialsBean getCredentialsBean() {
		return credentialsBean;
	}
	public void setCredentialsBean(CredentialsBean credentialsBean) {
		this.credentialsBean = credentialsBean;
	}
	public DriverBean getDriverBean() {
		return driverBean;
	}
	public void setDriverBean(DriverBean driverBean) {
		this.driverBean = driverBean;
	}
	public VehicleBean getVehicleBean() {
		return vehicleBean;
	}
	public void setVehicleBean(VehicleBean vehicleBean) {
		this.vehicleBean = vehicleBean;
	}
	public RouteBean getRouteBean() {
		return routeBean;
	}
	public void setRouteBean(RouteBean routeBean) {
		this.routeBean = routeBean;
	}
	@OneToOne(cascade = CascadeType.MERGE)
	   @JoinColumn(name = "user_id", referencedColumnName="user_id", unique=false)
		private CredentialsBean credentialsBean;
	
//	to create one to one mapping with vehicle
	@OneToOne(cascade = CascadeType.MERGE)
   @JoinColumn(name = "driver_id", referencedColumnName="driver_id", unique=false)
	private DriverBean driverBean;
	
	@OneToOne(cascade = CascadeType.MERGE)
	   @JoinColumn(name = "vehicle_id", referencedColumnName="vehicle_id", unique=false)
		private VehicleBean vehicleBean;
	
	@OneToOne(cascade = CascadeType.MERGE)
	   @JoinColumn(name = "route_id", referencedColumnName="route_id", unique=false)
		private RouteBean routeBean;
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	public int getVehicleId() {
//		return vehicleId;
//	}
//	public void setVehicleId(int vehicleId) {
//		this.vehicleId = vehicleId;
//	}
//	public int getRouteId() {
//		return routeId;
//	}
//	public void setRouteId(int routeId) {
//		this.routeId = routeId;
//	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}
	//public int getDriverId() {
	//	return driverId;
	//}
//	public void setDriverId(int driverId) {
//		this.driverId = driverId;
//	}
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public int getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}
	public String getBoardingPoint() {
		return boardingPoint;
	}
	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}
	public String getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}

}
