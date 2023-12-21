package com.w.KickballLeague.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.w.KickballLeague.models.Team;
import com.w.KickballLeague.models.User;
import com.w.KickballLeague.services.TeamService;
import com.w.KickballLeague.services.UserService;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class TeamController {
	
	@Autowired
	TeamService teamService;
	
	
	@Autowired
	UserService userService;
	
	// ------ READ ALL
	@RequestMapping("/home")
	public String teamsList(@ModelAttribute("team") Team team, Model model, HttpSession session) {
	    Long userId = (Long) session.getAttribute("user_id");
	    if (userId == null) {
	        return "redirect:/";
	    } else {
	        User users = userService.findUser(userId);
	        List<Team> teams = teamService.allTeams();
	        model.addAttribute("user",users );
	        model.addAttribute("teams",teams);
	        return "dashboard.jsp";
	    }
	}

	
	 //display form
    @GetMapping("/teams/new")
	public String addTeam(@ModelAttribute("team") Team team, Model model) {
		return "addTeam.jsp";
	}
	
    //add a new Team

    @PostMapping("/teams/new")
    public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");

        if (userId == null) {
            return "redirect:/"; 
        }

        if (result.hasErrors()) {
            return "addTeam.jsp";
        } else {
            User user = userService.findUser(userId);
            team.setUser(user);
            teamService.createTeam(team);
            return "redirect:/home";
        }
    }

    
    //display one team
    @GetMapping("/teams/{id}")
    public String showTeam(@PathVariable("id") Long id, Model model,HttpSession session) {
    	 Long userId = (Long) session.getAttribute("user_id");
    	 if(userId == null) {
			 return "redirect:/";
		 }
    	else {
    		User user = userService.findUser(userId);
    		Team team = teamService.findTeam(id);
        	model.addAttribute("team", team);
        	model.addAttribute("user", user);
        	
    	 return "showTeam.jsp";
	}
    } 
    
  //edit a team
    @GetMapping("/teams/{id}/edit")
    public String editTeam(Model model, @PathVariable("id") Long id, HttpSession session) {
    	 Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}
    	Team team = teamService.findTeam(id);
    	model.addAttribute("team", team);
    	model.addAttribute("user", userService.findUser(userId));
    	
    	return "editTeam.jsp";
    }
    
    @PutMapping("/teams/{id}/edit")
    public String updateTeam(Model model, @Valid @ModelAttribute("team") Team team, BindingResult result, HttpSession session) {
    	 Long userId = (Long) session.getAttribute("user_id");
    	if(userId == null) {
    		return "redirect:/";
    	}
    	
    	if(result.hasErrors()) {
    		return "editTeam.jsp";
    	}
    	User user = userService.findUser(userId);
        team.setUser(user);
    	teamService.updateTeam(team);
    	
    	return "redirect:/home";
    }




    //delete a team 
    @GetMapping("/teams/delete/{id}")
    public String removeTeam(@PathVariable("id") Long id, HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
        if (userId == null) {
            return "redirect:/";
        }
        else {
           teamService.deleteTeam(id);
        return "redirect:/home";
    }
    }
    

    }

