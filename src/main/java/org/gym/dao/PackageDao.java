package org.gym.dao;

import java.util.List;

import org.gym.model.GymPackage;

public interface PackageDao extends GenericDao<Long, GymPackage> {

	List<GymPackage> getPackages();
	
	List<GymPackage> getPackageAjax(final String name);
	
	GymPackage getPackages(final String name);
 	
}
