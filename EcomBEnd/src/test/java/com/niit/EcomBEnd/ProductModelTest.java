package com.niit.EcomBEnd;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcomBEnd.Dao.ProductDAO;
import com.niit.EcomBEnd.Model.ProductModel;

public class ProductModelTest {
	private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	ProductModel productmodel;
	ProductDAO productdao;
	

	@BeforeClass
	public static void initialize()
	{
		context.scan("com.niit.EcomBEnd");
		context.refresh();
	}
	@Test
	public void saveProductTestCase()
	{
		productmodel.setProductid(101);
		productmodel.setProductname("Lux");
		productmodel.setPrice(50);
		productmodel.setQty(20);
		boolean result =productdao.addProduct(productmodel);
		Assert.assertEquals(true, result);
	}
	
}
