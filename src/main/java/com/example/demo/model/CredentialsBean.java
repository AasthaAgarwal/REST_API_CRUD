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
@Table(name="Credentials")
@TableGenerator(name="tab", initialValue=1000, allocationSize=0)
public class CredentialsBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
	@Column(name = "user_id")
	int userID;
	String password;
	Type userType;
	int loginStatus;
	
	@OneToOne(mappedBy = "credentialsBean")
	private ReservationBean reservationBean;
	
	
//	public ReservationBean getReservationBean() {
//		return reservationBean;
//	}
//	public void setReservationBean(ReservationBean reservationBean) {
//		this.reservationBean = reservationBean;
//	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Type getUserType() {
		return userType;
	}
	public void setUserType(Type userType) {
		this.userType = userType;
	}
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	} 

}
