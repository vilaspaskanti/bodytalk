package org.gym.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
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

}
