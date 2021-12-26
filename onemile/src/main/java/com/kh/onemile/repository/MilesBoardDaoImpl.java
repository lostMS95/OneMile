package com.kh.onemile.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.onemile.entity.miles.board.MilesBoardDTO;

public class MilesBoardDaoImpl implements MilesBoardDao{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public void write(MilesBoardDTO milesBoardDto) {
		sqlSession.insert("mb.write",milesBoardDto);
	}

	@Override
	public int getSeq() {
		int seq = sqlSession.selectOne("mb.sequence");
		return seq;
	}
}
