package com.kh.onemile.repository;

import com.kh.onemile.entity.commu.CommuDTO;

public interface CommuDao {
	void write(CommuDTO commuDto);
	void withMap(CommuDTO commuDto);
	int getSeq();
	boolean change(CommuDTO commuDto);
	boolean hide(String viewYN);
}
