package org.gym.model;

import java.util.Date;
import java.util.List;

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
public class RegistrationTest {
	
	@Autowired
	UserService userService;
	
	@Test
	@Rollback(value=true)
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
		List<Payment> payments = userService.getPayments(r1.get(0));
		System.out.println(payments.size());
	}
	
}
