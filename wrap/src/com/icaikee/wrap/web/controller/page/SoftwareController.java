package com.icaikee.wrap.web.controller.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.biz.AddressConfig;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/software")
public class SoftwareController {

	private static final String SOFTWARE_INSTRUCTION_PAGE = "software/instruction";

	private static final String SOFTWARE_DOWNLOADING_PAGE = "software/downloading";

	@Autowired
	AddressConfig addressConfig;

	@RequestMapping("/instruction")
	public ModelAndView instruction() {
		ModelAndView mv = new ModelAndView(SOFTWARE_INSTRUCTION_PAGE);
		mv.addObject("url", addressConfig.getSoftwareReadAddress() + "software-instruction.jpg");
		mv.addObject("downloading", addressConfig.getSoftwareReadAddress() + "software.zip");
		return mv;
	}

	@RequestMapping("/downloading")
	public ModelAndView downloading() {
		ModelAndView mv = new ModelAndView(SOFTWARE_DOWNLOADING_PAGE);
		mv.addObject("url", addressConfig.getSoftwareReadAddress() + "software.zip");
		return mv;
	}

}
