package org.gym.dao.impl;

import java.util.Date;
import java.util.List;

import org.gym.dao.UserDao;
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
	
	private List<Registration> getRegistrations(String phoneNo) {

		final Criteria cr = sessionFactory.getCurrentSession().createCriteria(Registration.class);
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if(!phoneNo.isEmpty() )
		{
			GymUser user = getUserByPhoneNo(phoneNo);
			cr.add(Restrictions.eq("gymUser", user));
		}
		final List<Registration> registrationList = cr.list();
		System.out.println(" registrationList.size " +registrationList.size());
		return registrationList;
	}
	
	@Override
	public List<Attendance> getAttendance(String phoneNo, Date fromDate, Date toDate){
		
		final Criteria cr = sessionFactory.getCurrentSession().createCriteria(Attendance.class);
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		if(!phoneNo.isEmpty() )
		{
			final GymUser user = getUserByPhoneNo(phoneNo);
			cr.add(Restrictions.eq("gymUser", user));
		}
		if(fromDate !=null )
		{
			cr.add(Restrictions.ge("date", fromDate));
		}
		if(toDate !=null )
		{
			cr.add(Restrictions.le("date", toDate));
		}
		cr.addOrder(Order.asc("date"));
		final List<Attendance> attendanceList = cr.list();
		System.out.println(" attendanceList.size " +attendanceList.size());
		return attendanceList;
	}
	@Override
	public List<Payment> getPayments(final String phoneNo,final Date fromDate,final Date toDate){
		
		final Criteria cr = sessionFactory.getCurrentSession().createCriteria(Payment.class);
		cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		final List<Registration> registrationList = getRegistrations(phoneNo);
		cr.add(Restrictions.in("registration", registrationList));
		if(fromDate !=null )
		{
			cr.add(Restrictions.ge("paymentDate", fromDate));
		}
		if(toDate !=null )
		{
			cr.add(Restrictions.le("paymentDate", toDate));
		}
		cr.addOrder(Order.desc("id"));
		final List<Payment> paymentList = cr.list();
		System.out.println(" paymentList.size " +paymentList.size());
		return paymentList;
	}
}
