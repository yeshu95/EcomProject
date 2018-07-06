package com.niit.EcomBEnd.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomBEnd.Dao.CartDAO;
import com.niit.EcomBEnd.Model.CartModel;

@Repository
public class CartDAOImpl implements CartDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void save(CartModel cart1)
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(cart1);
		s.getTransaction().commit();
		s.close();
		
	}

	public CartModel getId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(CartModel cart) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.update(cart);
		s.getTransaction().commit();
		s.close();
		
	}

	public void delete(CartModel p)
	{
		
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.delete(p);
		s.getTransaction().commit();
		s.close();

	}  

	public List<CartModel> getAll() 
	{
		Session s=sessionFactory.openSession();
		List<CartModel> clist=s.createCriteria(CartModel.class).list();
		s.clear();
		return clist;
	}
	public CartModel findById(int id) 
	{
		
		
		return (CartModel)sessionFactory.openSession().get(CartModel.class,id);
	}

	public List<CartModel> check(int productid)
	{
		   Session s=sessionFactory.openSession();		
	        List<CartModel> results =s.createQuery("from CartModel where productid="+productid).list();		
			s.close();
			return results;
	}

	
}

	
    

