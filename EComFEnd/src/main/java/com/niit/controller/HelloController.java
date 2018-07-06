package com.niit.controller;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.EcomBEnd.Dao.CartDAO;
import com.niit.EcomBEnd.Dao.CategoryDAO;
import com.niit.EcomBEnd.Dao.SupplierDAO;
import com.niit.EcomBEnd.Dao.UserDAO;
import com.niit.EcomBEnd.Model.CartModel;
import com.niit.EcomBEnd.Model.CategoryModel;
import com.niit.EcomBEnd.Model.ProductModel;
import com.niit.EcomBEnd.Model.SupplierModel;
import com.niit.EcomBEnd.Model.UserModel;
import com.niit.EcomBEnd.Dao.*;

@Controller
public class HelloController 
{
	@Autowired
	private ProductDAO productDAO;
	@Autowired
    private UserDAO user1;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private CartDAO cart1;
	  
	
	public void ProductDAO(ProductDAO productDAO)
	{
		this.productDAO=productDAO;
	}

	
   @RequestMapping(value="/")
	public ModelAndView homepage()
	{
		ModelAndView m1=new ModelAndView("index");
		//ModelAndView mv=new ModelAndView("header");
		List<CategoryModel>list=categoryDAO.getAll();
		m1.addObject("clist", list);
		
	//return mv;
		return m1;
		
	}
  @ModelAttribute
  public void addAttributes(Model model)
  {
	  model.addAttribute("clist",categoryDAO.getAll());
  }
   @RequestMapping(value="/login")
	public ModelAndView loginpage()
	{
		ModelAndView m2=new ModelAndView("login");
		return m2;
		
	}
   @RequestMapping(value="/reg")
  	public ModelAndView regpage()
  	{
  		ModelAndView m2=new ModelAndView("registerpage");
  		return m2;
  		
  	}
   @RequestMapping(value ="/registerpage")
   public ModelAndView addUser(HttpServletRequest request)
   {
       
		
	   int u_id=Integer.valueOf(request.getParameter("userid"));
		
	  // int u_id=Integer.parseInt(request.getParameter("userid"));
	   
	   String u_name=request.getParameter("username");
	   
	   String u_pass=request.getParameter("userpass");
	   
	   String u_addr=request.getParameter("useraddress");
	   
	   String u_mail=request.getParameter("usermail");
	   
	   int u_age=Integer.valueOf(request.getParameter("userage"));
	   
	   //int u_age=Integer.parseInt(request.getParameter("userage"));
	   
	   String u_city=request.getParameter("usercity");
	   String u_phone=request.getParameter("userphone");
	   
	   //int u_phone=Integer.valueOf(request.getParameter("userphone"));
	   
	  // int u_phone=Integer.parseInt(request.getParameter("userphone"));
	   
	   String u_gen=request.getParameter("usergen");
	   
	   
	   
	   UserModel u=new UserModel();
	   u.setUserid(u_id);
	   u.setName(u_name);
	   u.setPassword(u_pass);
	   u.setAddress(u_addr);
	   u.setEmail(u_mail);
	   u.setAge(u_age);
	   u.setCity(u_city);
	   u.setPhone(u_phone);
	   u.setGender(u_gen);
	   u.setRole("ROLE_USER");
	   user1.addUser(u);
		//System.out.println(u.getUserid());
		
		ModelAndView mv = new ModelAndView("index");
		return mv;
   }
/*@RequestMapping(value="/registerpage")
  public ModelAndView registerpage()
  {
	ModelAndView m3=new ModelAndView("registerpage");
	return m3;
  }*/
//Testing
@RequestMapping(value="/product_detail")
public ModelAndView product_detail()
{
	ModelAndView m3=new ModelAndView("product_detail");
	return m3;
}

@RequestMapping(value="/admin/product_delete")
public ModelAndView deleteProduct(HttpServletRequest request){
	
	ProductModel p=productDAO.findById(Integer.valueOf(request.getParameter("id")));
	System.out.print(p);
    productDAO.delete(p);
    List<ProductModel> list=productDAO.getAll();
    ModelAndView mv = new ModelAndView("Adding");	
    mv.addObject("list",list);
   return mv;
}

@RequestMapping(value="/admin/product_edit")
//@RequestMapping(value="/admin/")
public ModelAndView editProducts(HttpServletRequest request){	
int id=Integer.parseInt(request.getParameter("id"));
ModelAndView mv=new ModelAndView("productEdit");
List<CategoryModel> list=categoryDAO.getAll();
List<SupplierModel> slist=supplierDAO.getSave();	
mv.addObject("product",productDAO.findById(id) );	
mv.addObject("slist", list);
mv.addObject("clist", slist);
return mv;
}
@RequestMapping(value = "/admin/product_update", method = RequestMethod.POST)
public  ModelAndView updateProduct(@RequestParam("file") MultipartFile file ,HttpServletRequest request) 
{ 

	int id=Integer.valueOf(request.getParameter("id"));
	String pname=request.getParameter("pname");
	int price=Integer.valueOf(request.getParameter("price"));
	int cid=Integer.valueOf(request.getParameter("cid"));
	int sid=Integer.valueOf(request.getParameter("sid"));
	System.out.println(id+"-"+pname+"-"+price+"-"+cid+"-"+sid);
	CategoryModel c=categoryDAO.findById(cid);
	SupplierModel s=supplierDAO.findById(sid);
	//product2.addProduct(new ProductModel(id,pname,price,c,s));
	
    ProductModel p=new ProductModel();
    p.setCategoryid(c);
    p.setProductname(pname);
    p.setProductprice(price);
    p.setProductid(id);
    String originalfile = file.getOriginalFilename();
    p.setP_image(originalfile);
    p.setSuplierid(s);
    productDAO.update(p);
    String filepath = request.getSession().getServletContext().getRealPath("/");
    
    System.out.println(filepath+originalfile);
    try {
    	byte imagebyte[] = file.getBytes();
    	BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath+"/resources/product/"+originalfile));
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

@RequestMapping("/categoryproductlist")
public ModelAndView productListFilter(HttpServletRequest request)
{ 
	List<ProductModel> clist=productDAO.getFilterProducts(Integer.valueOf(request.getParameter("id")));
	//List<Product> list=productDao.getProducts();
	ModelAndView mv = new ModelAndView("categoryproductlist");	
	mv.addObject("list",clist);
	return mv;
}

@RequestMapping("/product")
public ModelAndView product(HttpServletRequest request) 
{
	
    int id=Integer.valueOf(request.getParameter("id"));
    ProductModel p=productDAO.findById(id);
	ModelAndView mv = new ModelAndView("productdetails");
	List<CategoryModel> c=categoryDAO.getAll();
	mv.addObject("list",c);
	mv.addObject("product", p);
	
	return mv;
}
//AddCartTable data
@RequestMapping(value="/productdetails", method=RequestMethod.POST)
public ModelAndView addCarttable(HttpServletRequest request) 
{
	
	int id=Integer.valueOf(request.getParameter("prodid"));
	
	int quan=Integer.valueOf(request.getParameter("prodquantity"));
	
	int price=Integer.valueOf(request.getParameter("prodprice"));
	
	System.out.println(""+id+""+quan+""+price);
	ProductModel p=productDAO.findById(id);
	CartModel g=new CartModel();
	g.setPrices(price);
	g.setQuantity(quan);
	g.setProductid(p);
	
	List<CartModel> list=cart1.check(id);
	//cart1.save(g);
	int count=list.size();
	
	if(count==0)
	{
		cart1.save(g);
	}
	else
	{
		CartModel cart=cart1.findById(list.get(0).getCartid());
		int e=cart.getQuantity();
		
		int tot=e+quan;
		cart.setQuantity(tot);
		cart1.update(cart);
	}
	
	ModelAndView mv = new ModelAndView("viewcartdetail");
	
	List<CartModel> cartList=cart1.getAll();
	
	mv.addObject("cartlist", cartList);
	return mv;
	
}
@RequestMapping("/cart_delete")
public ModelAndView editCart(HttpServletRequest request)
{
	int cid=Integer.valueOf(request.getParameter("id"));
	CartModel c=cart1.findById(cid);
	cart1.delete(c);
	
	ModelAndView mv=new ModelAndView("viewcartdetail");
	List<CartModel> cartList=cart1.getAll();
	
	mv.addObject("cartlist", cartList);
	return mv;
}
@RequestMapping(value="/customerdetails")
	public ModelAndView customerpage()
	{
		ModelAndView m8=new ModelAndView("customerdetails");
		return m8;
		
	}
/*@RequestMapping(value="/customerdetails")
public String checkout()
{
	return "redirect:/checkout";
}*/
/*@RequestMapping(value="/summery")
public ModelAndView summery(HttpServletRequest request)
{
		
	

	
	Summary summary=new Summary();
	summary.setName(request.getParameter("name"));
	summary.setEmail(request.getParameter("email"));
	summary.setContact(request.getParameter("phone"));
	summary.setAddress(request.getParameter("textarea"));
	summary.setDate(request.getParameter("date"));
		
	
	ModelAndView m8=new ModelAndView("summery");
	m8.getModelMap().addAttribute("summary", summary);
	return m8;
	
}*/
@RequestMapping("/userlogged")
public String userLogged() { 
	return "redirect:/";	
}
@RequestMapping("/noAccessPage")
public String notacess() { 
	return "redirect:noAccessPage";	
}
@RequestMapping(value="/sucess")
public ModelAndView sucesspage()
{
	ModelAndView m8=new ModelAndView("sucess");
	return m8;
	
}
}
