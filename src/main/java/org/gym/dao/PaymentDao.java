package org.gym.dao;

import java.util.Date;
import java.util.List;

import org.gym.model.GymUser;
import org.gym.model.Payment;
import org.gym.model.Registration;

public interface PaymentDao extends GenericDao<Long, Payment> {
	
	List<Payment> getPayments(final GymUser gymUser);
	
	List<Payment> getPayments(final Registration registration);

	List<Payment> getPayments(final Date payeDate);
	
	List<Payment> getPayments(final Date startDate, final Date endDate);


}
