package org.gym.controller;
import javax.validation.Valid;

import org.gym.form.MemberRegisterForm;
import org.gym.model.GymUser;
import org.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@ContextConfiguration(locations = {"classpath:app-Context.xml"})
@Controller
public class HomePageController {

	@Autowired
	UserService service;
	@RequestMapping(value="/memberRegisterHome",method = RequestMethod.GET)
	public String registerHome(Model model) {
		model.addAttribute("page","registration");
		return "admin/memberRegister";
	}
	
	@RequestMapping(value="/memberRegisterSubmit",method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("memberRegister") @Valid MemberRegisterForm memberForm, BindingResult bindingResult,Model model) {
		
	
		model.addAttribute("page", "registration");
		if(bindingResult.hasErrors())
		{
			
			return "admin/memberRegister";
		}
		//We can use BeanUtils.copyProperties method instead
		GymUser user = new GymUser();
		user.setFirstName(memberForm.getFirstName());
		user.setAddress(memberForm.getAddress());
		user.setEmailId(memberForm.getEmail());
		service.saveUser(user);
		model.addAttribute("message", "User Registered succesfully");
		model.addAttribute("memberId", user.getId());
		return "admin/memberRegister";
	}
}
