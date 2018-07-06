package com.niit.EcomBEnd.Dao;

import java.util.List;

import com.niit.EcomBEnd.Model.CartModel;



public interface CartDAO  
{
	public void save(CartModel cart);
		public CartModel getId(int id);
		public void update(CartModel cart);
		public void delete(CartModel p);
		public List<CartModel> getAll();
		public CartModel findById(int id);
		public List<CartModel> check(int productid);
}
