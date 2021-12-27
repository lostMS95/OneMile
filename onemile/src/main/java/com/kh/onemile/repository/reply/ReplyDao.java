package com.kh.onemile.repository.reply;

import com.kh.onemile.entity.reply.ReplyDTO;

public interface ReplyDao {
	void write(ReplyDTO replyDto);
	int getSeq();
}
