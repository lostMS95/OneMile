package com.kh.onemile.service.cobuy;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kh.onemile.entity.cobuy.CobuyDTO;
import com.kh.onemile.entity.image.middle.CobuyImgMidDTO;
import com.kh.onemile.repository.cobuy.CobuyDao;
import com.kh.onemile.repository.image.middle.CobuyMidImgDao;
import com.kh.onemile.service.image.ImageService;
import com.kh.onemile.util.Sequence;

@Service
public class CobuyServiceImpl implements CobuyService{
	//파일 저장 폴더
	private final String folderName="/cobuy";
	private final String seqName = "cobuy_seq";
	//시퀀스 이름
	
	@Autowired
	private CobuyDao cobuyDao; // 공동 구매 서비스
	@Autowired
	private ImageService imageService; //이미지 서비스
	@Autowired
	private CobuyMidImgDao middleService; // 이미지 중간 테이블 서비스
	@Autowired
	private Sequence seq;
	
	@Override
	public int reg(CobuyDTO cobuyDTO) throws IllegalStateException, IOException {
		int cbiNo = seq.getSequence(seqName); // 공동구매 상품 번호
		
		cobuyDTO.setCobuyNo(cbiNo);
		//공구 테이블에 등록
		cobuyDao.reg(cobuyDTO);
		List<Integer> imgNoList = imageService.regImage(cobuyDTO.getAttach(), folderName);
		
		//연결 테이블 
		CobuyImgMidDTO cobuyImgMidDTO = new CobuyImgMidDTO();
		
		cobuyImgMidDTO.setImgNoList(imgNoList); //이미지 갯수만큼 넣어 줌
		cobuyImgMidDTO.setCbiNo(cbiNo); // 공구 상품 번호
		
		//중간 이미지 테이블에 등록
		middleService.reg(cobuyImgMidDTO);
		//등록 후 상세페이지로 돌아가기 위해 공구 상품 번호 반환. 
		return cbiNo;
	}

	@Override
	public List<CobuyDTO> getList() {		
		//글 정보 불러오기(이미지는 한장만)
		return cobuyDao.cobuyList(); 
	}

	@Override
	public CobuyDTO getDetail(int cobuyNo) {
		return null;
	}

	@Override
	public void modify(CobuyDTO cobuyDTO) {
		
	}

	@Override
	public void delete() {	
		
	}
	
}
