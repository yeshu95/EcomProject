package com.niit.EcomBEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcomBEnd.Dao.UserDAO;

import com.niit.EcomBEnd.Model.UserModel;

import junit.framework.Assert;

public class UserModelTest {
	private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	UserModel userModel;
	UserDAO userDao;

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@BeforeClass
	public static void initialize()
	{
		context.scan("com.niit.EcomBEnd");
		context.refresh();
	}
	@Test
	public void saveProductTestCase()
	{
		userModel.setName("raj");
		userModel.setPassword("pass");
		userModel.setAge(25);
		userModel.setAddress("vellore");;
		boolean result =userDao.addUser(userModel);
		Assert.assertEquals(true, result);
	}
}
