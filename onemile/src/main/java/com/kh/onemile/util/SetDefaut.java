package com.kh.onemile.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.onemile.vo.MemberJoinVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SetDefaut {
	@Autowired
	private MemberJoinVO memberJoinVO;
	public MemberJoinVO setMemberCoronaDefault() {
		if(memberJoinVO.getCorona().equals("")) {
			memberJoinVO.setCorona("N");
		}
		return memberJoinVO;
	}
}
