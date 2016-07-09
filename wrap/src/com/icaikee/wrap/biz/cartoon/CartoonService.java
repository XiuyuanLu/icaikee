package com.icaikee.wrap.biz.cartoon;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.icaikee.wrap.biz.cartoon.dto.CartoonInfoDto;
import com.icaikee.wrap.biz.cartoon.model.CartoonInfo;
import com.icaikee.wrap.db.hibernate.HibernateDao;

@Service
public class CartoonService {

	@Autowired
	private HibernateDao dao;

	@Transactional
	public void saveCartoonInfo(CartoonInfoDto cartoonInfoDto, MultipartFile img) {
		CartoonInfo cartoon = new CartoonInfo();
		cartoon.setDate(new Date());
		cartoon.setName(cartoonInfoDto.getCartoonName());
		cartoon.setChapterId(cartoonInfoDto.getChapterId());

		String fileName = img.getName();
		String filePath = CartoonInfo.LOCAL_IMG_PATH + cartoon.getChapterId() + cartoon.getName()
				+ fileName.substring(fileName.lastIndexOf(".") + 1);
		cartoon.setUrl(filePath);
		// ×ª´æÎÄ¼þ
		try {
			img.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		dao.save(cartoon);
	}

}
