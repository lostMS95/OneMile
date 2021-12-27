package com.kh.onemile.repository;

import com.kh.onemile.entity.map.MapDTO;

public interface MapDao {
	void insert(MapDTO mapDto);
	int getSeq();
	boolean change(MapDTO mapDto);
	MapDTO get(int mapNo);
}
