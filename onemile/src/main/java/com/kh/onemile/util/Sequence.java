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
	
	public int getSequence(String seq_name) {
		int seqNum = sqlSession.update("seq.get", seq_name);
		int numSeq = seqNum + 1;
		System.out.println(seqNum);
//		Map<String, Object> updateValue = new HashMap<String, Object>();
//		updateValue.put("key", seq_name);
//		updateValue.put("value", numSeq);
		
		return seqNum;
	}
}
