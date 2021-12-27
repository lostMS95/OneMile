package com.kh.onemile.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.onemile.entity.commu.CommuDTO;
@Repository
public class CommuDaoImpl implements CommuDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(CommuDTO commuDto) {
		sqlSession.insert("commu.write", commuDto);
	}

	@Override
	public int getSeq() {
		int seq = sqlSession.selectOne("commu.sequence");
		return seq;
	}

	@Override
	public boolean change(CommuDTO commuDto) {
		int count = sqlSession.update("commu.change", commuDto);
		return count > 0;
	}

	@Override
	public boolean hide(String viewYN) {
		int count = sqlSession.update("commu.hide", viewYN);
		return count > 0;
	}

	@Override
	public void withMap(CommuDTO commuDto) {
		sqlSession.insert("commu.withMap", commuDto);
	}
}
