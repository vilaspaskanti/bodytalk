package org.gym.util;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.gym.model.Audit;
import org.gym.model.GymUser;
import org.gym.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GymLogInterceptor {
	
	private static final Logger logger = Logger.getLogger(GymLogInterceptor.class);
	
	@Autowired
	private AuditService auditService;
	
	@Pointcut("execution(* org.gym.service.impl.UserServiceImpl.*(..))")
	public void logGymTransactions() {
		
	}
	
	@Around("logGymTransactions()")
	public Object gymLogger(ProceedingJoinPoint jointPoint) throws Throwable {
		
		Object result = null;
		String log = "";
		String execution = "SUCCESS";
		
		String methodSignature = jointPoint.getSignature().toString();
		String args = "";
		for(Object obj : jointPoint.getArgs()) {
			if(obj instanceof GymUser) {
				GymUser gymUser = (GymUser)obj;
				args = args + "[" + gymUser.getId() + "," + gymUser.getPhoneNo() + "]";
			} else {
				args = args + ReflectionToStringBuilder.toString(obj) + ",";
			}
		}
		
		try {
		result = jointPoint.proceed();
		} catch(Exception e) {
			execution = "FAILED";
			throw e;
		} finally {
			log = "Method :" + methodSignature + ", Arguments: " + args + ", Execution: " + execution;
			logger.error(log);
			Audit auditRecord = new Audit();
			auditRecord.setCreatedDate(new Date());
			auditRecord.setLog(log);
			auditService.logAudit(auditRecord);
		}
		
		return result;
	}
	
}
