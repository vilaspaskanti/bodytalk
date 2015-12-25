package org.gym.form;

import javax.validation.constraints.Size;

import org.dozer.Mapping;

public class EnquiryForm {
	
	@Mapping
	private String firstName;
	
	@Mapping
	private String lastName;
	
	@Mapping
	private String phoneNo;
	
	@Mapping
	@Size(min=1,max=2)
	private String age;
	
	@Mapping
	private String emailId;
	
	@Mapping
	private String sex;
	
	@Mapping
	private String wayOfContact;
	
	@Mapping
	private String address;

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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWayOfContact() {
		return wayOfContact;
	}

	public void setWayOfContact(String wayOfContact) {
		this.wayOfContact = wayOfContact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
