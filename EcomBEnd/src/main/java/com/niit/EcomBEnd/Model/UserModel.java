package com.niit.EcomBEnd.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unused")
@Entity	
@Table()
public class UserModel implements Serializable
{

	
	private static final long serialVersionUID = 1L;   
	@Id
	@Column(name="userid")//defining the database column
	private int userid;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Column(name="address")
	private String address;
	@Column(name="email")
	private String email;
	@Column(name="age")
	private int age;
	@Column(name="city")
	private String city;
	@Column(name="phone")
	private String phone;
	@Column(name="gender")
	private String gender;
	@Column(name="enabled")
	private boolean enabled;
	 @OneToMany(targetEntity=OrderModel.class, mappedBy="userid", cascade=CascadeType.ALL)
	private Set<OrderModel> setoforders;
	 private String role;
	
	 public UserModel() {
			super();
		}
	
	public int getUserid() {
		return userid;
	}
	public UserModel(int userid, String name, String password, String address, String email, int age, String city,
			String phone, String gender, boolean enabled, Set<OrderModel> setoforders, String role) {
		super();
		this.userid = userid;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.age = age;
		this.city = city;
		this.phone = phone;
		this.gender = gender;
		this.enabled = enabled;
		this.setoforders = setoforders;
		this.role = role;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Set<OrderModel> getSetoforders() {
		return setoforders;
	}
	public void setSetoforders(Set<OrderModel> setoforders) {
		this.setoforders = setoforders;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
