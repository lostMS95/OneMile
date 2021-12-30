package com.kh.onemile.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kh.onemile.repository.certi.CertiDao;
import com.kh.onemile.repository.product.MembershipBuyDao;
import com.kh.onemile.service.kakaopay.KakaoPayService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private CertiDao certiDao;
	
	@Autowired
	private MembershipBuyDao membershipBuyDao;
	
	@Autowired
	private KakaoPayService kakaopayService;
	
	//이메일 인증번호(누적된 DB) 삭제 스케줄러
	@Scheduled(cron = "0 0 9 * * *")//매일 오전 9시
	@Override
	public void execute() {
		log.debug("DB 스케줄러 테스트중");
		certiDao.clean();
	}
	//select  * from msb where buy_endtime <= sysdate;
	//정기결제 결제일검사 스케줄러()
	@Scheduled(cron = "0 0 0 * * *")//매일 오전12시에 검사함
	@Override
	public void regularPayment() {
//		membershipBuyDao.dayCheck();
		
	}
}