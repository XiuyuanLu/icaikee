package com.icaikee.wrap.web.controller.page.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/manage/review")
public class ReviewManagerController {

	private final static String REVIEW_BLOG_MANAGE_PAGE = "manage/review-blog";

	private final static String REVIEW_VIDEO_MANAGE_PAGE = "manage/review-video";

	@RequestMapping("/blog")
	public ModelAndView reviewBlogPage() {
		return new ModelAndView(REVIEW_BLOG_MANAGE_PAGE);
	}

	@RequestMapping("/video")
	public ModelAndView reviewVideoPage() {
		return new ModelAndView(REVIEW_VIDEO_MANAGE_PAGE);
	}

}
