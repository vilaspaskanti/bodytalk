package org.gym.service.impl;

import org.gym.dao.AuditDao;
import org.gym.model.Audit;
import org.gym.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl implements AuditService {
	
	@Autowired
	AuditDao auditDao;

	@Override
	public void logAudit(Audit auditRecord) {
		auditDao.save(auditRecord);
		
	}
	
}
