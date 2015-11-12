package org.gym.dao.impl;

import org.gym.dao.AttendenceDao;
import org.gym.model.Attendance;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceDaoImpl extends GenericDaoImpl<Long, Attendance> implements AttendenceDao {

	@Override
	public Attendance  fetchEntityById(final Long id) {
		setEntityClass(Attendance.class);
		return super.fetchEntityById(id);
	}
}
