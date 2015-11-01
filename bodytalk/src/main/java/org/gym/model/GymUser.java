package org.gym.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
public class GymUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String phoneNo;
	
	@Email
	private String emailId;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="GYMUSER_PACKAGE",
	joinColumns=@JoinColumn(name="gymuser_id",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="package_id",referencedColumnName="id"))
	private Set<Package> packages;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Payment> payments;
	
	@OneToMany
	private Set<Attendance> attendance;
	
	private String wayOfContact;
	
	private Integer age;
	
	@Length(max=1)
	private String sex;
	
	@OneToOne
	private Role role;
	
	private Date gymStartDate;
	
	private Date gymEndDate;
	
	private Double fee;
	
	private Boolean isActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Set<Package> getPackages() {
		return packages;
	}

	public void setPackages(Set<Package> packages) {
		this.packages = packages;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public Set<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(Set<Attendance> attendance) {
		this.attendance = attendance;
	}

	public String getWayOfContact() {
		return wayOfContact;
	}

	public void setWayOfContact(String wayOfContact) {
		this.wayOfContact = wayOfContact;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getGymStartDate() {
		return gymStartDate;
	}

	public void setGymStartDate(Date gymStartDate) {
		this.gymStartDate = gymStartDate;
	}

	public Date getGymEndDate() {
		return gymEndDate;
	}

	public void setGymEndDate(Date gymEndDate) {
		this.gymEndDate = gymEndDate;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
