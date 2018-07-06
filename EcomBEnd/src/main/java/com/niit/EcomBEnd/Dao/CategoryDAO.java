package com.niit.EcomBEnd.Dao;

import java.util.List;
import com.niit.EcomBEnd.Model.CategoryModel;




public interface CategoryDAO 
{
	 	public boolean addCategory(CategoryModel category1);
		public CategoryModel getId(int id);
		public void update(CategoryModel category);
		public void deleteById(int id);
		public List<CategoryModel> getAll();
		public CategoryModel findById(int id);
}
