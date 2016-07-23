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

import com.icaikee.wrap.biz.AddressConfig;
import com.icaikee.wrap.biz.cartoon.model.CartoonInfo;
import com.icaikee.wrap.db.hibernate.HibernateDao;
import com.icaikee.wrap.web.controller.WebConstants;

@Service
public class CartoonService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private HibernateDao dao;

	@Autowired
	private AddressConfig addressConfig;

	@Transactional
	public String saveCartoonInfo(String chapterId, String cartoonName, String author, String description,
			MultipartFile img, MultipartFile index) {

		try {
			if (ImageIO.read(img.getInputStream()) == null || ImageIO.read(index.getInputStream()) == null) {
				logger.info("not img");
				return "not img";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String addrSave = addressConfig.getSaveAddress();
		String addrRead = addressConfig.getReadAddress();
		String indexAddrSave = addressConfig.getIndexSaveAddress();
		String indexAddrRead = addressConfig.getIndexReadAddress();

		CartoonInfo cartoon = new CartoonInfo();
		cartoon.setDate(new Date());
		cartoon.setName(cartoonName);
		cartoon.setChapterId(chapterId);
		cartoon.setAuthor(author);
		cartoon.setDescription(description);

		String fileName = img.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

		String indexFileName = index.getOriginalFilename();

		String filePath = addrSave + chapterId + "-" + cartoonName + "."
				+ fileName.substring(fileName.lastIndexOf(".") + 1);
		String url = addrRead + chapterId + "-" + cartoonName + "." + fileName.substring(fileName.lastIndexOf(".") + 1);

		String indexFilePath = indexAddrSave + "i-" + chapterId + "-" + cartoonName + "."
				+ fileName.substring(indexFileName.lastIndexOf(".") + 1);
		String indexUrl = indexAddrRead + "i-" + chapterId + "-" + cartoonName + "."
				+ fileName.substring(indexFileName.lastIndexOf(".") + 1);

		cartoon.setUrl(url);
		cartoon.setSuffix(suffix);
		cartoon.setIndexUrl(indexUrl);
		try {
			img.transferTo(new File(filePath));
			index.transferTo(new File(indexFilePath));
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
	public String updateSingleCartoonByChapterId(String origChapterId, String chapterId, String cartoonName,
			String author, String description) {
		CartoonInfo x = dao.findUnique(CartoonInfo.class, "select x from CartoonInfo x where x.chapterId=?",
				origChapterId);
		if (x != null) {
			x.setChapterId(chapterId);
			x.setName(cartoonName);
			x.setAuthor(author);
			x.setDescription(description);
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
