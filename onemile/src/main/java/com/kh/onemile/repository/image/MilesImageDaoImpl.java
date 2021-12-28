package com.kh.onemile.repository.image;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.onemile.entity.image.MilesImageDTO;

public class MilesImageDaoImpl implements MilesImageDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void regMi(MilesImageDTO milesImageDto) {
		sqlSession.insert("mi.regImage", milesImageDto);
	}

	@Override
	public boolean deleteImage(int miNo) {
		int count = sqlSession.delete("mi.deleteImage", miNo);
		return count > 0;
	}
}
