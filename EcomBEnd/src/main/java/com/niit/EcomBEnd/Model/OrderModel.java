package com.niit.EcomBEnd.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity	
@Table()
public class OrderModel implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
    private int orderid;
    private String payment;
    private int ordertotal;
    private UserModel userid;
    @Id
	@GeneratedValue
	@Column(name="orderid")//defining the database column
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	@ManyToOne
	@JoinColumn(name="userid")
	public UserModel getUserid() {
		return userid;
	}
	public void setUserid(UserModel userid) {
		this.userid = userid;
	}
	@Column(name="payment")
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	@Column(name="ordertotal")
	public int getOrdertotal() {
		return ordertotal;
	}
	public void setOrdertotal(int ordertotal) {
		this.ordertotal = ordertotal;
	}

}
