package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CreditCard")
public class CreditCardBean {
	
@Id
    String creditCardNumber;
	String validTo;
	String validFrom;
	int creditBalance;
	//int userid;  //foriegn key
	
	@OneToOne(cascade = CascadeType.ALL)
	   @JoinColumn(name = "user_id", referencedColumnName="user_id", unique=true)
		private CredentialsBean credentialsBean;

public String getCreditCardNumber() {
	return creditCardNumber;
}
public void setCreditCardNumber(String creditCardNumber) {
	this.creditCardNumber = creditCardNumber;
}
public String getValidTo() {
	return validTo;
}
public void setValidTo(String validTo) {
	this.validTo = validTo;
}
public String getValidFrom() {
	return validFrom;
}
public void setValidFrom(String validFrom) {
	this.validFrom = validFrom;
}
public int getCreditBalance() {
	return creditBalance;
}
public void setCreditBalance(int creditBalance) {
	this.creditBalance = creditBalance;
}
//public int getUserid() {
//	return userid;
//}
//public void setUserid(int userid) {
//	this.userid = userid;
//}


}
