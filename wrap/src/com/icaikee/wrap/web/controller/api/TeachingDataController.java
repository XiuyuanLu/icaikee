package com.icaikee.wrap.web.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icaikee.wrap.biz.cartoon.CartoonService;
import com.icaikee.wrap.biz.cartoon.model.CartoonInfo;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@ResponseBody
@RequestMapping(WebConstants.API)
public class TeachingDataController {

	@Autowired
	private CartoonService cartoonService;

	@RequestMapping("/singleCartoon")
	public CartoonInfo getSingleCartoonInfo(@RequestParam(name = "chapterId") String chapterId) {
		return cartoonService.getSingleCartoonByChapterId(chapterId);
	}

}
