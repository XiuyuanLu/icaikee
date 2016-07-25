package com.icaikee.wrap.biz.review;

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
import com.icaikee.wrap.biz.review.model.ReviewBlog;
import com.icaikee.wrap.db.hibernate.HibernateDao;
import com.icaikee.wrap.web.controller.WebConstants;

@Service
public class ReviewBlogService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private HibernateDao dao;

	@Autowired
	private AddressConfig addressConfig;

	public ReviewBlog getSingleBlogByTitle(String title) {
		return dao.findUnique(ReviewBlog.class, "select x from ReviewBlog x where x.blogTitle=?", title);
	}

	public List<ReviewBlog> getBlogs() {
		return dao.find(ReviewBlog.class, "select x from ReviewBlog x ");
	}

	@Transactional
	public String uploadIndex(String title, MultipartFile index) {

		try {
			if (ImageIO.read(index.getInputStream()) == null) {
				logger.info("not img");
				return "not img";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (title == null || title == "")
			return WebConstants.FAILURE;

		ReviewBlog blog = getSingleBlogByTitle(title);
		if (blog == null)
			return WebConstants.FAILURE;

		String indexAddrSave = addressConfig.getBlogIndexSaveAddress();
		String indexAddrRead = addressConfig.getBlogIndexReadAddress();

		String indexFileName = index.getOriginalFilename();

		String indexFilePath = indexAddrSave + "bi-" + title + "."
				+ indexFileName.substring(indexFileName.lastIndexOf(".") + 1);
		String indexUrl = indexAddrRead + "bi-" + title + "."
				+ indexFileName.substring(indexFileName.lastIndexOf(".") + 1);

		blog.setBlogCoverUrl(indexUrl);
		try {
			index.transferTo(new File(indexFilePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		} catch (IOException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		}

		dao.save(blog);

		return WebConstants.SUCCESS;
	}

	@Transactional
	public String publish(String title, String author, String content) {

		ReviewBlog blog = getSingleBlogByTitle(title);
		if (blog != null)
			return "±ÍÃ‚÷ÿ∏¥";

		blog = new ReviewBlog();
		blog.setBlogTitle(title);
		blog.setBlogAuthor(author);
		blog.setBlogContent(content);
		blog.setBlogUpdateTime(new Date());

		dao.save(blog);
		return WebConstants.SUCCESS;
	}

	@Transactional
	public String uploadImg(MultipartFile img) {

		try {
			if (ImageIO.read(img.getInputStream()) == null) {
				logger.info("not img");
				return "not img";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String addrSave = addressConfig.getBlogImgsSaveAddress();
		String fileName = img.getOriginalFilename();
		String indexFilePath = addrSave + fileName;

		try {
			img.transferTo(new File(indexFilePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		} catch (IOException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		}

		return WebConstants.SUCCESS;
	}

}
