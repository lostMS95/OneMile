package com.kh.onemile.repository;

import com.kh.onemile.entity.miles.board.MilesBoardReplyDTO;

public interface MilesBoardReplyDao {
	void write(MilesBoardReplyDTO milesBoardReplyDto);
	int getSeq();
}
