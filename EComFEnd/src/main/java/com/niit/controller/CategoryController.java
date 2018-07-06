package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.EcomBEnd.Dao.CategoryDAO;
import com.niit.EcomBEnd.Dao.ProductDAO;
import com.niit.EcomBEnd.Dao.SupplierDAO;
import com.niit.EcomBEnd.Model.CategoryModel;
import com.niit.EcomBEnd.Model.ProductModel;
import com.niit.EcomBEnd.Model.SupplierModel;


@Controller
public class CategoryController 
{
	
	 //private static final String UPLOAD_DIRECTORY ="/images";  

     @Autowired
     CategoryDAO categorys;
     @Autowired
	 SupplierDAO suppliers;
     @Autowired
     ProductDAO  product2;
     
       
	 //        /admin/add
	@RequestMapping(value ="/admin/add")
	    public ModelAndView add() 
	{
		List<CategoryModel> list=categorys.getAll();
		List<SupplierModel> slist=suppliers.getSave();
		ModelAndView mv = new ModelAndView("Adding");
		//System.out.println(list.get(0).getC_name());	
		mv.addObject("slist", slist);
		mv.addObject("clist", list);
					return mv;
			
	    }
	
	 @RequestMapping(value ="/admin/category")
	    public ModelAndView addcategorys(HttpServletRequest request)
	    {
	        
		 int c_id=Integer.valueOf(request.getParameter("c_id"));
			String c_name=request.getParameter("c_name");
			System.out.println(c_id);
			categorys.addCategory(new CategoryModel(c_id, c_name));
			ModelAndView mv = new ModelAndView("Adding");
			return mv;
	    }
	 
	
	 
	 
	@RequestMapping(value ="/admin/supplier")
	    public ModelAndView addSuppliers(HttpServletRequest request)
	    {
	        
		   int s_id=Integer.valueOf(request.getParameter("supplier_id"));
			
		   
		   String s_name=request.getParameter("supplier_name");
			
			suppliers.addSuplier(new SupplierModel(s_id,s_name));
			ModelAndView mv = new ModelAndView("Adding");
			return mv;
	    }
	
	@RequestMapping("/admin/addProduct")
	public ModelAndView addProducts(@RequestParam("file") MultipartFile file,HttpServletRequest request) 
	{ 
		
		int id=Integer.valueOf(request.getParameter("id"));
		String pname=request.getParameter("pname");
		int price=Integer.valueOf(request.getParameter("price"));
		int cid=Integer.valueOf(request.getParameter("cid"));
		int sid=Integer.valueOf(request.getParameter("sid"));
		System.out.println(id+"-"+pname+"-"+price+"-"+cid+"-"+sid);
		CategoryModel c=categorys.findById(cid);
		SupplierModel s=suppliers.findById(sid);
		//product2.addProduct(new ProductModel(id,pname,price,c,s));
		
        ProductModel p=new ProductModel();
        p.setCategoryid(c);
        p.setProductname(pname);
        p.setProductprice(price);
        p.setProductid(id);
        String originalfile = file.getOriginalFilename();
        p.setP_image(originalfile);
        p.setSuplierid(s);
        product2.addProduct(p);
        String filepath = request.getSession().getServletContext().getRealPath("/");
        
        System.out.println(filepath+originalfile);
        try {
        	byte imagebyte[] = file.getBytes();
        	BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath+"/resources/images/"+originalfile));
        	fos.write(imagebyte);
        	fos.close();
        	} catch (IOException e) {
        	e.printStackTrace();
        	} catch (Exception e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        	}

		ModelAndView mv = new ModelAndView("Adding");
		
		return mv;
	   
		
		
		}
	

	  
	   
}

	
	
	

