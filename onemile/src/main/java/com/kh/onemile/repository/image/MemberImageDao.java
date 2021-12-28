package com.kh.onemile.repository.image;

import com.kh.onemile.entity.image.MemberImageDTO;

public interface MemberImageDao {
	void regMi(MemberImageDTO memberImageDTO);
	MemberImageDTO get(int meiNo);
	boolean deleteImage(int meiNo);
}