package com.kh.onemile.service.commu;

import java.io.IOException;

import com.kh.onemile.vo.CommuVO;

public interface CommuService {
	public void write(CommuVO commuVo) throws IllegalStateException, IOException;
	public boolean change(CommuVO commuVo);
	public boolean hide(String viewYN);
}
