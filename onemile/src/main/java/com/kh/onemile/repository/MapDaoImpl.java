package com.kh.onemile.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.onemile.entity.map.MapDTO;

public class MapDaoImpl implements MapDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert(MapDTO mapDto) {
		sqlSession.insert("map.insert", mapDto);
	}

}
