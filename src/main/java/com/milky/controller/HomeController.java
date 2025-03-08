package com.milky.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.milky.entity.DairyProduct;
import com.milky.entity.Milk;
import com.milky.entity.Order;
import com.milky.entity.User;
import com.milky.repository.DairyProductRepository;
import com.milky.repository.MilkRepository;
import com.milky.repository.UserRepository;
import com.milky.service.MilkService;
import com.milky.service.OrderService;
import com.milky.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	DairyProductRepository dairyProductRepository;
	
	@Autowired
	UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MilkService milkService;
    
    @Autowired
    MilkRepository milkRepository;

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String homePage() {
        return "index";
    }
    
    @GetMapping("/product-page")
    public String productPage() {
        return "product";
    }
    
    @GetMapping("/login-page")
    public String logInPage() {
    	return "login";
    }
    
    @PostMapping("/add-user")
    public String registernewUser(@RequestParam("name") String name,
    		@RequestParam("address") String address,
    		@RequestParam("email") String email,
    		@RequestParam("password") String password,
    		@RequestParam("contactNo") String contactNo
    		) {
    	User u = new User();
    	u.setRole("ROLE_USER");
    	u.setName(name);
    	u.setAddress(address);
    	u.setEmail(email);
    	u.setPassword(passwordEncoder.encode(password));
    	u.setContactNo(contactNo);
    	userService.saveUser(u);
    	return "login";
    }

    @GetMapping("/get-product")
    public String productPage(
        @RequestParam(value = "litre", required = false, defaultValue = "1") Double litre,
        RedirectAttributes redirectAttributes
    ) {
        // Get the authenticated user
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email);
        
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "User not found. Please login again.");
            return "redirect:/login";
        }

        // Create & save Milk object
        Milk milk = new Milk();
        milk.setLitre(litre);
        milk = milkRepository.save(milk);

        // Create Order
        Order order = new Order();
        order.setIsConfirmed(false);
        order.setTime(new Date().toString());
        order.setUser(user);  // Assign user
        order.setMilk(milk);  // Assign milk

        // Save Order
        orderService.saveOrder(order);

        redirectAttributes.addFlashAttribute("success", "Order placed successfully!");
        return "redirect:/";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @GetMapping("/get-dairy-product")
    public String getDairyproductPage(
        @RequestParam(value = "quantity", required = false, defaultValue = "1") Double quantity,
        @RequestParam("name") String name,
        RedirectAttributes redirectAttributes
    ) {
        // Get the authenticated user
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email);
        
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "User not found. Please login again.");
            return "redirect:/login";
        }

        
        DairyProduct dairyProduct = new DairyProduct();
        dairyProduct.setQuantity(quantity);
        dairyProduct.setName(name);
        dairyProduct = dairyProductRepository.save(dairyProduct);

        // Create Order
        Order order = new Order();
        order.setIsConfirmed(false);
        order.setTime(new Date().toString());
        order.setUser(user);  // Assign user
        order.setDairyProduct(dairyProduct);

        Milk milk = new Milk();
        milk = milkRepository.save(milk);
        order.setMilk(milk);
        
        orderService.saveOrder(order);

        redirectAttributes.addFlashAttribute("success", "Order placed successfully!");
        return "redirect:/";
    }

}
