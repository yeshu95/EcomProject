package com.niit.EcomBEnd.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomBEnd.Dao.SupplierDAO;
import com.niit.EcomBEnd.Model.SupplierModel;

@Repository
public class SupplierDAOImpl implements SupplierDAO 
{
	

	 @Autowired
		private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sf){
			this.sessionFactory = sf;
		}
		public SupplierModel getId(int id) {
			return null;
		}
		public void update(SupplierModel supplier) {
		}
		public void deleteById(int id) {

		}

		public List<SupplierModel> getSave()
		{
			
			Session s=sessionFactory.openSession();
			s.beginTransaction();
			Query query =s.createQuery("from SupplierModel");        
			List<SupplierModel> list=query.list();
			System.out.println(list);
			s.getTransaction().commit();
			return list;
		}

	
		public SupplierModel findById(int id) {
			SupplierModel s=(SupplierModel)sessionFactory.openSession().get(SupplierModel.class, id);
			return s;
		}

		public boolean addSuplier(SupplierModel supliermodel) {
			Session s=sessionFactory.openSession();
			s.beginTransaction();
			s.save(supliermodel);
			s.getTransaction().commit();
			s.close();
			return true;
		}
}
