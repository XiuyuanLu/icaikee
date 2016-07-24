package com.icaikee.wrap.web.controller.api.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icaikee.wrap.biz.teaching.TeachingCartoonService;
import com.icaikee.wrap.biz.teaching.TeachingVideoService;
import com.icaikee.wrap.biz.teaching.model.CartoonInfo;
import com.icaikee.wrap.biz.teaching.model.Video;
import com.icaikee.wrap.common.Message;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.API + "/teaching")
@ResponseBody
public class TeachingManagerDataController {

	@Autowired
	private TeachingCartoonService cartoonService;

	@Autowired
	TeachingVideoService videoService;

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

	@RequestMapping("/video/query")
	public Video getSingleVideoInfo(@RequestParam(name = "videoName") String videoName) {
		return videoService.getVideo(videoName);
	}

	@RequestMapping("/video/update")
	public Message updateSingleVideoInfo(@RequestParam(name = "origVideoName") String origVideoName,
			@RequestParam(name = "videoName") String videoName, @RequestParam(name = "videoAuthor") String videoAuthor,
			@RequestParam(name = "videoUrl") String videoUrl,
			@RequestParam(name = "videoDescription") String videoDescription) {
		return Message.createSuccessMessage(videoService.updateSingleVideoByName(origVideoName, videoName, videoAuthor,
				videoUrl, videoDescription));
	}

	@RequestMapping("/video/delete")
	public Message deleteSingleVideoInfo(@RequestParam(name = "videoName") String videoName) {
		return Message.createSuccessMessage(videoService.deleteSingleVideoByName(videoName));
	}

}
