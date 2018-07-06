package com.niit.EcomBEnd.Dao;

import java.util.List;

import com.niit.EcomBEnd.Model.ProductModel;

public interface ProductDAO
{

	public boolean addProduct(ProductModel product);
	public ProductModel getId(int id);
	public void update(ProductModel product);
	public void delete(ProductModel p);
	public List<ProductModel> getAll();
	public ProductModel findById(int id);
	public List<ProductModel> getFilterProducts(int id);
}
