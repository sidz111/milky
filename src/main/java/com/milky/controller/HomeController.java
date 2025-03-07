package com.milky.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.milky.entity.Milk;
import com.milky.entity.Order;
import com.milky.entity.User;
import com.milky.service.MilkService;
import com.milky.service.OrderService;
import com.milky.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private MilkService milkService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String homePage() {
        return "index";
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

    @GetMapping("/product")
    public String productPage(
        @RequestParam(value = "name", required = false, defaultValue = "Guest") String name,
        @RequestParam(value = "address", required = false, defaultValue = "Unknown") String address,
        @RequestParam(value = "litre", required = false, defaultValue = "1") Double litre,
        RedirectAttributes redirectAttributes
    ) {
        User u = new User();
        u.setName(name);
        u.setAddress(address);
        User savedUser = userService.saveUser(u);

        Milk m = new Milk();
        m.setLitre(litre);
        Milk savedMilk = milkService.saveMilk(m);

        Order o = new Order();
        o.setIsConfirmed(false);
        o.setMilk(savedMilk);
        o.setTime(new Date().toString());
        o.setUser(savedUser);
        orderService.saveOrder(o);

        return "product";
    }
    
    

}
