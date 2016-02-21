package org.gym.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GymLogInterceptor {
	
	@Pointcut("execution(* org.gym.service.impl.UserServiceImpl.*(..))")
	public void logGymTransactions() {
		
	}
	
	@Around("logGymTransactions()")
	public Object gymLogger(ProceedingJoinPoint jointPoint) throws Throwable {
		
		Object result = null;
		String execution = "SUCCESS";
		
		System.out.println("Additional Concern Before calling actual method");
		try {
		result = jointPoint.proceed();
		execution = "FAILED";
		} catch(Exception e) {
			throw e;
		} finally {
			
		}
		
        System.out.println("Additional Concern After calling actual method");  
		
		return result;
	}
	
}
