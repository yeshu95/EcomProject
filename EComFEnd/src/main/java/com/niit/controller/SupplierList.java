package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.EcomBEnd.Dao.CategoryDAO;
import com.niit.EcomBEnd.Dao.SupplierDAO;
import com.niit.EcomBEnd.Model.SupplierModel;


@Controller
public class SupplierList 
{ 
	@Autowired
	 SupplierDAO suppliers;
	@Autowired
	 CategoryDAO categorys;
	
	@RequestMapping(value ="/admin/supplierlist")
    public ModelAndView add() {
		ModelAndView mv=new ModelAndView("supplierlist");
		List<SupplierModel>sulist=suppliers.getSave();
		mv.addObject("sulist", sulist);
	return mv;
    }
	@ModelAttribute
	  public void addAttributes(Model model)
	  {
		  model.addAttribute("clist",categorys.getAll());
	  }
}
