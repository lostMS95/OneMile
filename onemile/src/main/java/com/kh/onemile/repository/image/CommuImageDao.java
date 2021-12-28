package com.kh.onemile.repository.image;

import org.springframework.stereotype.Repository;
import com.kh.onemile.entity.image.CommuImageDTO;

public interface CommuImageDao {
	void regCmi(CommuImageDTO commuImageDto);
	CommuImageDTO get(int cmiNo);
	boolean deleteImage(int cmiNo);
}