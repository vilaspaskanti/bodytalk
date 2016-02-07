package org.gym.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date date;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "member_id", nullable = false)
	private GymUser gymUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public GymUser getGymUser() {
		return gymUser;
	}

	public Attendance(final Date date,final GymUser gymUser) {
		super();
		this.date = date;
		this.gymUser = gymUser;
	}

	public Attendance() {
		super();
	}
	
}
