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
import com.icaikee.wrap.biz.teaching.model.Video;
import com.icaikee.wrap.db.hibernate.HibernateDao;
import com.icaikee.wrap.web.controller.WebConstants;

@Service
public class TeachingVideoService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private HibernateDao dao;

	@Autowired
	private AddressConfig addressConfig;

	@Transactional
	public String upload(String videoName, String videoAuthor, String videoUrl, String videoDescription,
			MultipartFile indexFile) {

		Video video = getVideo(videoName);
		if (video != null)
			return "视频名称已存在";

		String indexAddrSave = addressConfig.getVideoIndexSaveAddress();
		String indexAddrRead = addressConfig.getVideoIndexReadAddress();
		String indexFileName = indexFile.getOriginalFilename();
		String indexFilePath = indexAddrSave + "i-" + videoName + "."
				+ indexFileName.substring(indexFileName.lastIndexOf(".") + 1);
		String indexUrl = indexAddrRead + "i-" + videoName + "."
				+ indexFileName.substring(indexFileName.lastIndexOf(".") + 1);

		video = new Video();
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

	public Video getVideo(String videoName) {
		return dao.findUnique(Video.class, "select x from Video x where x.videoName=?", videoName);
	}

	public List<Video> getVideos() {
		return dao.find(Video.class, "select x from Video x");
	}

	@Transactional
	public String updateSingleVideoByName(String origVideoName, String videoName, String videoAuthor, String videoUrl,
			String videoDescription) {
		Video video = getVideo(origVideoName);
		if (video != null) {
			if (!origVideoName.equals(videoName)) {
				dao.delete(video);
				video = new Video();
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
	public String deleteSingleVideoByName(String videoName) {
		Video video = getVideo(videoName);
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
		Video video = getVideo(videoName);

		String indexAddrSave = addressConfig.getVideoIndexSaveAddress();
		String indexAddrRead = addressConfig.getVideoIndexReadAddress();

		String indexFileName = index.getOriginalFilename();

		String indexFilePath = indexAddrSave + "i-" + videoName + "."
				+ indexFileName.substring(indexFileName.lastIndexOf(".") + 1);
		String indexUrl = indexAddrRead + "i-" + videoName + "."
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
		Video x = dao.findUnique(Video.class, "select x from Video x where videoId=?", id);
		if (x == null)
			return;
		x.setVideoAccessTime(count);
		dao.save(x);
	}

}
