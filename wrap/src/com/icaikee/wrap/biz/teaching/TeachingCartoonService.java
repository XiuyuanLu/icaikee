package com.icaikee.wrap.biz.teaching;

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
import com.icaikee.wrap.biz.teaching.model.CartoonInfo;
import com.icaikee.wrap.db.hibernate.HibernateDao;
import com.icaikee.wrap.web.controller.WebConstants;

@Service
public class TeachingCartoonService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private HibernateDao dao;

	@Autowired
	private AddressConfig addressConfig;

	@Transactional
	public String saveCartoonInfo(String chapterId, String cartoonName, String author, String description,
			MultipartFile img, MultipartFile index) {

		CartoonInfo ci = getSingleCartoonByChapterId(chapterId);
		if (ci != null)
			return WebConstants.FAILURE;
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
		cartoon.setCartoonUpdateTime(new Date());
		cartoon.setCartoonName(cartoonName);
		cartoon.setCartoonChapterId(chapterId);
		cartoon.setCartoonAuthor(author);
		cartoon.setCartoonDescription(description);

		String fileName = img.getOriginalFilename();

		String indexFileName = index.getOriginalFilename();

		String filePath = addrSave + chapterId + "-" + cartoonName + "."
				+ fileName.substring(fileName.lastIndexOf(".") + 1);
		String url = addrRead + chapterId + "-" + cartoonName + "." + fileName.substring(fileName.lastIndexOf(".") + 1);

		String indexFilePath = indexAddrSave + "i-" + chapterId + "-" + cartoonName + "."
				+ indexFileName.substring(indexFileName.lastIndexOf(".") + 1);
		String indexUrl = indexAddrRead + "i-" + chapterId + "-" + cartoonName + "."
				+ indexFileName.substring(indexFileName.lastIndexOf(".") + 1);

		cartoon.setCartoonUrl(url);
		cartoon.setCartoonIndexUrl(indexUrl);
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
		return dao.findUnique(CartoonInfo.class, "select x from CartoonInfo x where x.cartoonChapterId=?", chapterId);

	}

	@Transactional
	public String updateSingleCartoonByChapterId(String origChapterId, String chapterId, String cartoonName,
			String author, String description) {
		CartoonInfo x = dao.findUnique(CartoonInfo.class, "select x from CartoonInfo x where x.cartoonChapterId=?",
				origChapterId);
		if (x != null) {
			if (!origChapterId.equals(chapterId)) {
				String url = x.getCartoonUrl();
				String indexUrl = x.getCartoonIndexUrl();
				dao.delete(x);
				x = new CartoonInfo();
				x.setCartoonUrl(url);
				x.setCartoonIndexUrl(indexUrl);
			}
			x.setCartoonChapterId(chapterId);
			x.setCartoonName(cartoonName);
			x.setCartoonAuthor(author);
			x.setCartoonDescription(description);
			dao.save(x);
		}
		return WebConstants.SUCCESS;
	}

	@Transactional
	public String deleteSingleCartoonByChapterId(String chapterId) {
		CartoonInfo x = dao.findUnique(CartoonInfo.class, "select x from CartoonInfo x where x.cartoonChapterId=?",
				chapterId);
		if (x != null)
			dao.delete(x);
		return WebConstants.SUCCESS;
	}

	@Transactional
	public String updateImg(String chapterId, MultipartFile img) {

		try {
			if (ImageIO.read(img.getInputStream()) == null) {
				logger.info("not img");
				return "not img";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		CartoonInfo ci = getSingleCartoonByChapterId(chapterId);

		String addrSave = addressConfig.getSaveAddress();
		String addrRead = addressConfig.getReadAddress();

		String fileName = img.getOriginalFilename();

		String filePath = addrSave + chapterId + "-" + ci.getCartoonName() + "."
				+ fileName.substring(fileName.lastIndexOf(".") + 1);
		String url = addrRead + chapterId + "-" + ci.getCartoonName() + "."
				+ fileName.substring(fileName.lastIndexOf(".") + 1);

		ci.setCartoonUrl(url);
		try {
			img.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		} catch (IOException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		}

		dao.save(ci);

		return WebConstants.SUCCESS;
	}

	@Transactional
	public String updateIndex(String chapterId, MultipartFile index) {

		try {
			if (ImageIO.read(index.getInputStream()) == null) {
				logger.info("not img");
				return "not img";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		CartoonInfo ci = getSingleCartoonByChapterId(chapterId);

		String indexAddrSave = addressConfig.getIndexSaveAddress();
		String indexAddrRead = addressConfig.getIndexReadAddress();

		String indexFileName = index.getOriginalFilename();

		String indexFilePath = indexAddrSave + "i-" + chapterId + "-" + ci.getCartoonName() + "."
				+ indexFileName.substring(indexFileName.lastIndexOf(".") + 1);
		String indexUrl = indexAddrRead + "i-" + chapterId + "-" + ci.getCartoonName() + "."
				+ indexFileName.substring(indexFileName.lastIndexOf(".") + 1);

		ci.setCartoonIndexUrl(indexUrl);
		try {
			index.transferTo(new File(indexFilePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		} catch (IOException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		}

		dao.save(ci);

		return WebConstants.SUCCESS;
	}

}
