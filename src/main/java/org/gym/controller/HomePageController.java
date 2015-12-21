package org.gym.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.gym.form.GymPackageForm;
import org.gym.form.MemberRegisterForm;
import org.gym.model.GymPackage;
import org.gym.model.GymPackageAjax;
import org.gym.model.GymUser;
import org.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomePageController {

	@Autowired
	UserService service;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String showHome(Model model) {
		return "admin/enquiry";
	}
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
	@RequestMapping(value="/packageRegisterHome",method = RequestMethod.POST)
	public String registerPackage(@ModelAttribute("packageRegister") @Valid MemberRegisterForm memberForm, BindingResult bindingResult,Model model) {
		
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
	@RequestMapping(value="/gymPackageHome",method = RequestMethod.GET)
	public String packageHome(Model model) {
		model.addAttribute("page","utilities");
		return "admin/gymPackage";
	}
	@RequestMapping(value="/addEditPackages",method = RequestMethod.POST)
	public String registerPackage(@ModelAttribute("gymPackage") @Valid GymPackageForm memberForm, BindingResult bindingResult,Model model) {
		
		model.addAttribute("page", "gymPackage");
		if(bindingResult.hasErrors())
		{
			return "admin/gymPackage";
		}
		GymPackage gymPackage = new GymPackage(memberForm);
		gymPackage = service.saveOrUpdatePackage(gymPackage);
		model.addAttribute("message", "Package Updated succesfully : "+gymPackage.getId());
		return "admin/gymPackage";
	}
	@RequestMapping(value = "/getPackagesAjax", method = RequestMethod.GET)
	public @ResponseBody
	List<GymPackageAjax> getTags(@RequestParam String term) {
		List<GymPackage> p= service.getPackages(term);
		List<GymPackageAjax> p1= new ArrayList<GymPackageAjax>();
		for (GymPackage gymPackage : p) {
			p1.add(new GymPackageAjax(gymPackage));
		}
		return p1;
	}
}
