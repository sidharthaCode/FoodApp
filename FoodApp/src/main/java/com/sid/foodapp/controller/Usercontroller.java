package com.sid.foodapp.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sid.foodapp.dao.UserDao;
import com.sid.foodapp.enities.Admin;
import com.sid.foodapp.enities.User;

@Controller
public class Usercontroller
{
	@Autowired
	UserDao userdao;
	
	
	@RequestMapping("/adduser")
	public ModelAndView addUser()
	{
		ModelAndView mav=new ModelAndView("createuser");
		User user=new User();
		mav.addObject("user",user);
		return mav;
		
	}
	
	@RequestMapping("/saveuser")
	public ModelAndView saveUser(@ModelAttribute("user")User u)
	{
		ModelAndView mav = new ModelAndView("loginuser");
		
		userdao.saveuser(u);

		return mav;
	}
	
	@RequestMapping("/validateuser")
	public ModelAndView Loginvalidation(ServletRequest req,HttpSession session)
	
	{
		 String email=req.getParameter("email");
		 String password=req.getParameter("password");
		 User user= userdao.login(email, password);
		 
		 if(user==null)
		 {
             ModelAndView mav=new ModelAndView("loginuser");
			 
			 mav.addObject("massage","invalid credentails");
			 return mav;
			
			 
		 }
		 
		 else {
			 ModelAndView mav=new ModelAndView("useroption");
				session.setAttribute("user",user);
				return mav;
		}
		
	}
	

}
