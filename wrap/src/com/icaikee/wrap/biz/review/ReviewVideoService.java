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
import com.icaikee.wrap.biz.review.model.ReviewVideo;
import com.icaikee.wrap.db.hibernate.HibernateDao;
import com.icaikee.wrap.web.controller.WebConstants;

@Service
public class ReviewVideoService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private HibernateDao dao;

	@Autowired
	private AddressConfig addressConfig;

	@Transactional
	public String upload(String videoName, String videoAuthor, String videoUrl, String videoDescription,
			MultipartFile indexFile) {

		ReviewVideo video = getVideo(videoName);
		if (video != null)
			return "视频名称已存在";

		String indexAddrSave = addressConfig.getRvideoIndexSaveAddress();
		String indexAddrRead = addressConfig.getRvideoIndexReadAddress();
		String indexFileName = indexFile.getOriginalFilename();
		String indexFilePath = indexAddrSave + "ri-" + videoName + "."
				+ indexFileName.substring(indexFileName.lastIndexOf(".") + 1);
		String indexUrl = indexAddrRead + "ri-" + videoName + "."
				+ indexFileName.substring(indexFileName.lastIndexOf(".") + 1);

		video = new ReviewVideo();
		video.setVideoName(videoName);
		video.setVideoAuthor(videoAuthor);
		video.setVideoUrl(videoUrl);
		video.setVideoDescription(videoDescription);
		video.setVideoUploadTime(new Date());
		video.setVideoIndexUrl(indexUrl);
		try {
			indexFile.transferTo(new File(indexFilePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		} catch (IOException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		}
		dao.save(video);
		return WebConstants.SUCCESS;
	}

	public ReviewVideo getVideo(String videoName) {
		return dao.findUnique(ReviewVideo.class, "select x from ReviewVideo x where x.videoName=?", videoName);
	}

	public List<ReviewVideo> getVideos() {
		return dao.find(ReviewVideo.class, "select x from ReviewVideo x");
	}

	@Transactional
	public String updateSingleReviewVideoByName(String origVideoName, String videoName, String videoAuthor,
			String videoUrl, String videoDescription) {
		ReviewVideo video = getVideo(origVideoName);
		if (video != null) {
			if (!origVideoName.equals(videoName)) {
				dao.delete(video);
				video = new ReviewVideo();
			}
			video.setVideoName(videoName);
			video.setVideoAuthor(videoAuthor);
			video.setVideoUrl(videoUrl);
			video.setVideoDescription(videoDescription);
			dao.save(video);
		}
		return WebConstants.SUCCESS;
	}

	@Transactional
	public String deleteSingleReviewVideoByName(String videoName) {
		ReviewVideo video = getVideo(videoName);
		if (video != null) {
			dao.delete(video);
		}
		return WebConstants.SUCCESS;
	}

	@Transactional
	public String updateIndex(String videoName, MultipartFile index) {

		try {
			if (ImageIO.read(index.getInputStream()) == null) {
				logger.info("not img");
				return "not img";
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ReviewVideo video = getVideo(videoName);

		String indexAddrSave = addressConfig.getRvideoIndexSaveAddress();
		String indexAddrRead = addressConfig.getRvideoIndexReadAddress();

		String indexFileName = index.getOriginalFilename();

		String indexFilePath = indexAddrSave + "ri-" + videoName + "."
				+ indexFileName.substring(indexFileName.lastIndexOf(".") + 1);
		String indexUrl = indexAddrRead + "ri-" + videoName + "."
				+ indexFileName.substring(indexFileName.lastIndexOf(".") + 1);

		video.setVideoIndexUrl(indexUrl);
		try {
			index.transferTo(new File(indexFilePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		} catch (IOException e) {
			e.printStackTrace();
			return WebConstants.FAILURE;
		}

		dao.save(video);

		return WebConstants.SUCCESS;
	}

	@Transactional
	public void updateAccessTime(int id, int count) {
		ReviewVideo x = dao.findUnique(ReviewVideo.class, "select x from ReviewVideo x where videoId=?", id);
		if (x == null)
			return;
		x.setVideoAccessTime(count);
		dao.save(x);
	}

}
