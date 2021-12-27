package com.kh.onemile.repository.image;

import com.kh.onemile.entity.image.CommuImageDTO;

public interface CommuImageDao {
	void insert(CommuImageDTO commuImageDto);
	int getSeq();
}
