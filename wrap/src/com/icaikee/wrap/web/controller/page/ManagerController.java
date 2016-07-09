package com.icaikee.wrap.web.controller.page;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.biz.cartoon.CartoonService;
import com.icaikee.wrap.biz.cartoon.dto.CartoonInfoDto;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/manage")
public class ManagerController {

	private final static String CARTOON_MANAGE_PAGE = "manage/cartoon";

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	CartoonService cartoonService;

	@RequestMapping("/cartoon")
	public ModelAndView cartoonPage() {
		return new ModelAndView(CARTOON_MANAGE_PAGE);
	}

	@RequestMapping(value = "/cartoon/upload", method = RequestMethod.POST)
	public ModelAndView cartoonUpload(HttpServletRequest request, @RequestParam(name = "img") MultipartFile img) {
		CartoonInfoDto cartoon = new CartoonInfoDto("002", "test");
		cartoonService.saveCartoonInfo(cartoon, img);
		return new ModelAndView(CARTOON_MANAGE_PAGE);
	}

}
