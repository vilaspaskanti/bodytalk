package org.gym.dao.impl;

import org.gym.dao.AuditDao;
import org.gym.model.Audit;
import org.springframework.stereotype.Repository;

@Repository
public class AuditDaoImpl extends GenericDaoImpl<Long, Audit> implements AuditDao {
	
	public AuditDaoImpl() {
		setEntityClass(Audit.class);
	}
	
}
