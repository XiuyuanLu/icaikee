package com.icaikee.wrap.web.controller.api.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icaikee.wrap.biz.review.ReviewBlogService;
import com.icaikee.wrap.biz.review.ReviewVideoService;
import com.icaikee.wrap.biz.review.model.ReviewVideo;
import com.icaikee.wrap.common.Message;
import com.icaikee.wrap.web.controller.WebConstants;

@Controller
@RequestMapping(WebConstants.API + "/review")
@ResponseBody
public class ReviewManagerDataController {

	@Autowired
	private ReviewVideoService reviewVideoService;

	@Autowired
	private ReviewBlogService reviewBlogService;

	@RequestMapping("/video/query")
	public ReviewVideo getSingleVideoInfo(@RequestParam(name = "videoName") String videoName) {
		return reviewVideoService.getVideo(videoName);
	}

	@RequestMapping("/video/update")
	public Message updateSingleVideoInfo(@RequestParam(name = "origVideoName") String origVideoName,
			@RequestParam(name = "videoName") String videoName, @RequestParam(name = "videoAuthor") String videoAuthor,
			@RequestParam(name = "videoUrl") String videoUrl,
			@RequestParam(name = "videoDescription") String videoDescription) {
		return Message.createSuccessMessage(reviewVideoService.updateSingleReviewVideoByName(origVideoName, videoName,
				videoAuthor, videoUrl, videoDescription));
	}

	@RequestMapping("/video/delete")
	public Message deleteSingleVideoInfo(@RequestParam(name = "videoName") String videoName) {
		return Message.createSuccessMessage(reviewVideoService.deleteSingleReviewVideoByName(videoName));
	}

	@RequestMapping("/blog/publish")
	public Message blogPublish(@RequestParam(name = "title") String title, @RequestParam(name = "author") String author,
			@RequestParam(name = "content") String content) {
		return Message.createSuccessMessage(reviewBlogService.publish(title, author, content));
	}

	@RequestMapping("/blog/query")
	public Message blogQuery(@RequestParam(name = "title") String title) {
		return Message.createSuccessMessage(reviewBlogService.getSingleBlogByTitle(title));
	}

}
