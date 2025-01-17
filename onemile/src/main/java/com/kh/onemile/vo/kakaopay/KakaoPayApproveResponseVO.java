package com.kh.onemile.vo.kakaopay;

import lombok.Data;

@Data
public class KakaoPayApproveResponseVO {
	private String aid;//요청 고유 번호
	private String tid;//결제 고유 번호
	private String cid;//가맹점 코드
	private String sid;//정기 결제용 ID
	private String partner_order_id;//가맹점 주문번호
	private String partner_user_id;//가맹점 회원 ID
	private String payment_method_type;//결제 수단(CARD/MONEY)
	private Amount amount;//결제 금액 정보
	private CardInfo card_info;//결제 상세 정보(카드일 경우)
	private String item_name;//상품 이름
	private String item_code;//상품 코드
	private int quantity;//상품 수량
	private String created_at;
	private String approved_at;
	private String payload;
}
