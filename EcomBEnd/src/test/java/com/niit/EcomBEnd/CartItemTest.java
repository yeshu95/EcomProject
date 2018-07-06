/*package com.niit.EcomBEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcomBEnd.Dao.CartDAO;
import com.niit.EcomBEnd.Model.CartModel;

import junit.framework.Assert;

public class CartItemTest {
	private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	CartModel cartItem;
	CartDAO carttemdao;

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
		cartItem.setCartid(101);
		cartItem.setProductid(50);
		cartItem.setPrices(20);
		cartItem.setQuantity(10);
		cartItem.
		boolean result =carttemdao.save(cart);
		Assert.assertEquals(true, result);
	}
}
*/