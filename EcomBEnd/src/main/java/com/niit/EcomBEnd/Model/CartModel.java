package com.niit.EcomBEnd.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Entity Mapped to the table
@Entity	
@Table()
public class CartModel implements Serializable
{

	
	private static final long serialVersionUID = 1L;
	
	@Id
     private int cartid;
	private ProductModel productid;
	private SupplierModel suplierid;
	private int prices;
	private int quantity;
	private String status;
	
	@Id
	@GeneratedValue
	@Column(name="cartid")
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
		@OneToOne
		@JoinColumn(name="productid")
		public ProductModel getProductid() {
			return productid;
		}
		public void setProductid(ProductModel productid) {
			this.productid = productid;
		}
		
	@Column(name="prices")
	public int getPrices() {
		return prices;
	}
	public void setPrices(int prices) {
		this.prices = prices;
	}
	@Column(name="quantity")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	

}
