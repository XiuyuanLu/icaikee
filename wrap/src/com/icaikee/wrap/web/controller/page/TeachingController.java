package com.icaikee.wrap.web.controller.page;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.biz.cartoon.CartoonService;
import com.icaikee.wrap.biz.cartoon.dto.CartoonInfoDto;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/teaching")
public class TeachingController {

	private final static String TEACHING_CARTOON_PAGE = "teaching/teaching-cartoon";
	private final static String TEACHING_CARTOON_PAGE_IMG = "teaching/teaching-cartoon-img";
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private CartoonService cartoonService;

	@RequestMapping("/cartoon")
	public ModelAndView cartoon() {
		logger.info("cartoon index");
		ModelAndView mv = new ModelAndView(TEACHING_CARTOON_PAGE);
		List<CartoonInfoDto> cartoons = cartoonService.getCartoons();
		mv.addObject("cartoons", cartoons);
		return mv;
	}

	@RequestMapping("/cartoon/img")
	public ModelAndView cartoonImg(@RequestParam(name = "chapterId") String chapterId,
			@RequestParam(name = "cartoonName") String cartoonName, @RequestParam(name = "url") String url) {
		logger.info("teaching cartoon IMG page");
		ModelAndView mv = new ModelAndView(TEACHING_CARTOON_PAGE_IMG);
		mv.addObject("url", url);
		return mv;
	}
}
