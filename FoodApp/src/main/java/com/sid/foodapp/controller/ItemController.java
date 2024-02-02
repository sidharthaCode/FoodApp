package com.sid.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sid.foodapp.dao.Productdao;
import com.sid.foodapp.enities.FoodOrder;
import com.sid.foodapp.enities.Item;
import com.sid.foodapp.enities.Product;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ItemController
{
	@Autowired
	Productdao dao;
	
	@RequestMapping("/additem")
	public ModelAndView additem(HttpSession Session ,@RequestParam("id") int id)
	{
		
		
		if(Session.getAttribute("itemlist")==null)
		{
			Session.setAttribute("itemlist", new ArrayList<Item>());
		}

		ModelAndView mav=new ModelAndView("itemform");
		Product p=dao.viewProductById(id);
		Item item=new Item();
		item.setName(p.getName());
		item.setCost(p.getCost());
		item.setType(p.getType());
		
		mav.addObject("itemobj",item);
		
		
		return mav;
	}
	
	@RequestMapping("/additemtofoodorder")
	public ModelAndView additems(@ModelAttribute("itemobj") Item item, HttpSession session)
	{
		
		item.setCost(item.getCost()* item.getQuantity());
            FoodOrder order=(FoodOrder) session.getAttribute("userfoodorder");
            item.setFoodorder(order);
            List<Item> items=(List<Item>) session.getAttribute("itemlist");
            items.add(item);
            ModelAndView mav=new ModelAndView("redirect:/viewallproducts");
            return mav;
            
            }
	

}
