package org.gym.dao.impl;

import org.gym.dao.UserDao;
import org.gym.model.GymUser;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<Long, GymUser> implements UserDao {

	@Override
	public GymUser fetchEntityById(Long id) {
		setEntityClass(GymUser.class);
		return super.fetchEntityById(id);
	}
}
