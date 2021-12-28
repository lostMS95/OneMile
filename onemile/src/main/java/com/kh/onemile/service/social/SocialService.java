package com.kh.onemile.service.social;

import java.util.List;

import com.kh.onemile.entity.social.SocialDTO;
import com.kh.onemile.vo.SocialVO;

public interface SocialService {
	public void regSocial(SocialVO socialVo);
	public SocialVO detail(int socialNo);
	public List<SocialDTO> list();
	public void changeSocial(SocialVO socialVo);
}
