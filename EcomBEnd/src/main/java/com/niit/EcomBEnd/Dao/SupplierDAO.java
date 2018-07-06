package com.niit.EcomBEnd.Dao;

import java.util.List;

import com.niit.EcomBEnd.Model.SupplierModel;

public interface SupplierDAO 
{
	 	//public void addSupplier(SupplierModel supplier);
		public SupplierModel getId(int id);
		public void update(SupplierModel supplier);
		public void deleteById(int id);
		public List<SupplierModel> getSave();
		public SupplierModel findById(int id);
		public boolean addSuplier(SupplierModel supliermodel);
}
