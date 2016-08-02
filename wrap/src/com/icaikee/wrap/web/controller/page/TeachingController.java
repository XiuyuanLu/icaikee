package com.icaikee.wrap.web.controller.page;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.biz.teaching.TeachingCartoonService;
import com.icaikee.wrap.biz.teaching.TeachingVideoService;
import com.icaikee.wrap.biz.teaching.model.CartoonInfo;
import com.icaikee.wrap.biz.teaching.model.Video;
import com.icaikee.wrap.common.logger.CounterLog;
import com.icaikee.wrap.scheduler.CounterConstants;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/teaching")
public class TeachingController {

	private final static String TEACHING_CARTOON_INDEX_PAGE = "teaching/teaching-cartoon-index";
	private final static String TEACHING_CARTOON_PAGE = "teaching/teaching-cartoon";

	private final static String TEACHING_VIDEO_INDEX_PAGE = "teaching/teaching-video-index";
	private final static String TEACHING_VIDEO_PAGE = "teaching/teaching-video";

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private TeachingCartoonService cartoonService;

	@Autowired
	private TeachingVideoService videoService;

	@RequestMapping("/cartoon")
	public ModelAndView cartoon() {
		logger.info("cartoon index");
		ModelAndView mv = new ModelAndView(TEACHING_CARTOON_INDEX_PAGE);
		List<CartoonInfo> cartoons = cartoonService.getCartoons();
		mv.addObject("cartoons", cartoons);
		return mv;
	}

	@RequestMapping("/cartoon/img")
	public ModelAndView cartoonImg(@RequestParam(name = "chapterId") String chapterId) {
		logger.info("teaching cartoon IMG page");
		ModelAndView mv = new ModelAndView(TEACHING_CARTOON_PAGE);
		CartoonInfo cartoon = cartoonService.getSingleCartoonByChapterId(chapterId);
		logger.info("chapter id: " + chapterId);
		logger.info("cartoon object: " + cartoon);
		mv.addObject("chapterId", chapterId);
		mv.addObject("cartoonName", cartoon.getCartoonName());
		mv.addObject("url", cartoon.getCartoonUrl());
		mv.addObject("author", cartoon.getCartoonAuthor());
		mv.addObject("description", cartoon.getCartoonDescription());
		mv.addObject("accessTime", cartoon.getCartoonAccessTime());
		CounterLog.counterLog(logger, CounterConstants.TYPE_TEACHING_CARTOON + cartoon.getCartoonId());
		return mv;
	}

	@RequestMapping("/video")
	public ModelAndView videoIndex() {
		logger.info("video index");
		ModelAndView mv = new ModelAndView(TEACHING_VIDEO_INDEX_PAGE);
		List<Video> videos = videoService.getVideos();
		mv.addObject("videos", videos);
		return mv;
	}

	@RequestMapping("/video/video")
	public ModelAndView video(@RequestParam(name = "videoName") String videoName) {
		logger.info("video");
		ModelAndView mv = new ModelAndView(TEACHING_VIDEO_PAGE);
		Video video = videoService.getVideo(videoName);
		mv.addObject("video", video);
		CounterLog.counterLog(logger, CounterConstants.TYPE_TEACHING_VIDEO + video.getVideoId());
		return mv;
	}
}
