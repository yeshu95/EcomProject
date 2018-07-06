package com.niit.EcomBEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcomBEnd.Dao.CategoryDAO;
import com.niit.EcomBEnd.Model.CategoryModel;

import junit.framework.Assert;

public class CategoryModelTest {
	private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	CategoryModel categorytModel;
	CategoryDAO categorydao;

	
	@BeforeClass
	public static void initialize()
	{
		context.scan("com.niit.EcomBEnd");
		context.refresh();
	}
	@Test
	public void saveProductTestCase()
	{
		categorytModel.setCategoryid(101);
		categorytModel.setCategoryname("Lux");
		//categorytModel.setCategoryDesc("50");
		boolean result =categorydao.addCategory(categorytModel);
		Assert.assertEquals(true, result);
	}

}
