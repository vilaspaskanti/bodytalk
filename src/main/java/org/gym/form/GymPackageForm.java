package org.gym.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GymPackageForm {

	@NotNull
	@Size(min=1,max=30)
	private String name;
	@NotNull
	@Size(min=1,max=100)
	private String description;
	@NotNull
	private String code;
	private Long id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "GymPackageForm [name=" + name + ", description=" + description + ", code=" + code + ", id=" + id + "]";
	}
}
