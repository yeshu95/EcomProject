package com.niit.EcomBEnd.DaoImpl;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.EcomBEnd.Dao.ProductDAO;
import com.niit.EcomBEnd.Model.ProductModel;

@Repository
public class ProductDAOImpl implements ProductDAO
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	public boolean addProduct(ProductModel product)
	{
		
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(product);
		s.getTransaction().commit();
		s.close();
		return true;
		}
	public ProductModel getId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(ProductModel product) {

		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.update(product);
		s.getTransaction().commit();
		s.close();
		
	}

	public List<ProductModel> getAll()
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		Query query =s.createQuery("from ProductModel");        
		List<ProductModel> list=query.list();
		System.out.println(list);
		s.getTransaction().commit();
		return list;
	}
	public ProductModel findById(int id) {
		return (ProductModel)sessionFactory.openSession().get(ProductModel.class,id);
	}
	public void delete(ProductModel p) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.delete(p);
		s.getTransaction().commit();
		s.close();sessionFactory.openSession().delete(p);
		
	}
	public List<ProductModel> getFilterProducts(int categoryid)
	{
		Session s=sessionFactory.openSession();
		
		List<ProductModel> results =s.createQuery("from ProductModel where categoryid="+categoryid).list();
		s.close();
		// TODO Auto-generated method stub
		return results;
	}
	
	
	
 
	 
	   
	   
	   
	   
   
}
