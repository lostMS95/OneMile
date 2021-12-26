package com.kh.onemile.repository;

import com.kh.onemile.entity.reply.ReplyDTO;

public interface ReplyDao {
	void write(ReplyDTO replyDto);
	int getSeq();
}
