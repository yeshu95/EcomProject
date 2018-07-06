package com.niit.EcomBEnd.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.EcomBEnd.Dao.CategoryDAO;
import com.niit.EcomBEnd.Model.CategoryModel;
@Repository
public class CategoryDAOImpl implements CategoryDAO
{

	@Autowired
	private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sf){
			this.sessionFactory = sf;
		}
	public boolean addCategory(CategoryModel category1)
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(category1);
		s.getTransaction().commit();
		s.close();
		return true;
		
	}

	public CategoryModel getId(int id) {
		return null;
	}

	public void update(CategoryModel category) {
		
	}

	public void deleteById(int id) {
		
	}

	public List<CategoryModel> getAll() 
	{
		
			Session s=sessionFactory.openSession();
			s.beginTransaction();
			Query query =s.createQuery("from CategoryModel");        
			List<CategoryModel> list=query.list();
			System.out.println(list);
			s.getTransaction().commit();
			return list;
		
	}

	
	
		
	public CategoryModel findById(int id) 
	{
		
		CategoryModel c=(CategoryModel)sessionFactory.openSession().get(CategoryModel.class, id);
		return c;
	}

	
    
}
