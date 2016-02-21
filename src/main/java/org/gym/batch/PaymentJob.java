package org.gym.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PaymentJob {
	
	@Scheduled(cron="${cron.paymentjob}")
	public void paymentJob() {
		//System.out.println("Job running :)");
	}
	
}
