package com.kh.onemile.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.onemile.entity.map.MapDTO;
@Repository
public class MapDaoImpl implements MapDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(MapDTO mapDto) {
		sqlSession.insert("map.insert", mapDto);
	}

	@Override
	public int getSeq() {
		int seq = sqlSession.selectOne("map.sequence");
		return seq;
	}

	@Override
	public boolean change(MapDTO mapDto) {
		int count = sqlSession.update("map.change",mapDto);
		return count > 0;
	}

	@Override
	public MapDTO get(int mapNo) {
		return sqlSession.selectOne("map.get", mapNo);
	}
}
