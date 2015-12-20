package org.gym.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.gym.form.GymPackageForm;

@Entity
public class GymPackage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String code;
	
	private String name;
	
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "packages")
	private Set<Registration> registrations = new HashSet<Registration>(0);

	public GymPackage() {
		super();
	}
	public Set<Registration> getRegistrations() {
		return this.registrations;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public GymPackage(final GymPackageForm form) {
		super();
		this.id = form.getId();
		this.code = form.getCode();
		this.name = form.getName();
		this.description = form.getDescription();
	}
		
}
