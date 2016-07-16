package com.icaikee.wrap.biz.video;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import com.youku.uploader.YoukuUploader;

public class VideoService {

	private static YoukuUploader uploader;

	public void toYouku(MultipartFile video) {
		String client_id = "XXXX";
		String client_secret = "XXXX";
		String username = "剪彤2012";
		String password = "zho";
		String result = "";
		String access_token = "";
		HashMap<String, String> params, uploadInfo;
		String filename = "标日第43课.wmv";
		params = new HashMap<String, String>();
		params.put("username", username);
		params.put("password", password);
		params.put("access_token", access_token);
		uploadInfo = new HashMap<String, String>();
		uploadInfo.put("file_name", filename); // 指定：文件名
		uploadInfo.put("title", "标准日语第43课"); // 指定：标题
		uploadInfo.put("tags", "日语 教育"); // 指定：分类
		uploadInfo.put("public_type", "all"); // 视频公开类型（all：公开（默认），friend：仅好友，password：需要输入密码才能观看）
		// uploadInfo.put("watch_password", "123456");
		// //密码，当public_type为password时，必填
		uploader = new YoukuUploader(client_id, client_secret);
		result = uploader.upload(params, uploadInfo, filename, true); // 第四个参数：boolean类型（true：显示进度
																		// false：不显示进度）
		System.out.print(result); // 返回视频id
	}

}
