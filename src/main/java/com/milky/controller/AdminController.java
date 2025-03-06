package com.milky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.milky.entity.Order;
import com.milky.service.OrderService;

@Controller
@RequestMapping("admins")
public class AdminController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("orders")
	public String orderPage(Model model) {
		model.addAttribute("orders", orderService.getAllOrders());
		return "orders";
	}
	
	 @PostMapping("/confirm-order/{id}")
	    public String confirmOrder(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
	        orderService.confirmOrder(id);
	        redirectAttributes.addFlashAttribute("successMessage", "Order #" + id + " confirmed successfully!");
	        return "redirect:/orders";
	    }
}
