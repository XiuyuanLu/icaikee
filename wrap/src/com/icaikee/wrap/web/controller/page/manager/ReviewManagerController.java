package com.icaikee.wrap.web.controller.page.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.biz.review.ReviewBlogService;
import com.icaikee.wrap.biz.review.ReviewVideoService;
import com.icaikee.wrap.biz.review.model.ReviewVideo;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/manage/review")
public class ReviewManagerController {

	private final static String REVIEW_BLOG_MANAGE_PAGE = "manage/review-blog";

	private final static String REVIEW_VIDEO_MANAGE_PAGE = "manage/review-video";

	@Autowired
	private ReviewVideoService reviewVideoService;

	@Autowired
	private ReviewBlogService reviewBlogService;

	@RequestMapping("/blog")
	public ModelAndView reviewBlogPage() {
		return new ModelAndView(REVIEW_BLOG_MANAGE_PAGE);
	}

	@RequestMapping(value = "/blog/cover", method = RequestMethod.POST)
	public ModelAndView blogCoverUpload(@RequestParam(name = "title") String title,
			@RequestParam(name = "indexFile") MultipartFile indexFile) {
		reviewBlogService.uploadIndex(title, indexFile);
		return new ModelAndView(WebConstants.SUCCESS_MANAGE_PAGE);
	}

	@RequestMapping("/video")
	public ModelAndView reviewVideoPage() {
		ModelAndView mv = new ModelAndView(REVIEW_VIDEO_MANAGE_PAGE);
		List<ReviewVideo> videos = reviewVideoService.getVideos();
		mv.addObject("videos", videos);
		List<String> videoNames = new ArrayList<String>();
		for (ReviewVideo x : videos)
			videoNames.add(x.getVideoName());
		mv.addObject("videoNames", videoNames);
		return mv;
	}

	@RequestMapping(value = "/video/upload", method = RequestMethod.POST)
	public ModelAndView videoUpload(@RequestParam(name = "videoName") String videoName,
			@RequestParam(name = "videoAuthor") String videoAuthor, @RequestParam(name = "videoUrl") String videoUrl,
			@RequestParam(name = "videoDescription") String videoDescription,
			@RequestParam(name = "indexFile") MultipartFile indexFile) {
		reviewVideoService.upload(videoName, videoAuthor, videoUrl, videoDescription, indexFile);
		return new ModelAndView(WebConstants.SUCCESS_MANAGE_PAGE);
	}

	@RequestMapping(value = "/video/index-update", method = RequestMethod.POST)
	public ModelAndView videoIndexUpdate(@RequestParam(name = "videoName") String videoName,
			@RequestParam(name = "index") MultipartFile index) {
		reviewVideoService.updateIndex(videoName, index);
		return new ModelAndView(WebConstants.SUCCESS_MANAGE_PAGE);
	}

}
