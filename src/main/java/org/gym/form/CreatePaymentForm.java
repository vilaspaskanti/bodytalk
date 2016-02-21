package org.gym.form;

public class CreatePaymentForm  {
	
	private String registrationId;
	private String amount;
	private String comments;
	private String payDate;
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(final String comments) {
		this.comments = comments;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(final String payDate) {
		this.payDate = payDate;
	}
	
}
