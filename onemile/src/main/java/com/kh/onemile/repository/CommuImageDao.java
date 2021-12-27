package com.kh.onemile.repository;

import com.kh.onemile.entity.image.CommuImageDTO;

public interface CommuImageDao {
	void insert(CommuImageDTO commuImageDto);
	int getSeq();
}
