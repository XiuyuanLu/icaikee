package com.icaikee.wrap.scheduler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.icaikee.wrap.biz.review.ReviewBlogService;
import com.icaikee.wrap.biz.review.ReviewVideoService;
import com.icaikee.wrap.biz.review.model.ReviewBlog;
import com.icaikee.wrap.biz.review.model.ReviewVideo;
import com.icaikee.wrap.biz.software.SoftwareService;
import com.icaikee.wrap.biz.teaching.TeachingCartoonService;
import com.icaikee.wrap.biz.teaching.TeachingVideoService;
import com.icaikee.wrap.biz.teaching.model.CartoonInfo;
import com.icaikee.wrap.biz.teaching.model.Video;

@Service
public class Counter {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ReviewBlogService reviewBlogService;

	@Autowired
	private ReviewVideoService reviewVideoService;

	@Autowired
	private TeachingCartoonService teachingCartoonService;

	@Autowired
	private TeachingVideoService teachingVideoService;

	@Autowired
	private SoftwareService softwareService;

	private static Map<Integer, Integer> tc = new HashMap<Integer, Integer>();

	private static Map<Integer, Integer> tv = new HashMap<Integer, Integer>();

	private static Map<Integer, Integer> rb = new HashMap<Integer, Integer>();

	private static Map<Integer, Integer> rv = new HashMap<Integer, Integer>();

	private static int sd = 0;

	@Scheduled(cron = "5 0 0 * * ?")
	public void refresh() {
		List<CartoonInfo> cartoonList = teachingCartoonService.getCartoons();
		List<Video> videoList = teachingVideoService.getVideos();
		List<ReviewBlog> blogList = reviewBlogService.getBlogs();
		List<ReviewVideo> reviewVideoList = reviewVideoService.getVideos();
		sd = softwareService.getSoftwareDownloadTime();
		for (CartoonInfo x : cartoonList)
			tc.put(x.getCartoonId(), x.getCartoonAccessTime());
		for (Video x : videoList)
			tv.put(x.getVideoId(), x.getVideoAccessTime());
		for (ReviewBlog x : blogList)
			rb.put(x.getBlogId(), x.getBlogAccessTime());
		for (ReviewVideo x : reviewVideoList)
			rv.put(x.getVideoId(), x.getVideoAccessTime());
	}

	@Scheduled(cron = "*/10 * * * * ?")
	public void count() {
		File file = new File("E:/programme/imgrepository/COUNTER.txt");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			Map<String, Integer> map = new HashMap<String, Integer>();
			while ((tempString = reader.readLine()) != null) {
				String[] array = tempString.split(" ");
				if (array.length < 3)
					continue;
				for (int i = 0; i < array.length; i++) {
					if ("[X]".equals(array[i])) {
						Integer c = map.get(array[i + 2]);
						if (c == null)
							c = 0;
						c++;
						map.put(array[i + 2], c);
					}
				}
			}
			for (String s : map.keySet()) {
				if (s.length() < 6)
					continue;
				String type = s.substring(0, 5);
				int id = Integer.parseInt(s.substring(5, s.length()));
				int count = map.get(s);
				System.out.println("type: " + type + " id: " + id + " count: " + count);
				if (CounterConstants.TYPE_TEACHING_CARTOON.equals(type)) {
					count += tc.get(id) == null ? 0 : tc.get(id);
					teachingCartoonService.updateAccessTime(id, count);
				} else if (CounterConstants.TYPE_TEACHING_VIDEO.equals(type)) {
					count += tv.get(id) == null ? 0 : tv.get(id);
					teachingVideoService.updateAccessTime(id, count);
				} else if (CounterConstants.TYPE_REVIEW_BLOG.equals(type)) {
					count += rb.get(id) == null ? 0 : rb.get(id);
					reviewBlogService.updateAccessTime(id, count);
				} else if (CounterConstants.TYPE_REVIEW_VIDEO.equals(type)) {
					count += rv.get(id) == null ? 0 : rv.get(id);
					reviewVideoService.updateAccessTime(id, count);
				} else if (CounterConstants.TYPE_SOFTWARE_DOWNLOAD.equals(type)) {
					count += sd;
					softwareService.updateAccessTime(count);
				} else {

				}
			}
			reader.close();
		} catch (IOException e) {
			logger.error("Counter IO Exception: ", e);
		} catch (Exception e) {
			logger.error("Counter Exception: ", e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					logger.error("Counter IO Exception: ", e1);
				}
			}
		}
	}

}
