package org.gym.dao;

import java.util.Date;
import java.util.List;

import org.gym.model.Attendance;
import org.gym.model.GymUser;

public interface UserDao extends GenericDao<Long, GymUser>{

	GymUser getUserByPhoneNo(String phoneNo);
	
	List<Attendance> getAttendance(String phoneNo, Date fromDate, Date toDate);
}
