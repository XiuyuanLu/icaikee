package com.icaikee.wrap.web.controller.page.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.biz.software.SoftwareService;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/manage/software")
public class SoftwareManagerController {

	private final static String SOFTWARE_MANAGE_PAGE = "manage/software";

	@Autowired
	SoftwareService softwareService;

	@RequestMapping
	public ModelAndView softwarePage() {
		return new ModelAndView(SOFTWARE_MANAGE_PAGE);
	}

	@RequestMapping(value = "/instruction/upload", method = RequestMethod.POST)
	public ModelAndView instructionUpload(@RequestParam(name = "instruction") MultipartFile instruction) {
		softwareService.uploadInstruction(instruction);
		return new ModelAndView(WebConstants.SUCCESS_MANAGE_PAGE);
	}
}
