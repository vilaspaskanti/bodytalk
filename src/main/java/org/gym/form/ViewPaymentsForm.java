package org.gym.form;

public class ViewPaymentsForm extends AttendanceForm {
	
	private String fromDate;
	private String toDate;
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(final String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(final String toDate) {
		this.toDate = toDate;
	}
	
}
