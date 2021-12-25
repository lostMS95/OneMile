package com.kh.onemile.repository;

import com.kh.onemile.entity.miles.board.MilesBoardDTO;

public interface MilesBoardDao {
	void write(MilesBoardDTO milesBoardDto);
	int getSeq();
}
