package com.kh.onemile.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class Sequence {
	@Autowired
	private SqlSession sqlSession;
	//시퀀스 가져오기(읽기 전용)
	public int getSequence(String seq_name) {
		int seqNum = sqlSession.update("seq.get", seq_name);
		
		return seqNum;
	}
	//시퀀스 조회  & 증가하는 조회
	public int joinSequence(String seq_name) {
		int seqNum = sqlSession.update("seq.get", seq_name);
		increaseSequence(seq_name, seqNum);
	
		return seqNum;
	}
	//시퀀스 증가 메서드
	public int increaseSequence(String seq_name,int seqNum) {
		
		Map<String, Object> updateValue = new HashMap<String, Object>();
		updateValue.put("seq_name", seq_name);
		updateValue.put("seq_no", ++seqNum);
		sqlSession.update("seq.increase",updateValue);
		return seqNum;
	}
}
