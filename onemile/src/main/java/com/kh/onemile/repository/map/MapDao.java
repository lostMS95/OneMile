package com.kh.onemile.repository.map;

import com.kh.onemile.entity.map.MapDTO;

public interface MapDao {
	void insert(MapDTO mapDto);
	int getSeq();
}
