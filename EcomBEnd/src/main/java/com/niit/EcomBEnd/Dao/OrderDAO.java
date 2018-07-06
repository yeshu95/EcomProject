package com.niit.EcomBEnd.Dao;

import java.util.List;

import com.niit.EcomBEnd.Model.OrderModel;

public interface OrderDAO  
{
    public void save(OrderModel cart);
		public  OrderModel getId(int id);
		public void update(OrderModel cart);
		public void deleteById(int id);
		public List<OrderModel> getAll();
}
