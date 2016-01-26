package org.gym.dao.impl;

import org.gym.dao.UserDao;
import org.gym.model.GymPackage;
import org.gym.model.GymUser;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<Long, GymUser> implements UserDao {

	
	public UserDaoImpl() {
		setEntityClass(GymUser.class);
	}

	@Override
	public GymUser getUserByPhoneNo(String phoneNo) {
		final String hql = "FROM GymUser g where g.phoneNo = :phoneNo";
		final Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("phoneNo", phoneNo);
		@SuppressWarnings("unchecked")
		GymUser gymUser = (GymUser) query.uniqueResult();
		return gymUser;
	}
}
