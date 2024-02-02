package com.sid.foodapp.controller;

import java.security.PublicKey;
import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sid.foodapp.dao.Productdao;
import com.sid.foodapp.enities.Product;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Productcontroller {

	@Autowired
	Productdao dao;

	@RequestMapping("/addproduct")
	public ModelAndView addProduct()
		{
			ModelAndView mav= new ModelAndView("createproduct");
			
			Product p=new Product();
			
			mav.addObject("Product",p);
			return mav;
		}

	@RequestMapping("/saveproduct")
		public ModelAndView saveProduct(@ModelAttribute("Product") Product p)
		{
			dao.saveProduct(p);
			ModelAndView mav=new ModelAndView("adminoptions");
			return mav;
			
		}
	
	
	
	@RequestMapping("/viewallproduct")
	public ModelAndView fetchAllproducts()
	{
		     List<Product> products=dao.viewALLProducts();
		     ModelAndView mav=new ModelAndView("allproducts");
		     mav.addObject("productslist",products);
		     return mav;
		     
	}
	
	@RequestMapping("/editproduct")
	public ModelAndView editProduct(@RequestParam("id") int id)
	{
		Product product=dao.viewProductById(id);
		ModelAndView mav=new ModelAndView("updateproduct");
		mav.addObject("productdata",product);
		return mav;
		
	}
	
	
	
	@RequestMapping("/updateprod")
	public ModelAndView updateProduct(ServletRequest req)
	{
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String type=req.getParameter("type");
		String cost=req.getParameter("cost");
		
		Product p=new Product();
		p.setId(Integer.parseInt(id));
		p.setName(name);
		p.setType(type);
		p.setCost(Double.parseDouble(cost));
		dao.updateProduct(p);
		ModelAndView mav=new ModelAndView("redirect:/viewallproduct");
		return mav;
		
	}
	
	
	@RequestMapping("/deleteproducts")
	public ModelAndView deleteProduct(@RequestParam("id") int id)
	{
		ModelAndView mav=new ModelAndView("redirect:/viewallproduct");
		dao.deleteProduct(id);
		return mav;
		
		
	}
	
	@RequestMapping("/viewallproducts")
	public ModelAndView fetchAllproduct()
	{
		     List<Product> products=dao.viewALLProducts();
		     ModelAndView mav=new ModelAndView("viewproducts");
		     mav.addObject("productslist",products);
		     return mav;
		     
	}
		
		
		
	
	
}
