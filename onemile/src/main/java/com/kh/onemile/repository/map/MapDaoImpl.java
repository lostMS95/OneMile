package com.kh.onemile.repository.map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.onemile.entity.map.MapDTO;
@Repository
public class MapDaoImpl implements MapDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert(MapDTO mapDto) {
		sqlSession.insert("map.insert", mapDto);
	}

	@Override
	public int getSeq() {
		int seq = sqlSession.selectOne("map.sequence");
		return seq;
	}
}
