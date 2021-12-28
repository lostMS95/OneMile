package com.kh.onemile.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kh.onemile.vo.MemberJoinVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SetDefaut {

	public String setMemberCoronaDefault(String corona) {
		return (corona!="")?"Y":"N";
	}
}
