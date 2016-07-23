package com.icaikee.wrap.web.controller.page;

import java.util.ArrayList;
import java.util.List;

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
import com.icaikee.wrap.biz.cartoon.model.CartoonInfo;
import com.icaikee.wrap.biz.software.SoftwareService;
import com.icaikee.wrap.biz.video.VideoService;
import com.icaikee.wrap.biz.video.model.Video;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/manage")
public class ManagerController {

	private final static String LOGIN_PAGE = "manage/login";

	private final static String CARTOON_MANAGE_PAGE = "manage/cartoon";

	private final static String VIDEO_MANAGE_PAGE = "manage/video";

	private final static String REVIEW_MANAGE_PAGE = "manage/review";

	private final static String SOFTWARE_MANAGE_PAGE = "manage/software";

	private final static String SUCCESS_MANAGE_PAGE = "manage/success";

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	CartoonService cartoonService;

	@Autowired
	VideoService videoService;

	@Autowired
	SoftwareService softwareService;

	@RequestMapping("/login")
	public ModelAndView loginPage() {
		return new ModelAndView(LOGIN_PAGE);
	}

	@RequestMapping("/cartoon")
	public ModelAndView cartoonPage() {
		ModelAndView mv = new ModelAndView(CARTOON_MANAGE_PAGE);
		List<CartoonInfo> cartoons = cartoonService.getCartoons();
		mv.addObject("cartoons", cartoons);
		List<String> cartoonChapters = new ArrayList<String>();
		for (CartoonInfo x : cartoons)
			cartoonChapters.add(x.getCartoonChapterId());
		mv.addObject("cartoonChapters", cartoonChapters);
		return mv;
	}

	@RequestMapping("/review")
	public ModelAndView reviewPage() {
		return new ModelAndView(REVIEW_MANAGE_PAGE);
	}

	@RequestMapping("/video")
	public ModelAndView videoPage() {
		ModelAndView mv = new ModelAndView(VIDEO_MANAGE_PAGE);
		List<Video> videos = videoService.getVideos();
		mv.addObject("videos", videos);
		List<String> videoNames = new ArrayList<String>();
		for (Video x : videos)
			videoNames.add(x.getVideoName());
		mv.addObject("videoNames", videoNames);
		return mv;
	}

	@RequestMapping("/software")
	public ModelAndView softwarePage() {
		return new ModelAndView(SOFTWARE_MANAGE_PAGE);
	}

	@RequestMapping(value = "/cartoon/upload", method = RequestMethod.POST)
	public ModelAndView cartoonUpload(HttpServletRequest request, @RequestParam(name = "chapterId") String chapterId,
			@RequestParam(name = "cartoonName") String cartoonName, @RequestParam(name = "author") String author,
			@RequestParam(name = "description") String description, @RequestParam(name = "img") MultipartFile img,
			@RequestParam(name = "index") MultipartFile index) {
		cartoonService.saveCartoonInfo(chapterId, cartoonName, author, description, img, index);
		return new ModelAndView(SUCCESS_MANAGE_PAGE);
	}

	@RequestMapping(value = "/cartoon/img-update", method = RequestMethod.POST)
	public ModelAndView imgUpdate(@RequestParam(name = "chapterId") String chapterId,
			@RequestParam(name = "img") MultipartFile img) {
		cartoonService.updateImg(chapterId, img);
		return new ModelAndView(SUCCESS_MANAGE_PAGE);
	}

	@RequestMapping(value = "/cartoon/index-update", method = RequestMethod.POST)
	public ModelAndView indexUpdate(@RequestParam(name = "chapterId") String chapterId,
			@RequestParam(name = "index") MultipartFile index) {
		cartoonService.updateIndex(chapterId, index);
		return new ModelAndView(SUCCESS_MANAGE_PAGE);
	}

	@RequestMapping(value = "/video/upload", method = RequestMethod.POST)
	public ModelAndView videoUpload(@RequestParam(name = "videoName") String videoName,
			@RequestParam(name = "videoAuthor") String videoAuthor, @RequestParam(name = "videoUrl") String videoUrl,
			@RequestParam(name = "videoDescription") String videoDescription,
			@RequestParam(name = "indexFile") MultipartFile indexFile) {
		videoService.upload(videoName, videoAuthor, videoUrl, videoDescription, indexFile);
		return new ModelAndView(SUCCESS_MANAGE_PAGE);
	}

	@RequestMapping(value = "/video/index-update", method = RequestMethod.POST)
	public ModelAndView videoIndexUpdate(@RequestParam(name = "videoName") String videoName,
			@RequestParam(name = "index") MultipartFile index) {
		videoService.updateIndex(videoName, index);
		return new ModelAndView(SUCCESS_MANAGE_PAGE);
	}

	@RequestMapping(value = "/software/instruction/upload", method = RequestMethod.POST)
	public ModelAndView instructionUpload(@RequestParam(name = "instruction") MultipartFile instruction) {
		softwareService.uploadInstruction(instruction);
		return new ModelAndView(SUCCESS_MANAGE_PAGE);
	}

}