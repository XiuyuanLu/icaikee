package com.icaikee.wrap.web.controller.page;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/manage")
public class ManagerController {

	private final static String CARTOON_MANAGE_PAGE = "manage/cartoon";

	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping("/cartoon")
	public ModelAndView cartoonPage() {
		return new ModelAndView(CARTOON_MANAGE_PAGE);
	}

}
