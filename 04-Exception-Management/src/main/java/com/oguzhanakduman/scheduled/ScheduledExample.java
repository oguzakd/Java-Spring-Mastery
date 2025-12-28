package com.oguzhanakduman.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledExample {

	@Scheduled(cron = "*/5 * * * * *")
	public void writeEvery5Second() {
		System.out.println("5 Saniye Geçti");
	}
	
	@Scheduled(cron = "0 44 15 * * *")
	public void write1To10() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}
	
}
