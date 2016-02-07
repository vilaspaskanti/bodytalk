package org.gym.dao.impl;

import java.util.Date;
import java.util.List;

import org.gym.dao.UserDao;
import org.gym.model.Attendance;
import org.gym.model.GymUser;
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
	
	@Override
	public List<Attendance> getAttendance(String phoneNo, Date fromDate, Date toDate){
		
		final Criteria cr = sessionFactory.getCurrentSession().createCriteria(Attendance.class);
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
}
