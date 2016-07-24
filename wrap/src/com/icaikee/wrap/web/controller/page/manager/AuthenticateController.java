package com.icaikee.wrap.web.controller.page.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/manage")
public class AuthenticateController {

	private final static String LOGIN_PAGE = "manage/login";

	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView(LOGIN_PAGE);
	}

}
