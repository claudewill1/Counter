package com.springboot.claude.controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController extends HttpServlet {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		int count = 0;
		if(session.getAttribute("count") == null) {
			session.setAttribute("count",count++);
		}
		else 
		{
			int counter = (int)session.getAttribute("count");
			counter++;
			session.setAttribute("count", counter);
		}
		return "index.jsp";
	}
	
	

	@RequestMapping("/counter")
	public String counter(Model model, HttpSession session) {
		Integer currCount = (Integer)session.getAttribute("count");
		if(currCount == null) {
			model.addAttribute("current",0);
		} else {
			model.addAttribute("current",currCount);
		}
		return "counter.jsp";
		
	}
	
	@RequestMapping("/counter2")
	public String counter2(Model model, HttpSession session) {
		Integer curCount = (Integer)session.getAttribute("count");
		if(curCount == null) {
			model.addAttribute("current",0);
		} else {
			model.addAttribute("current",curCount+1);
		}
		return "counter2.jsp";
	}
	
	/*
	 * An attempt to redirect back to the page the reset button was pressed on
	@RequestMapping("/reset")
	public String reset(HttpServletRequest request, HttpSession session) {
		String redirectUrl = "";
		if(request.getRequestURL().toString().contains("/counter")) {
			session.setAttribute("current", 0);
			redirectUrl = "redirect:/counter";
		} else if (request.getRequestURL().toString().contains("/counter2")) {
			session.setAttribute("current", 0);
			redirectUrl = "redirect:/counter2";
		}
		return redirectUrl;
	} */
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/";
	}
}
