package com.icaikee.wrap.biz.video;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icaikee.wrap.biz.video.model.Video;
import com.icaikee.wrap.db.hibernate.HibernateDao;
import com.icaikee.wrap.web.controller.WebConstants;

@Service
public class VideoService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private HibernateDao dao;

	@Transactional
	public String upload(String videoName, String videoAuthor, String videoUrl, String videoDescription) {

		Video video = getVideo(videoName);
		if (video != null)
			return "��Ƶ�����Ѵ���";
		video = new Video();
		video.setVideoName(videoName);
		video.setVideoAuthor(videoAuthor);
		video.setVideoUrl(videoUrl);
		video.setVideoDescription(videoDescription);
		video.setVideoUploadTime(new Date());
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

}
