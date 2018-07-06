package com.niit.EcomBEnd.Model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity	
@Table()
public class SupplierModel implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int suplierid;
	private String suppliername;
	//private Set<ProductModel> setofproducts;
	
	public SupplierModel() {
		super();
	}
	public SupplierModel(int suplierid, String suppliername) {
		super();
		this.suplierid = suplierid;
		this.suppliername = suppliername;
	}
	@Id
	@Column(name="suplierid")
	public int getSuplierid() {
		return suplierid;
	}
	public void setSuplierid(int suplierid) {
		this.suplierid = suplierid;
	}
	@Column(name="suppliername")
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
/*	 @OneToMany(targetEntity=ProductModel.class, mappedBy="suplierid", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@Column(name="setofproducts")
	public Set<ProductModel> getSetofproducts() {
		return setofproducts;
	}
	public void setSetofproducts(Set<ProductModel> setofproducts) {
		this.setofproducts = setofproducts;
	}
	*/

}
