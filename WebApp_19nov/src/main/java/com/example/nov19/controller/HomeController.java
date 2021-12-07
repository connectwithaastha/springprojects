package com.example.nov19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.nov19.dao.AlienRepo;
//import com.example.nov19.dao.AlienRepo;
import com.example.nov19.model.Alien;
import com.example.nov19.service.AlienService;

@Controller
public class HomeController {
	@Autowired
	AlienRepo repo;
	@Autowired
	AlienService service;

	@RequestMapping("/home")
	public ModelAndView home(Alien alien) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("obj", alien);
		//mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home";
	}
	@RequestMapping("/deleteAlien")
	public String deleteAlien(@RequestParam int aid) {
		//int id = alien.getAid();
		repo.deleteById(aid);
		return "home";
	}
	@RequestMapping("/getAlien")
	public ModelAndView addAlien(@RequestParam int aid) {
		Alien a = repo.findById(Integer.valueOf(aid)).orElse(new Alien());
		ModelAndView mv = new ModelAndView("showAlien");
		mv.addObject("a",a);
		//mv.setViewName("showAlien");
		return mv;
	}

	/*
	 * @GetMapping({"/", "/home"}) public String home(Model model) {
	 * 
	 * model.addAttribute("name", "Aastha");
	 * 
	 * return "home";
	 * 
	 * }
	 * 
	 * @GetMapping({"/", "/login"}) public String login(Model model) {
	 * 
	 * model.addAttribute("errorMessage", "Aastha");
	 * 
	 * return "login";
	 * 
	 * }
	 */
}
