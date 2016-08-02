package com.icaikee.wrap.web.controller.page.manager;

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

import com.icaikee.wrap.biz.teaching.TeachingCartoonService;
import com.icaikee.wrap.biz.teaching.TeachingVideoService;
import com.icaikee.wrap.biz.teaching.model.CartoonInfo;
import com.icaikee.wrap.biz.teaching.model.Video;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.PAGE + "/manage/teaching")
public class TeachingManagerController {

	private final static String TEACHING_CARTOON_MANAGE_PAGE = "manage/teaching-cartoon";

	private final static String TEACHING_VIDEO_MANAGE_PAGE = "manage/teaching-video";

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	TeachingCartoonService cartoonService;

	@Autowired
	TeachingVideoService videoService;

	@RequestMapping("/cartoon")
	public ModelAndView cartoonPage() {
		ModelAndView mv = new ModelAndView(TEACHING_CARTOON_MANAGE_PAGE);
		List<CartoonInfo> cartoons = cartoonService.getCartoons();
		mv.addObject("cartoons", cartoons);
		List<String> cartoonChapters = new ArrayList<String>();
		for (CartoonInfo x : cartoons)
			cartoonChapters.add(x.getCartoonChapterId());
		mv.addObject("cartoonChapters", cartoonChapters);
		return mv;
	}

	@RequestMapping("/video")
	public ModelAndView videoPage() {
		ModelAndView mv = new ModelAndView(TEACHING_VIDEO_MANAGE_PAGE);
		List<Video> videos = videoService.getVideos();
		mv.addObject("videos", videos);
		List<String> videoNames = new ArrayList<String>();
		for (Video x : videos)
			videoNames.add(x.getVideoName());
		mv.addObject("videoNames", videoNames);
		return mv;
	}

	@RequestMapping(value = "/cartoon/upload", method = RequestMethod.POST)
	public ModelAndView cartoonUpload(HttpServletRequest request, @RequestParam(name = "chapterId") String chapterId,
			@RequestParam(name = "cartoonName") String cartoonName, @RequestParam(name = "author") String author,
			@RequestParam(name = "description") String description, @RequestParam(name = "imgs[]") MultipartFile[] imgs,
			@RequestParam(name = "index") MultipartFile index) {
		cartoonService.saveCartoonInfo(chapterId, cartoonName, author, description, imgs, index);
		return new ModelAndView(WebConstants.SUCCESS_MANAGE_PAGE);
	}

	@RequestMapping(value = "/cartoon/img-update", method = RequestMethod.POST)
	public ModelAndView imgUpdate(@RequestParam(name = "chapterId") String chapterId,
			@RequestParam(name = "img") MultipartFile img) {
		cartoonService.updateImg(chapterId, img);
		return new ModelAndView(WebConstants.SUCCESS_MANAGE_PAGE);
	}

	@RequestMapping(value = "/cartoon/index-update", method = RequestMethod.POST)
	public ModelAndView indexUpdate(@RequestParam(name = "chapterId") String chapterId,
			@RequestParam(name = "index") MultipartFile index) {
		cartoonService.updateIndex(chapterId, index);
		return new ModelAndView(WebConstants.SUCCESS_MANAGE_PAGE);
	}

	@RequestMapping(value = "/video/upload", method = RequestMethod.POST)
	public ModelAndView videoUpload(@RequestParam(name = "videoName") String videoName,
			@RequestParam(name = "videoAuthor") String videoAuthor, @RequestParam(name = "videoUrl") String videoUrl,
			@RequestParam(name = "videoDescription") String videoDescription,
			@RequestParam(name = "indexFile") MultipartFile indexFile) {
		videoService.upload(videoName, videoAuthor, videoUrl, videoDescription, indexFile);
		return new ModelAndView(WebConstants.SUCCESS_MANAGE_PAGE);
	}

	@RequestMapping(value = "/video/index-update", method = RequestMethod.POST)
	public ModelAndView videoIndexUpdate(@RequestParam(name = "videoName") String videoName,
			@RequestParam(name = "index") MultipartFile index) {
		videoService.updateIndex(videoName, index);
		return new ModelAndView(WebConstants.SUCCESS_MANAGE_PAGE);
	}

}