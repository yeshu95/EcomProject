package com.niit.EcomBEnd.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.niit.EcomBEnd.Model.CartModel;
import com.niit.EcomBEnd.Model.CategoryModel;
import com.niit.EcomBEnd.Model.OrderModel;
import com.niit.EcomBEnd.Model.ProductModel;
import com.niit.EcomBEnd.Model.SupplierModel;
import com.niit.EcomBEnd.Model.UserModel;



@Configuration
@ComponentScan({"com.niit.EcomBEnd"})
@EnableTransactionManagement
public class ApplicationConfig 
{
	@Autowired
	@Bean(name ="dataSource")
	public DataSource dataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
	    ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/EcomProject");
		ds.setUsername("sa");
		ds.setPassword(""); 
		return ds;
	}
	private Properties getHibernateProperties() 
	{
        Properties prop = new Properties();
        prop.put("hibernate.show_sql", "true");
        prop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        prop.put("hibernate.format_sql", "true");
        prop.put("hibernate.hbm2ddl.auto", "update");
        return prop;
   }
	
	@Autowired
	@Bean(name ="sessionFactory")
    public SessionFactory sessionFactory(DataSource dataSource) 
	{
            LocalSessionFactoryBuilder builder =new LocalSessionFactoryBuilder(dataSource);
            builder.addProperties(getHibernateProperties());
            builder.scanPackages("com.niit.EcomBEnd");
          /*  builder.addAnnotatedClass(ProductModel.class);
            builder.addAnnotatedClass(CategoryModel.class);
            builder.addAnnotatedClass(SupplierModel.class);
            builder.addAnnotatedClass(UserModel.class);
            builder.addAnnotatedClass(OrderModel.class);
            builder.addAnnotatedClass(CartModel.class);*/
            return builder.buildSessionFactory();
    }
	
	//Create a transaction manager
		@Bean
		@Autowired
	        public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
	                return new HibernateTransactionManager(sessionFactory);
	        }

		

}
