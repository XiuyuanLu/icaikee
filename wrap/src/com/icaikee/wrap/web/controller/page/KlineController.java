package com.icaikee.wrap.web.controller.page;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/kline")
public class KlineController {

	private final static String TEST_PAGE = "kline/kline-test";

	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping("/test")
	public ModelAndView home() {
		return new ModelAndView(TEST_PAGE);
	}

}
