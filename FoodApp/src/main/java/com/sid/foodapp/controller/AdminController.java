package com.sid.foodapp.controller;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.sid.foodapp.dao.Admindao;
import com.sid.foodapp.enities.Admin;

@Controller
public class AdminController {
	@Autowired
	Admindao admindao;

	@RequestMapping("/addadmin")
	public ModelAndView addAdmin() {

		ModelAndView mav = new ModelAndView("createadmin");
		Admin admin = new Admin();
		mav.addObject("admin", admin);
		return mav;

	}

	@RequestMapping("/saveadmin")
	public ModelAndView saveAdmin(@ModelAttribute("admin") Admin a) {
		ModelAndView mav = new ModelAndView("loginadmin");
		admindao.saveAdmin(a);

		return mav;
	}
	
	@RequestMapping("/validateadmin")
	public ModelAndView Loginvalidation(ServletRequest req)
	
	{
		 String email=req.getParameter("email");
		 String password=req.getParameter("password");
		 Admin admin= admindao.Login(email, password);
		 
		 if(admin==null)
		 {
			 ModelAndView mav=new ModelAndView("loginadmin");
			 
			 mav.addObject("massage","invalid credentails");
			 return mav;
		 }
		 
		 else {
			ModelAndView mav=new ModelAndView("adminoptions");
			mav.addObject("message","login sucessuful");
			return mav;
		}
		
	}
}
