package com.icaikee.wrap.biz.cartoon;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.icaikee.wrap.biz.cartoon.dto.CartoonInfoDto;
import com.icaikee.wrap.biz.cartoon.model.CartoonInfo;
import com.icaikee.wrap.db.hibernate.HibernateDao;
import com.icaikee.wrap.web.controller.WebConstants;

@Service
public class CartoonService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private HibernateDao dao;

	@Transactional
	public String saveCartoonInfo(CartoonInfoDto cartoonInfoDto, MultipartFile img) {

		try {
			if (ImageIO.read(img.getInputStream()) == null) {
				logger.info("not img");
				return "not img";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		CartoonInfo cartoon = new CartoonInfo();
		cartoon.setDate(new Date());
		cartoon.setName(cartoonInfoDto.getCartoonName());
		cartoon.setChapterId(cartoonInfoDto.getChapterId());

		String fileName = img.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		String filePath = CartoonInfo.LOCAL_IMG_PATH + cartoon.getChapterId() + cartoon.getName() + "."
				+ fileName.substring(fileName.lastIndexOf(".") + 1);
		String url = "http://localhost:8888/img/" + cartoon.getChapterId() + cartoon.getName() + "."
				+ fileName.substring(fileName.lastIndexOf(".") + 1);
		cartoon.setUrl(url);
		cartoon.setSuffix(suffix);
		try {
			img.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		} catch (IOException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		}

		dao.save(cartoon);
		return WebConstants.SUCCESS;
	}

	public List<CartoonInfo> getCartoons() {
		return dao.find(CartoonInfo.class, "select x from CartoonInfo x");
	}

	public CartoonInfo getSingleCartoonByChapterId(String chapterId) {
		return dao.findUnique(CartoonInfo.class, "select x from CartoonInfo x where x.chapterId=?", chapterId);

	}

	@Transactional
	public String updateSingleCartoonByChapterId(String origChapterId, String chapterId, String cartoonName) {
		CartoonInfo x = dao.findUnique(CartoonInfo.class, "select x from CartoonInfo x where x.chapterId=?",
				origChapterId);
		if (x != null) {
			x.setChapterId(chapterId);
			x.setName(cartoonName);
			dao.update(x);
		}
		return WebConstants.SUCCESS;
	}

	@Transactional
	public String deleteSingleCartoonByChapterId(String chapterId) {
		CartoonInfo x = dao.findUnique(CartoonInfo.class, "select x from CartoonInfo x where x.chapterId=?", chapterId);
		if (x != null)
			dao.delete(x);
		return WebConstants.SUCCESS;
	}

}
