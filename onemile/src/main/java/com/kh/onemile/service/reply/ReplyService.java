package com.kh.onemile.service.reply;

import java.util.List;

import com.kh.onemile.vo.ReplyVO;

public interface ReplyService {
	public void write(ReplyVO replyVo);
	public List<ReplyVO> listByBoardNo(int boardNo);
}
