package org.gym.model;

public class GymPackageAjax {

	private Long id;
	
	private String name;
	
	public GymPackageAjax() {
		super();
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

	public GymPackageAjax(final GymPackage form) {
		super();
		this.id = form.getId();
		this.name = form.getName();
	}
	@Override
	public String toString() {
		return "GymPackageAjax [id=" + id + ", name=" + name + "]";
	}
		
}
