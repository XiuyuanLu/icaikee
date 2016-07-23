package com.icaikee.wrap.web.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icaikee.wrap.biz.cartoon.CartoonService;
import com.icaikee.wrap.biz.cartoon.model.CartoonInfo;
import com.icaikee.wrap.biz.user.LoginService;
import com.icaikee.wrap.common.Message;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.API)
@ResponseBody
public class ManageDataController {

	@Autowired
	private CartoonService cartoonService;

	@Autowired
	LoginService loginService;

	@RequestMapping("/authenticate/login")
	public Message login(HttpServletRequest request, @RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		String res = loginService.login(username, password);
		if (WebConstants.SUCCESS.equals(res)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
		}
		return Message.createSuccessMessage(res);
	}

	@RequestMapping("/cartoon/query")
	public CartoonInfo getSingleCartoonInfo(@RequestParam(name = "chapterId") String chapterId) {
		return cartoonService.getSingleCartoonByChapterId(chapterId);
	}

	@RequestMapping("/cartoon/update")
	public Message updateSingleCartoonInfo(@RequestParam(name = "origChapterId") String origChapterId,
			@RequestParam(name = "chapterId") String chapterId, @RequestParam(name = "cartoonName") String cartoonName,
			@RequestParam(name = "author") String author, @RequestParam(name = "description") String description) {
		return Message.createSuccessMessage(cartoonService.updateSingleCartoonByChapterId(origChapterId, chapterId,
				cartoonName, author, description));
	}

	@RequestMapping("/cartoon/delete")
	public Message deleteSingleCartoonInfo(@RequestParam(name = "chapterId") String chapterId) {
		return Message.createSuccessMessage(cartoonService.deleteSingleCartoonByChapterId(chapterId));
	}

}
