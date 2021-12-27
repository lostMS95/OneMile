package com.kh.onemile.repository;

import java.util.List;

import com.kh.onemile.entity.commu.CommuDTO;

public interface CommuDao {
	void write(CommuDTO commuDto); //글쓰기
	void withMap(CommuDTO commuDto); //지도를 포함한 글쓰기
	int getSeq(); //시퀀스 가져오기
	boolean changeCommu(CommuDTO commuDto); //수정하기
	boolean hide(String viewYN); //숨김처리
	List<CommuDTO> menuList(String middleName); //게시판 별 목록
	List<CommuDTO> List(); //전체 목록
	CommuDTO get(int commuNo); //상세
}