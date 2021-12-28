package com.kh.onemile.util;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;


@Transactional
@Component
@Slf4j
public class Sequence {
	@Autowired
	private SqlSession sqlSession;

	//시퀀스 가져오기(읽기 전용)
	public int getSequence(String seq_id) {

		int currentSeqNum = sqlSession.selectOne("seq.getNow", seq_id);
		
		return currentSeqNum;
	}
	//시퀀스 증가
	public int nextSequence(String seq_id) {

		int nextSeqNum = sqlSession.selectOne("seq.getNext", seq_id);
		log.debug("  nextSeqNum   "+ nextSeqNum);
		return nextSeqNum;
	}


}
