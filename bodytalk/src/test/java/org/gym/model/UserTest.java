package org.gym.model;

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
	
	@Test
	@Rollback(value=false)
	public void testUser() {
		GymUser user = new GymUser();
		user.setFirstName("Mangesh");
		
		userService.saveUser(user);
	}
	
}
