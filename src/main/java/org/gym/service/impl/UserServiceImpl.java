package org.gym.service.impl;

import org.gym.dao.UserDao;
import org.gym.model.GymUser;
import org.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public GymUser saveUser(GymUser user) {
		return userDao.save(user);
	}

	
}
