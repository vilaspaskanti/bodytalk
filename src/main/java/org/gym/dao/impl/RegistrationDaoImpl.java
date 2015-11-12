package org.gym.dao.impl;

import java.util.Date;
import java.util.List;

import org.gym.dao.RegistrationDao;
import org.gym.model.GymUser;
import org.gym.model.Registration;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationDaoImpl extends GenericDaoImpl<Long, Registration> implements RegistrationDao {
	
	public RegistrationDaoImpl() {
		setEntityClass(Registration.class);
	}

	@Override
	public List<Registration> getRegistrations(final GymUser gymUser) {

		String hql = "FROM Registration R WHERE R.id = :member_id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("member_id",gymUser.getId());
		@SuppressWarnings("unchecked")
		List<Registration> results = query.list();
		return results;
	}

	@Override
	public List<Registration> getRegistrations(Date startDate, Date endDate) {
		String hql = "FROM Registration R WHERE R.startDate between :startDate and :endDate";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("startDate",startDate);
		query.setParameter("endDate",endDate);
		@SuppressWarnings("unchecked")
		List<Registration> results = query.list();
		System.out.println("results.size --- "+results.size());
		return results;
	}
	
	
}
