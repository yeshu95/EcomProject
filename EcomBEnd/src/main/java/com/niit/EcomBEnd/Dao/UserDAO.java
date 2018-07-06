package com.niit.EcomBEnd.Dao;

import java.util.ArrayList;

import com.niit.EcomBEnd.Model.UserModel;

public interface UserDAO 
{
	 	public boolean addUser(UserModel u);
		public  void getId(int id);
		public void update(UserModel u);
		public void deleteById(int id);
		public ArrayList<UserModel> getAll();
		public UserModel findById(int id);
}
