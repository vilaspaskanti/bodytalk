package org.gym.dao;

import org.gym.model.GymUser;

public interface UserDao extends GenericDao<Long, GymUser>{

	GymUser getUserByPhoneNo(String phoneNo);

}
