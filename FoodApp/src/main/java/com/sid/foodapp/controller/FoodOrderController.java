package com.sid.foodapp.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sid.foodapp.dao.FoodOrderDao;
import com.sid.foodapp.dao.UserDao;
import com.sid.foodapp.enities.FoodOrder;
import com.sid.foodapp.enities.Item;
import com.sid.foodapp.enities.User;

@Controller
public class FoodOrderController
{
	
	@Autowired
	FoodOrderDao dao;
	
	
	@Autowired 
	UserDao uDao;
	
	
	
	
	double totallbill=0;
	
	@RequestMapping("/createorder")
	public ModelAndView createOrder()
	{
		ModelAndView mav=new ModelAndView("createfoodorder");
		
		FoodOrder foodOrder=new FoodOrder();
		mav.addObject("foodorder",foodOrder);
		return mav;
	}
	
	
	@RequestMapping("/savefoodorder")
	public ModelAndView saveFoodOrder(@ModelAttribute("foodorder") FoodOrder order,HttpSession session)
	{
		session.setAttribute("userfoodorder",order);
		ModelAndView mav=new ModelAndView("redirect:/viewallproducts");
		return mav;
		
	}
	
	@RequestMapping("/submitfoodorder")
	public ModelAndView submitFoodOrder(HttpSession session)
	{
		FoodOrder foodOrder=(FoodOrder) session.getAttribute("userfoodorder");
		
		List<Item> items=(List<Item>) session.getAttribute("itemList");
		foodOrder.setItems(items);
		
		items.stream().forEach(i ->  {
			 totallbill=totallbill+i.getCost();
		});
		
		foodOrder.setTotalbill(totallbill);
		
		 User u= (User)session.getAttribute("user");
		 List<FoodOrder> orders=u.getOrders();
		 
		 if(orders.size()>0)
		 {
			 orders.add(foodOrder);
			 foodOrder.setUser(u);
			 u.setOrders(orders);
		 }
		 else {
			List<FoodOrder> orders1=new ArrayList<FoodOrder>();
			orders1.add(foodOrder);
			foodOrder.setUser(u);
			u.setOrders(orders1);
		}
		 dao.savefoodOrder(foodOrder);
		uDao.updateUser(u);
		 
		 
		 
		 ModelAndView mav=new ModelAndView("useroption");
		 return mav;
		
		
		
		
	}

}
