package org.gym.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.gym.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-Context.xml"})
@Transactional
public class UserTest {
	
	@Autowired
	UserService userService;
	DateFormat dt =  new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
	
	
	/*@Test*/
	@Rollback(value=false)
	public void testUser() {
		GymUser user = new GymUser();
		user.setFirstName("Vilas");
		user.setAddress("Bhiwandi");
		user.setAge(25);
		user.setIsActive(true);
		user.setWayOfContact("9768781677");
		userService.saveUser(user);
		 		
	}
	/*@Test*/
	@Rollback(value=false)
	public void testRegistration() {
	
		GymUser user = userService.getUserCode(1L);
		Registration r = new Registration();
		r.setGymUser(user);
		r.setExpiryDate(new Date(2015, 12, 1));
		r.setStartDate(new Date());
		r.setPackageCost(5000.0);
		Payment p = new Payment();
		p.setPaymentAmount(1000.0);
		p.setPaymentDate(new Date());
		p.setRegistration(r);
		userService.saveRegistration(r);
		userService.createPaymentTransaction(p);
	}
	
	/*@Test*/
	@Rollback(value=false)
	public void testFetchRegistration() {
		
		GymUser user = new GymUser();
		user.setFirstName("Manges");
		user.setAddress("Thane");
		user.setAge(26);
		user.setIsActive(true);
		user.setWayOfContact("9920068896");
		userService.saveUser(user);
		Registration r = new Registration();
		r.setGymUser(user);
		r.setExpiryDate(new Date(2016, 1, 31));
		r.setStartDate(new Date());
		r.setPackageCost(4000.0);
		userService.saveRegistration(r);
		GymUser user2 = userService.getUser(1L);
		List<Registration> r1 = userService.getRegistrations(user2);
		System.out.println(r1.toString());
		List<Payment> payments1 = userService.getPayments(r1.get(0));
		System.out.println(payments1.size());
		List<Payment> payments2 = userService.getPayments(user2);
		System.out.println(payments2.size());
		List<Registration> r3 = userService.getRegistrations(new Date(),new Date());
		System.out.println(r3.toString());
		
		
	}

	@Test
	@Rollback(value=false)
	public void testFetchRegistration2() throws ParseException {
		
		String s1 = "20151110";
		String s2 = "20151113";
		List<Registration> r3 = userService.getRegistrations(dt.parse(s1),dt.parse(s2));
		System.out.println(r3.toString());
		for (Registration registration : r3) {
			System.out.println(registration.getPayments());
		}

	}
	public static void main(final String[] args)
	{
		
	}
}
