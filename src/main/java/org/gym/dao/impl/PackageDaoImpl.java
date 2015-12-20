package org.gym.dao.impl;

import java.util.List;

import org.gym.dao.PackageDao;
import org.gym.model.GymPackage;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PackageDaoImpl extends GenericDaoImpl<Long, GymPackage> implements PackageDao {
	
	public PackageDaoImpl() {
		setEntityClass(GymPackage.class);
	}

	@Override
	public List<GymPackage> getPackages() {
		final String hql = "FROM GymPackage";
		final Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		final List<GymPackage> results = query.list();
		return results;
	}

	@Override
	public GymPackage getPackages(final String packageName) {
		final String hql = "FROM GymPackage g where g.name = :packageName";
		final Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("packageName", packageName);
		@SuppressWarnings("unchecked")
		final GymPackage gymPackage= (GymPackage) query.uniqueResult();
		return gymPackage;
	}

	@Override
	public List<GymPackage> getPackageAjax(String packageName) {
		final String hql = "FROM GymPackage g where g.name like :packageName";
		final Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("packageName", packageName+"%");
		@SuppressWarnings("unchecked")
		final List<GymPackage> gymPackages=  query.list();
		return gymPackages;
	}

	
	
}
