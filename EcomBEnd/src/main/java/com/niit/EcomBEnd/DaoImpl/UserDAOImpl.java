package com.niit.EcomBEnd.DaoImpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomBEnd.Dao.UserDAO;
import com.niit.EcomBEnd.Model.UserModel;



@Repository
public class UserDAOImpl implements UserDAO
{
	 @Autowired
		private SessionFactory sessionFactory;
		public void setSessionFactory(SessionFactory sf){
			this.sessionFactory = sf;
		}
		public boolean addUser(UserModel u)
		{
			Session s=sessionFactory.openSession();
			s.beginTransaction();
			s.save(u);
			s.getTransaction().commit();
			s.close();
			return true;
			
		}
	

	public void getId(int id) {
		
	}

	public void update(UserModel User) {
		
	}

	public void deleteById(int id) {
	}

	public ArrayList<UserModel> getAll() {
		return null;
	}
	public UserModel findById(int id) {
		UserModel s=(UserModel)sessionFactory.openSession().get(UserModel.class, id);
		return s;
	}
	
	

}
