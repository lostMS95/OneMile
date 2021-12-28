package com.kh.onemile.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Component
@Slf4j
public class SequenceOrigin {
	@Autowired
	private SqlSession sqlSession;
	//시퀀스 가져오기(읽기 전용)
	public int getSequence(String seq_name) {
		int currentSeqNum = sqlSession.selectOne("seq.getNow", seq_name);
		
		return currentSeqNum;
	}
	//시퀀스 증가
	public int nextSequence(String seq_name) {
		int nextSeqNum = sqlSession.selectOne("seq.getAuto", seq_name);
		
		return nextSeqNum;
	}

	//시퀀스 가져오기(읽기 전용)
	public int getSequence2(String seq_name) {

		int currentSeqNum = sqlSession.selectOne("seq.getNext2", seq_name);
		
		return currentSeqNum;
	}
	//시퀀스 증가
	public int nextSequence2(String seq_name,String seq) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("seq_name", seq_name);
		map.put("seq_id", seq);
		int currentSeqNum = sqlSession.update("seq.getNow2", map);
		
		return currentSeqNum;
	}


}
