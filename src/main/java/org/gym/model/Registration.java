package org.gym.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "registration_id")
	private Long id;

	private Double packageCost;
	private Date expiryDate;
	private Date startDate;
	private BigDecimal balanceDue;
	private String status;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "REGISTRATION_PACKAGE", joinColumns = {
			@JoinColumn(name = "registration_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "package_id", nullable = false, updatable = false) })
	private Set<GymPackage> packages;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id", nullable = false)
	private GymUser gymUser;

	public Set<GymPackage> getPackages() {
		return packages;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "registration")
	private Set<Payment> payments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(Double packageCost) {
		this.packageCost = packageCost;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setPackages(Set<GymPackage> packages) {
		this.packages = packages;
	}

	public GymUser getGymUser() {
		return gymUser;
	}

	public void setGymUser(GymUser gymUser) {
		this.gymUser = gymUser;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public BigDecimal getBalanceDue() {
		return balanceDue;
	}

	public void setBalanceDue(BigDecimal balanceDue) {
		this.balanceDue = balanceDue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", packageCost=" + packageCost + ", expiryDate=" + expiryDate + ", startDate="
				+ startDate + ", gymUser=" + gymUser.getFirstName() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balanceDue == null) ? 0 : balanceDue.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((gymUser == null) ? 0 : gymUser.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((packageCost == null) ? 0 : packageCost.hashCode());
		result = prime * result + ((packages == null) ? 0 : packages.hashCode());
		result = prime * result + ((payments == null) ? 0 : payments.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
