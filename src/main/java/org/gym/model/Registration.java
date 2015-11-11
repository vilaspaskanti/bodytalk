package org.gym.model;

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
	@Column(name="registration_id")
	private Long id;
	
	private Double packageCost;
	private Date expiryDate;
	private Date startDate;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "member_id", nullable = false)
	private GymUser gymUser;

/*	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="REGISTRATION_PACKAGE",
	joinColumns=@JoinColumn(name="registration_id",referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="package_id",referencedColumnName="id"))
	private Set<GymPackage> packages;
*/
	
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="registration")
	private Set<Payment> payments;


}
