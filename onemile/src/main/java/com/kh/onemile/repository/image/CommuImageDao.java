package com.kh.onemile.repository.image;

import com.kh.onemile.entity.image.CommuImageDTO;

public interface CommuImageDao {
	void regCmi(CommuImageDTO commuImageDto);
	int getSeq();
	CommuImageDTO get(int cmiNo);
}