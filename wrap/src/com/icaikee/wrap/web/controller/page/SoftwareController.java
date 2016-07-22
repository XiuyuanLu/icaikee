package com.icaikee.wrap.web.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/software")
public class SoftwareController {

	private static final String SOFTWARE_INSTRUCTION_PAGE = "software/instruction";

	private static final String SOFTWARE_DOWNLOADING_PAGE = "software/downloading";

	@RequestMapping("/instruction")
	public ModelAndView instruction() {
		return new ModelAndView(SOFTWARE_INSTRUCTION_PAGE);
	}

	@RequestMapping("/downloading")
	public ModelAndView downloading() {
		return new ModelAndView(SOFTWARE_DOWNLOADING_PAGE);
	}

}
