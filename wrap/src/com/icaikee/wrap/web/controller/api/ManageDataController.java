package com.icaikee.wrap.web.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icaikee.wrap.biz.cartoon.CartoonService;
import com.icaikee.wrap.biz.cartoon.model.CartoonInfo;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.API)
@ResponseBody
public class ManageDataController {

	@Autowired
	private CartoonService cartoonService;

	@RequestMapping("/authenticate/login")
	public Map<String, String> login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("result", WebConstants.SUCCESS);
		return result;
	}

	@RequestMapping("/cartoon/query")
	public CartoonInfo getSingleCartoonInfo(@RequestParam(name = "chapterId") String chapterId) {
		return cartoonService.getSingleCartoonByChapterId(chapterId);
	}

	@RequestMapping("/cartoon/update")
	public String updateSingleCartoonInfo(@RequestParam(name = "origChapterId") String origChapterId,
			@RequestParam(name = "chapterId") String chapterId,
			@RequestParam(name = "cartoonName") String cartoonName) {
		return cartoonService.updateSingleCartoonByChapterId(origChapterId, chapterId, cartoonName);
	}

	@RequestMapping("/cartoon/delete")
	public String deleteSingleCartoonInfo(@RequestParam(name = "chapterId") String chapterId) {
		return cartoonService.deleteSingleCartoonByChapterId(chapterId);
	}

}
