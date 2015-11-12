package org.gym.dao;

import java.util.Date;
import java.util.List;

import org.gym.model.GymUser;
import org.gym.model.Registration;

public interface RegistrationDao extends GenericDao<Long, Registration> {

	List<Registration> getRegistrations(final GymUser gymUser);
	
	List<Registration> getRegistrations(final Date startDate, final Date endDate);
	
}
