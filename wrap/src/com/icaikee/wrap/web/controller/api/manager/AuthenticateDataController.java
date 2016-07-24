package com.icaikee.wrap.web.controller.api.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icaikee.wrap.biz.user.LoginService;
import com.icaikee.wrap.common.Message;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.API + "/authenticate")
@ResponseBody
public class AuthenticateDataController {

	@Autowired
	LoginService loginService;

	@RequestMapping("/login")
	public Message login(HttpServletRequest request, @RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		String res = loginService.login(username, password);
		if (WebConstants.SUCCESS.equals(res)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
		}
		return Message.createSuccessMessage(res);
	}

}
