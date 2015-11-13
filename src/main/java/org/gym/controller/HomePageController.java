package org.gym.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {

	@RequestMapping(value="/welcome",method = RequestMethod.GET)
	public String helloWorld(Model model) {
		model.addAttribute("hello","YOLO");
		return "enquiry";
	}
	
}
