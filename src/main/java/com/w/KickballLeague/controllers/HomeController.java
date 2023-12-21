package com.w.KickballLeague.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.w.KickballLeague.models.LoginUser;
import com.w.KickballLeague.models.User;
import com.w.KickballLeague.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
  
	// Add once service is implemented:
    @Autowired
    private UserService userService;
    
    
   //display login/register page 
   @GetMapping("/")
   public String index(Model model) {

       model.addAttribute("newUser", new User());
       model.addAttribute("newLogin", new LoginUser());
       return "index.jsp";
   }
   //register a user
   @PostMapping("/register")
   public String register(@Valid @ModelAttribute("newUser") User newUser, 
           BindingResult result, Model model, HttpSession session) {
         	userService.register(newUser, result);
       
       if(result.hasErrors()) {
           model.addAttribute("newLogin", new LoginUser());
           return "index.jsp";
       }
       
       else {
       	session.setAttribute("user_id", newUser.getId());
       }
   
       return "redirect:/home";
   }
   
   //log in
   @PostMapping("/login")
   public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
           BindingResult result, Model model, HttpSession session) {
       User user = userService.login(newLogin, result);
   
       if(result.hasErrors()) {
           model.addAttribute("newUser", new User());
           return "index.jsp";
       }

       else {
       	session.setAttribute("user_id", user.getId());
       }
       return "redirect:/home";
   }
   
   //log out
   @GetMapping("/logout")
   public String logout(HttpSession session) {
	   session.invalidate();
  	 return "redirect:/";
   }

   
}


