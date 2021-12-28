package com.kh.onemile.repository.commu;

import java.util.List;

import com.kh.onemile.entity.commu.CommuDTO;

public interface CommuDao {
	void write(CommuDTO commuDto);
	boolean hide(String viewYN);
	List<CommuDTO> menuList(String middleName);
	List<CommuDTO> List();
	CommuDTO detail(int commuNo);
	boolean changeCommu(CommuDTO commuDto);
}
