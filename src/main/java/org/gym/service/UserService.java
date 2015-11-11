package org.gym.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.gym.model.Attendance;
import org.gym.model.GymPackage;
import org.gym.model.GymUser;
import org.gym.model.Payment;
import org.gym.model.Registration;

public interface UserService {
	
	public GymUser saveUser(GymUser user);
	
	public Registration saveRegistration(Registration registration);
	
	public Attendance saveAttendence(final Attendance registration);
	
	public Payment createPaymentTransaction(final Payment transaction);
	
	public GymPackage createPackage(final GymPackage gymPackage);
	
	public Set<Registration> getRegistrations(final GymUser gymUser);
	
	public Set<Registration> getRegistrations(final Date startDate, final Date endDate);
	
	public Set<Payment> getPayments(final Registration registration);
	
	public Set<Payment> getPayments(final GymUser gymUser);
	
	public BigDecimal getBalanceDue(final GymUser gymUser);
	
	public Date getNextDueDate(final GymUser gymUser);
	
	public void expireRegistration(final Registration registration);
	
	public void checkMemberValid(final GymUser gymUser);
	
	
}
