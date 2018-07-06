package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.EcomBEnd.Dao.CategoryDAO;
import com.niit.EcomBEnd.Dao.ProductDAO;
import com.niit.EcomBEnd.Model.ProductModel;

@Controller
public class ProductList 
{
	 @Autowired
	 ProductDAO products;
	 @Autowired
	 CategoryDAO categoryDAO;
	@RequestMapping(value ="/admin/productlistview")
    public ModelAndView getlist() 
   {
		ModelAndView mv=new ModelAndView("productlistview");
		List<ProductModel>slist=products.getAll();
		mv.addObject("slist", slist);
	return mv;
	

   }
	@ModelAttribute
	  public void addAttributes(Model model)
	  {
		  model.addAttribute("clist",categoryDAO.getAll());
	  }
}
