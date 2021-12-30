package com.kh.onemile.repository.product;

import com.kh.onemile.entity.product.MembershipBuyDTO;

public interface MembershipBuyDao {
	//정기결제 내역 DB에 저장
	void insert(MembershipBuyDTO membershipBuyDTO);
	
	//멤버십 종료일 비교하기
	void dayCheck(MembershipBuyDTO membershipBuyDTO);
	
}
