package com.icaikee.wrap.web.controller.page;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/teaching")
public class TeachingController {

	private final static String TEACHING_INDEX_PAGE = "teaching/teaching-index";
	private final static String TEACHING_CARTOON_PAGE = "teaching/teaching-cartoon";
	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping("/index")
	public ModelAndView home() {
		logger.info("teaching index page");
		return new ModelAndView(TEACHING_INDEX_PAGE);
	}

	@RequestMapping("/cartoon")
	public ModelAndView cartoon() {
		logger.info("teaching cartoon page");
		ModelAndView mv = new ModelAndView(TEACHING_CARTOON_PAGE);
		mv.addObject("url", "http://localhost:8888/img/home1.png");
		return mv;
	}
}
