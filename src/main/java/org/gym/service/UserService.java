package org.gym.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.gym.model.Attendance;
import org.gym.model.GymPackage;
import org.gym.model.GymUser;
import org.gym.model.Payment;
import org.gym.model.Registration;

public interface UserService {
	
	public GymUser saveUser(GymUser user);
	
	public GymUser getUser(Long memberId);
	
	public GymUser getUserByPhoneNo(String phoneNo);
	
	public GymUser getUserCode(Long memberCode);
	
	public Registration saveRegistration(Registration registration);
	
	public Registration updateRegistration(Registration registration);
	
	public Attendance saveAttendence(final Attendance registration);
	
	public Payment createPaymentTransaction(final Payment transaction);
	
	public GymPackage saveOrUpdatePackage(final GymPackage gymPackage);
	
	public List<GymPackage> getPackages(final String name);
	
	public List<Registration> getRegistrations(final GymUser gymUser);
	
	public List<Registration> getRegistrations(final Date startDate, final Date endDate);
	
	public Registration getRegistration(final Long registrationId );
	
	public List<Payment> getPayments(final Registration registration);
	
	public List<Payment> getPayments(final GymUser gymUser);
	
	public BigDecimal getBalanceDue(final GymUser gymUser);
	
	public Date getNextDueDate(final GymUser gymUser);
	
	public void expireRegistration(final Registration registration);
	
	public void checkMemberValid(final GymUser gymUser);

	public GymUser updateUser(final GymUser gymUser);
	
	public List<Attendance> getAttendance(final String phoneNo, final Date fromDate ,final Date toDate);
	
	public List<Payment> getPayments(final String phoneNo, final Date fromDate ,final Date toDate);
	
}
