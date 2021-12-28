package com.kh.onemile.repository.image;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.onemile.entity.image.CommuImageDTO;
import com.kh.onemile.repository.image.CommuImageDao;
@Repository
public class CommuImageDaoImpl implements CommuImageDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void regCmi(CommuImageDTO commuImageDto) {
		sqlSession.insert("commuImage.insert", commuImageDto);
	}

	@Override
	public int getSeq() {
		int seq = sqlSession.selectOne("commuImage.sequence");
		return seq;
	}

	@Override
	public CommuImageDTO get(int cmiNo) {
		return sqlSession.selectOne("commuImage.get", cmiNo);
	}
}

