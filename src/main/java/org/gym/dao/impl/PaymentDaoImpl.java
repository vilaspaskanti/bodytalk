package org.gym.dao.impl;

import java.util.Date;
import java.util.List;

import org.gym.dao.PaymentDao;
import org.gym.model.GymUser;
import org.gym.model.Payment;
import org.gym.model.Registration;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl extends GenericDaoImpl<Long, Payment> implements PaymentDao {
	
	@Override
	public Payment  fetchEntityById(final Long id) {
		setEntityClass(Payment.class);
		return super.fetchEntityById(id);
	}

	@Override
	public List<Payment> getPayments(GymUser gymUser) {

		String hql = " FROM Payment P JOIN P.registration r JOIN r.gymUser g WITH (g.id = :member_id)";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("member_id",gymUser.getId());
		List<Payment> results = query.list();
		return results;
	}

	@Override
	public List<Payment> getPayments(Registration registration) {
		String hql = " FROM Payment P JOIN P.registration R WITH (R.id=:registration_id) ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("registration_id",registration.getId());
		List<Payment> results = query.list();
		return results;
	}

	@Override
	public List<Payment> getPayments(Date payDate) {
		
		String hql = " FROM Payment P Where P.startDate = :payDate ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("payDate",payDate);
		List<Payment> results = query.list();
		return results;
	}

	@Override
	public List<Payment> getPayments(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}
}
