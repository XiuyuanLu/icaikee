package com.icaikee.wrap.web.controller.page;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.biz.review.ReviewVideoService;
import com.icaikee.wrap.biz.review.model.ReviewVideo;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/review")
public class ReviewController {

	private final static String REVIEW_BLOG_INDEX_PAGE = "review/review-blog-index";
	private final static String REVIEW_BLOG_PAGE = "review/review-blog";
	private final static String REVIEW_VIDEO_INDEX_PAGE = "review/review-video-index";
	private final static String REVIEW_VIDEO_PAGE = "review/review-video";

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ReviewVideoService reviewVideoService;

	@RequestMapping("/video")
	public ModelAndView videoIndex() {
		logger.info("video index");
		ModelAndView mv = new ModelAndView(REVIEW_VIDEO_INDEX_PAGE);
		List<ReviewVideo> videos = reviewVideoService.getVideos();
		mv.addObject("videos", videos);
		return mv;
	}

	@RequestMapping("/video/video")
	public ModelAndView video(@RequestParam(name = "videoName") String videoName) {
		logger.info("video");
		ModelAndView mv = new ModelAndView(REVIEW_VIDEO_PAGE);
		ReviewVideo video = reviewVideoService.getVideo(videoName);
		mv.addObject("video", video);
		return mv;
	}
}
