package org.gym.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.gym.dao.AttendenceDao;
import org.gym.dao.PackageDao;
import org.gym.dao.PaymentDao;
import org.gym.dao.RegistrationDao;
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
	@Autowired
	RegistrationDao registrationDao;
	@Autowired
	PaymentDao paymentDao;
	@Autowired
	AttendenceDao attendenceDao;
	@Autowired
	PackageDao packageDao;

	@Override
	public GymUser saveUser(GymUser user) {
		System.out.println("New User added");
		return userDao.save(user);
	}
	
	@Override
	public GymUser getUser(Long memberId) {
		return userDao.fetchEntityById(memberId);
	}

	@Override
	public Registration saveRegistration(Registration registration) {

		return registrationDao.save(registration); 
	}

	@Override
	public Attendance saveAttendence(final Attendance attendence) {

		return attendenceDao.save(attendence);
	}

	@Override
	public Payment createPaymentTransaction(final Payment transaction) {

		return paymentDao.save(transaction);
	}

	@Override
	public GymPackage saveOrUpdatePackage(final GymPackage gymPackage) {
		if(gymPackage.getId()!=null )
		return packageDao.update(gymPackage);
		else
		return packageDao.save(gymPackage);
	}

	@Override
	public List<Registration> getRegistrations(final GymUser gymUser) {

		return registrationDao.getRegistrations(gymUser);
	}

	@Override
	public List<Registration> getRegistrations(Date startDate, Date endDate) {

		return registrationDao.getRegistrations(startDate,endDate);	
	}

	@Override
	public List<Payment> getPayments(final Registration registration) {
		return paymentDao.getPayments(registration);	
	}

	@Override
	public List<Payment> getPayments(final GymUser gymUser) {

		return paymentDao.getPayments(gymUser);	
	}

	@Override
	public BigDecimal getBalanceDue(GymUser gymUser) {
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

	@Override
	public GymUser getUserCode(Long memberCode) {

		return userDao.fetchEntityById(memberCode);
	}

	@Override
	public List<GymPackage> getPackages(final String packageName) {

			return packageDao.getPackageAjax(packageName);
	}

	@Override
	public GymUser getUserByPhoneNo(final String phoneNo) {
		return userDao.getUserByPhoneNo(phoneNo);
	}

	@Override
	public GymUser updateUser(GymUser gymUser) {
		return userDao.update(gymUser);
	}

	@Override
	public List<Attendance> getAttendance(String phoneNo, Date fromDate, Date toDate) {

		return userDao.getAttendance(phoneNo, fromDate ,toDate);
	}
}
