package org.gym.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.gym.form.AddPackageForm;
import org.gym.form.AttendanceForm;
import org.gym.form.EnquiryForm;
import org.gym.form.GymPackageForm;
import org.gym.form.MemberRegisterForm;
import org.gym.form.MemberRegistrationForm;
import org.gym.form.ValidationReponseForm;
import org.gym.form.ViewAttendanceForm;
import org.gym.model.Attendance;
import org.gym.model.Constants;
import org.gym.model.GymPackage;
import org.gym.model.GymPackageAjax;
import org.gym.model.GymUser;
import org.gym.model.Payment;
import org.gym.model.Registration;
import org.gym.model.Role;
import org.gym.service.PackageService;
import org.gym.service.RoleService;
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
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PackageService packageService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	private EnquiryForm defaultEnquiryModel() {
		EnquiryForm enquiryForm = new EnquiryForm();
		enquiryForm.setSex("M");
		enquiryForm.setWayOfContact("Newspaper");
		return enquiryForm;
	}

	private EnquiryForm defaultRegistrationModel() {
		MemberRegistrationForm memberRegistrationForm = new MemberRegistrationForm();
		memberRegistrationForm.setSex("M");
		memberRegistrationForm.setWayOfContact("Newspaper");
		return memberRegistrationForm;
	}

	private AttendanceForm defaultAttendanceModel() {
		final AttendanceForm attendanceForm = new AttendanceForm();
		return attendanceForm;
	}

	private ViewAttendanceForm defaultViewAttendanceModel() {
		final ViewAttendanceForm viewAttendanceForm = new ViewAttendanceForm();
		return viewAttendanceForm;
	}

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(Model model) {
		model.addAttribute("enquiryForm", defaultEnquiryModel());
		model.addAttribute("page", "enquiry");
		return "admin/enquiry";
	}

	@RequestMapping(value = "/saveEnquiry", method = RequestMethod.POST)
	public String saveEnquiry(@ModelAttribute("enquiryForm") @Valid EnquiryForm enquiryForm,
			BindingResult bindingResult, Model model) {

		model.addAttribute("page", "enquiry");
		if (bindingResult.hasErrors()) {
			model.addAttribute("enquiryForm", enquiryForm);
			return "admin/enquiry";
		} else {
			GymUser gymEnquirer = new GymUser();

			DozerBeanMapper mapper = new DozerBeanMapper();
			mapper.map(enquiryForm, gymEnquirer);

			Role role = roleService.getRole(Constants.GYM_ENQUIRER);
			gymEnquirer.setRole(role);

			userService.saveUser(gymEnquirer);
			model.addAttribute("success", "success");
		}

		return "admin/enquiry";
	}

	@RequestMapping(value = "/fetchMemberEnquiryData", method = RequestMethod.GET)
	public String fetchMemberEnquiryData(Model model, @RequestParam(name = "phoneno") String phoneNo) {

		GymUser gymUser = userService.getUserByPhoneNo(phoneNo);

		MemberRegistrationForm memberRegistrationForm = new MemberRegistrationForm();
		if (gymUser != null) {
			DozerBeanMapper mapper = new DozerBeanMapper();
			mapper.map(gymUser, memberRegistrationForm);
			memberRegistrationForm.setGymUserId(gymUser.getId());
			model.addAttribute("memberRegistrationForm", memberRegistrationForm);
		} else {
			model.addAttribute("memberRegistrationForm", defaultRegistrationModel());
		}

		List<GymPackage> arrlPackages = packageService.getAllPackages();
		Map<String, String> packages = new HashMap<String, String>();

		for (GymPackage gymPackage : arrlPackages) {
			packages.put(gymPackage.getCode(), gymPackage.getName());
		}

		model.addAttribute("packageList", packages);

		return "ajax/memberRegistrationForm";
	}

	@RequestMapping(value = "/memberRegisterHome", method = RequestMethod.GET)
	public String registerHome(Model model) {

		List<GymPackage> arrlPackages = packageService.getAllPackages();
		Map<String, String> packages = new HashMap<String, String>();

		for (GymPackage gymPackage : arrlPackages) {
			packages.put(gymPackage.getCode(), gymPackage.getName());
		}

		model.addAttribute("page", "registration");
		model.addAttribute("packageList", packages);
		model.addAttribute("memberRegistrationForm", defaultRegistrationModel());
		return "admin/memberRegistration";
	}

	@RequestMapping(value = "/saveMemberRegistration", method = RequestMethod.POST)
	public String saveMemberRegistration(
			@ModelAttribute("memberRegistrationForm") @Valid MemberRegistrationForm memberRegistrationForm,
			BindingResult bindingResult, Model model) throws ParseException {

		
		model.addAttribute("page", "registration");
		if (bindingResult.hasErrors()) {
			model.addAttribute("memberRegistrationForm", memberRegistrationForm);
		} else {
			GymUser gymUser = null;
			DozerBeanMapper mapper = new DozerBeanMapper();

			if (memberRegistrationForm.getGymUserId() != null) {
				gymUser = userService.getUser(memberRegistrationForm.getGymUserId());
			} else {
				gymUser = userService.getUserByPhoneNo(memberRegistrationForm.getPhoneNo());
				if (gymUser == null) {
					gymUser = new GymUser();
				}
			}

			// populate user meta data
			mapper.map(memberRegistrationForm, gymUser);

			// populate packages, fees, and member registration
			Role role = roleService.getRole(Constants.GYM_MEMBER);
			gymUser.setRole(role);

			String packages[] = memberRegistrationForm.getPackages().split(",");
			Registration registration = new Registration();
			Payment payment = new Payment();
			Set<GymPackage> packagesSet = new HashSet<GymPackage>();
			GymPackage pkg = null;

			for (String packageCode : packages) {
				pkg = packageService.getPackageByCode(packageCode);
				packagesSet.add(pkg);
			}

			// payments.add(payment);

			registration.setPackages(packagesSet);
			registration.setStartDate(formatter.parse(memberRegistrationForm.getStartDate()));
			registration.setExpiryDate(formatter.parse(memberRegistrationForm.getExpiryDate()));
			// registration.setPayments(payments);

			BigDecimal balanceDue = BigDecimal.valueOf(Double.valueOf(memberRegistrationForm.getFees())
					- Double.valueOf(memberRegistrationForm.getAmountPaid()));

			registration.setBalanceDue(balanceDue);
			registration.setPackageCost(Double.valueOf(memberRegistrationForm.getFees()));
			registration.setGymUser(gymUser);
			userService.saveRegistration(registration);

			payment.setPaymentAmount(Double.parseDouble(memberRegistrationForm.getAmountPaid()));
			payment.setPaymentDate(new Date());
			payment.setRegistration(registration);
			userService.createPaymentTransaction(payment);

			// registrations.add(registration);
			// gymUser.setRegistrations(registrations);

			userService.updateUser(gymUser);
			model.addAttribute("success", "success");
		}

		List<GymPackage> arrlPackages = packageService.getAllPackages();
		Map<String, String> packages = new HashMap<String, String>();

		for (GymPackage gymPackage : arrlPackages) {
			packages.put(gymPackage.getCode(), gymPackage.getName());
		}

		model.addAttribute("packageList", packages);

		return "admin/memberRegistration";
	}

	/*
	 * @RequestMapping(value="/memberRegisterSubmit",method =
	 * RequestMethod.POST) public String
	 * registerUser(@ModelAttribute("memberRegister") @Valid MemberRegisterForm
	 * memberForm, BindingResult bindingResult,Model model) {
	 * 
	 * 
	 * model.addAttribute("page", "registration"); if(bindingResult.hasErrors())
	 * {
	 * 
	 * return "admin/memberRegister"; } //We can use BeanUtils.copyProperties
	 * method instead GymUser user = new GymUser();
	 * user.setFirstName(memberForm.getFirstName());
	 * user.setAddress(memberForm.getAddress());
	 * user.setEmailId(memberForm.getEmail()); userService.saveUser(user);
	 * model.addAttribute("message", "User Registered succesfully");
	 * model.addAttribute("memberId", user.getId()); return
	 * "admin/memberRegister"; }
	 */
	@RequestMapping(value = "/packageRegisterHome", method = RequestMethod.POST)
	public String registerPackage(@ModelAttribute("packageRegister") @Valid MemberRegisterForm memberForm,
			BindingResult bindingResult, Model model) {

		model.addAttribute("page", "registration");
		if (bindingResult.hasErrors()) {

			return "admin/memberRegister";
		}
		// We can use BeanUtils.copyProperties method instead
		GymUser user = new GymUser();
		user.setFirstName(memberForm.getFirstName());
		user.setAddress(memberForm.getAddress());
		user.setEmailId(memberForm.getEmail());
		userService.saveUser(user);
		model.addAttribute("message", "User Registered succesfully");
		model.addAttribute("memberId", user.getId());
		return "admin/memberRegister";
	}

	@RequestMapping(value = "/gymPackageHome", method = RequestMethod.GET)
	public String packageHome(Model model) {
		model.addAttribute("page", "utilities");
		return "admin/gymPackage";
	}

	@RequestMapping(value = "/addEditPackages", method = RequestMethod.POST)
	public String registerPackage(@ModelAttribute("gymPackage") @Valid GymPackageForm memberForm,
			BindingResult bindingResult, Model model) {

		model.addAttribute("page", "gymPackage");
		if (bindingResult.hasErrors()) {
			return "admin/gymPackage";
		}
		GymPackage gymPackage = new GymPackage(memberForm);
		gymPackage = userService.saveOrUpdatePackage(gymPackage);
		model.addAttribute("message", "Package Updated succesfully : " + gymPackage.getId());
		return "admin/gymPackage";
	}

	@RequestMapping(value = "/getPackagesAjax", method = RequestMethod.GET)
	public @ResponseBody List<GymPackageAjax> getTags(@RequestParam String term) {
		List<GymPackage> p = userService.getPackages(term);
		List<GymPackageAjax> p1 = new ArrayList<GymPackageAjax>();
		for (GymPackage gymPackage : p) {
			p1.add(new GymPackageAjax(gymPackage));
		}
		return p1;
	}
	
	@RequestMapping(value="/addPackageRegistration",method = RequestMethod.GET)
	public String addPackageRegistration(Model model) {
		
		model.addAttribute("page","addPackage");
		
		return "admin/editRegistration";
	}
	
	@RequestMapping(value="/addPackage",method = RequestMethod.GET)
	public String addPackage(Model model, @RequestParam(name = "phoneno") String phoneNo) {
		
		GymUser gymUser = userService.getUserByPhoneNo(phoneNo);
		
		if(gymUser != null && gymUser.getRole().getRole().equalsIgnoreCase(Constants.GYM_MEMBER)) {
			Set<Registration> registrations = gymUser.getRegistrations();
			 
			List<GymPackage> arrlPackages = packageService.getAllPackages();
			Map<String,String> packages = new HashMap<String,String>();
			
			for(GymPackage gymPackage : arrlPackages) {
				packages.put(gymPackage.getCode(), gymPackage.getName());
			}
			
			AddPackageForm addPackageForm = new AddPackageForm();
			addPackageForm.setFirstName(gymUser.getFirstName());
			addPackageForm.setLastName(gymUser.getLastName());
			addPackageForm.setGymUserId(gymUser.getId());
			
			model.addAttribute("packageList",packages);
			model.addAttribute("userFound",true);
			model.addAttribute("registrations",registrations);
			model.addAttribute("addPackageForm",addPackageForm);
			model.addAttribute("formatter",formatter);
		} else {
			model.addAttribute("userFound",false);
		}
		
		return "ajax/addRegistration";
	}

	@RequestMapping(value = "/showAttendance", method = RequestMethod.GET)
	public String showAttendancePage(Model model) {

		model.addAttribute("attendanceForm", defaultAttendanceModel());
		model.addAttribute("page", "attendance");
		model.addAttribute("message", "");
		return "admin/attendance";
	}
	
	@RequestMapping(value = "/registerAttendance", method = RequestMethod.POST)
	public String registerAttendance(@ModelAttribute("attendanceForm") @Valid AttendanceForm attendanceForm,
			BindingResult bindingResult, Model model) {

		model.addAttribute("page", "attendance");
		if (bindingResult.hasErrors()) {
			model.addAttribute("attendanceForm", attendanceForm);
			return "admin/attendance";
		} else {

			final GymUser gymUser = userService.getUserByPhoneNo(attendanceForm.getPhoneNo());
			if (gymUser == null || (gymUser != null && !gymUser.hasValidRegistration())) {
				System.out.println("Gym User not found");
				model.addAttribute("message", "User not valid");
				return "admin/attendance";
			}
			final Attendance attendance = new Attendance(new Date(), gymUser);
			userService.saveAttendence(attendance);
			model.addAttribute("message", "Attendence registered successfully.");
			return "admin/attendance";
		}
	}
	
	@RequestMapping(value = "/viewAttendancePage", method = RequestMethod.GET)
	public String viewAttendancePage(Model model) {

		model.addAttribute("viewAttendanceForm", defaultViewAttendanceModel());
		model.addAttribute("page", "viewAttendance");
		model.addAttribute("message", "");
		return "admin/viewAttendance";
	}

	
	@RequestMapping(value = "/viewAttendance", method = RequestMethod.POST)
	public String viewAttendance(@ModelAttribute("viewAttendanceForm") @Valid ViewAttendanceForm viewAttendanceForm,
			BindingResult bindingResult, Model model) throws ParseException {

		
		model.addAttribute("page", "viewAttendance");
		if (bindingResult.hasErrors()) {
			System.out.println("Bibding result "+bindingResult.getAllErrors());
			model.addAttribute("viewAttendanceForm", viewAttendanceForm);
			return "admin/viewAttendance";
		} else {

			System.out.println(viewAttendanceForm.getPhoneNo()); 
			System.out.println(viewAttendanceForm.getFromDate());
			System.out.println(viewAttendanceForm.getToDate());
			final Date startDate = viewAttendanceForm.getFromDate().isEmpty()?null:formatter.parse(viewAttendanceForm.getFromDate()); 
			final Date endDate = viewAttendanceForm.getToDate().isEmpty()?null:formatter.parse(viewAttendanceForm.getToDate()); 
			final List<Attendance> attendanceList = userService.getAttendance(viewAttendanceForm.getPhoneNo(), 
					startDate,
					endDate);
			System.out.println(attendanceList.size());
			model.addAttribute("attendanceList", attendanceList);
			return "admin/viewAttendance";
			}
	}
	
	@RequestMapping(value = "/saveAddPackage", method = RequestMethod.POST)
	public @ResponseBody ValidationReponseForm saveAddPackage(@ModelAttribute("addPackageForm") @Valid AddPackageForm addPackageForm,
			BindingResult bindingResult, Model model) throws ParseException {

		ValidationReponseForm validationResponse = new ValidationReponseForm();
		
		model.addAttribute("page", "addPackage");
		
		GymUser gymUser = userService.getUser(addPackageForm.getGymUserId());
		
		validationResponse.setIdentifier(gymUser.getPhoneNo());
		
		String packages[] = addPackageForm.getPackages().split(",");
		Registration registration = new Registration();
		Payment payment = new Payment();
		Set<GymPackage> packagesSet = new HashSet<GymPackage>();
		GymPackage pkg = null;

		for (String packageCode : packages) {
			pkg = packageService.getPackageByCode(packageCode);
			packagesSet.add(pkg);
		}

		// payments.add(payment);

		registration.setPackages(packagesSet);
		registration.setStartDate(formatter.parse(addPackageForm.getStartDate()));
		registration.setExpiryDate(formatter.parse(addPackageForm.getExpiryDate()));
		// registration.setPayments(payments);

		BigDecimal balanceDue = BigDecimal.valueOf(Double.valueOf(addPackageForm.getFees())
				- Double.valueOf(addPackageForm.getAmountPaid()));

		registration.setBalanceDue(balanceDue);
		registration.setPackageCost(Double.valueOf(addPackageForm.getFees()));
		registration.setGymUser(gymUser);
		userService.saveRegistration(registration);

		payment.setPaymentAmount(Double.parseDouble(addPackageForm.getAmountPaid()));
		payment.setPaymentDate(new Date());
		payment.setRegistration(registration);
		userService.createPaymentTransaction(payment);

		userService.updateUser(gymUser);
		
		validationResponse.setStatus("SUCCESS");
		
		return validationResponse;
	}
}
