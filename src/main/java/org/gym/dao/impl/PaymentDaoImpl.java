package org.gym.dao.impl;

import java.util.Date;
import java.util.List;

import org.gym.dao.PaymentDao;
import org.gym.model.Attendance;
import org.gym.model.GymUser;
import org.gym.model.Payment;
import org.gym.model.Registration;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl extends GenericDaoImpl<Long, Payment> implements PaymentDao {
	
	public PaymentDaoImpl() {
		setEntityClass(Payment.class);
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
		
		final Criteria cr = sessionFactory.getCurrentSession().createCriteria(Payment.class);
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			cr.add(Restrictions.eq("registration", registration));
		cr.addOrder(Order.asc("id"));
		List<Payment> results = cr.list();
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
