package org.gym.dao.impl;

import org.gym.dao.AttendenceDao;
import org.gym.model.Attendance;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceDaoImpl extends GenericDaoImpl<Long, Attendance> implements AttendenceDao {

	public AttendanceDaoImpl() {
		setEntityClass(Attendance.class);
	}
}
