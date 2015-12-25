package org.gym.dao.impl;

import org.gym.dao.RoleDao;
import org.gym.model.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Long, Role> implements RoleDao {
	
	public RoleDaoImpl() {
		setEntityClass(Role.class);
	}

	@Override
	public Role getRole(String role) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Role r where r.role = :role").setParameter("role", role);
		Role fetchedRole = (Role) query.uniqueResult();
		return fetchedRole;
	}
	
}
