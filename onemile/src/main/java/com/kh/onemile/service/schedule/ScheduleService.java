package com.kh.onemile.service.schedule;

public interface ScheduleService {
	//이메일 스케줄러
	void execute();
	//멤버십 정기결제 스케줄러
	void regularPayment();
}
