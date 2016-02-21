package org.gym.service;

import org.gym.model.Audit;

public interface AuditService {
	
	public void logAudit(Audit auditRecord);
	
}
