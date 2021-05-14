package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="Route")
@TableGenerator(name="tab", initialValue=1000, allocationSize=0)
public class RouteBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	@Column(name = "route_id")
	int routeId;
	String source;
	String destination;
	int distance;
	int travelDuration;
	
	@OneToOne(mappedBy = "routeBean")
	private ReservationBean reservationBean;
	
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getTravelDuration() {
		return travelDuration;
	}
	public void setTravelDuration(int travelDuration) {
		this.travelDuration = travelDuration;
	}
	
	

}
