package com.niit.EcomBEnd;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcomBEnd.Dao.SupplierDAO;
import com.niit.EcomBEnd.Model.SupplierModel;

import junit.framework.Assert;

public class SuplierModelTest {
	private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	SupplierModel supliermodel;
	SupplierDAO suplierdao;

	
	@BeforeClass
	public static void initialize()
	{
		context.scan("com.niit.EcomBEnd");
		context.refresh();
	}
@Test
public void saveProductTestCase()
{
	supliermodel.setSuplierid(121);
	supliermodel.setSuppliername("Soap");
	boolean result =suplierdao.addSuplier(supliermodel);
	Assert.assertEquals(true, result);
}
}