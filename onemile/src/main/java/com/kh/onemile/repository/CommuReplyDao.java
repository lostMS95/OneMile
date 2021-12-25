package com.kh.onemile.repository;

import com.kh.onemile.entity.commu.CommuReplyDTO;

public interface CommuReplyDao {
	void write(CommuReplyDTO commuReplyDto);
	int getSeq();
}
