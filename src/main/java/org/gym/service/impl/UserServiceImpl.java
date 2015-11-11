package org.gym.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.gym.dao.UserDao;
import org.gym.model.Attendance;
import org.gym.model.GymPackage;
import org.gym.model.GymUser;
import org.gym.model.Payment;
import org.gym.model.Registration;
import org.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public GymUser saveUser(GymUser user) {
		return userDao.save(user);
	}

	@Override
	public Registration saveRegistration(Registration registration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Attendance saveAttendence(Attendance registration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment createPaymentTransaction(Payment transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GymPackage createPackage(GymPackage gymPackage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Registration> getRegistrations(GymUser gymUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Registration> getRegistrations(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Payment> getPayments(Registration registration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Payment> getPayments(GymUser gymUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getBalanceDue(GymUser gymUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getNextDueDate(GymUser gymUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void expireRegistration(Registration registration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkMemberValid(GymUser gymUser) {
		// TODO Auto-generated method stub
		
	}

	
}
