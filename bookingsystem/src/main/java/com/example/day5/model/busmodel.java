package com.example.day5.model;

import jakarta.persistence.CascadeType;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="busdetails")
public class busmodel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int busid;
	public String busname;
	public String depature;
	public String arrival;
	public String busnum;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pay_id" , referencedColumnName = "pay_id")
	public paymentmodel paymentdetails;
	public int getBusid() {
		return busid;
	}
	public void setBusid(int busid) {
		this.busid = busid;
	}
	public String getBusname() {
		return busname;
	}
	public void setBusname(String busname) {
		this.busname = busname;
	}
	public String getDepature() {
		return depature;
	}
	public void setDepature(String depature) {
		this.depature = depature;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getBusnum() {
		return busnum;
	}
	public void setBusnum(String busnum) {
		this.busnum = busnum;
	}
	public paymentmodel getPaymentdetails() {
		return paymentdetails;
	}
	public void setPaymentdetails(paymentmodel paymentdetails) {
		this.paymentdetails = paymentdetails;
	}

}