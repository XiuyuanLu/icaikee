package com.icaikee.wrap.web.controller.page;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.biz.cartoon.CartoonService;
import com.icaikee.wrap.biz.cartoon.model.CartoonInfo;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/teaching")
public class TeachingController {

	private final static String TEACHING_CARTOON_PAGE = "teaching/teaching-cartoon";
	private final static String TEACHING_CARTOON_PAGE_IMG = "teaching/teaching-cartoon-img";

	private final static String TEACHING_VIDEO_PAGE = "teaching/teaching-video";
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private CartoonService cartoonService;

	@RequestMapping("/cartoon")
	public ModelAndView cartoon() {
		logger.info("cartoon index");
		ModelAndView mv = new ModelAndView(TEACHING_CARTOON_PAGE);
		List<CartoonInfo> cartoons = cartoonService.getCartoons();
		mv.addObject("cartoons", cartoons);
		return mv;
	}

	@RequestMapping("/cartoon/img")
	public ModelAndView cartoonImg(@RequestParam(name = "chapterId") String chapterId) {
		logger.info("teaching cartoon IMG page");
		ModelAndView mv = new ModelAndView(TEACHING_CARTOON_PAGE_IMG);
		CartoonInfo cartoon = cartoonService.getSingleCartoonByChapterId(chapterId);
		logger.info("chapter id: " + chapterId);
		logger.info("cartoon object: " + cartoon);
		mv.addObject("chapterId", chapterId);
		mv.addObject("cartoonName", cartoon.getName());
		mv.addObject("url", cartoon.getUrl());
		mv.addObject("author", cartoon.getAuthor());
		mv.addObject("description", cartoon.getDescription());
		return mv;
	}

	@RequestMapping("/video")
	public ModelAndView video() {
		logger.info("video index");
		ModelAndView mv = new ModelAndView(TEACHING_VIDEO_PAGE);
		return mv;
	}
}
