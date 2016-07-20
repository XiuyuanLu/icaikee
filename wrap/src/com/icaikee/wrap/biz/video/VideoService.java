package com.icaikee.wrap.biz.video;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.youku.uploader.YoukuUploader;

@Service
public class VideoService {

	private static YoukuUploader uploader;

	public void upload(MultipartFile video) {
		String client_id = "2a22cf2c6dfe6969";
		String client_secret = "05316a8d438b3c55898d7952482b5bc4";
		String username = "LXY_FYF";
		String password = "liveordie2011";
		String result = "";
		String access_token = "";
		get(client_id);

		HashMap<String, String> params, uploadInfo;
		String filename = "C:\\Users\\雨霏\\Desktop\\MVI_1159.MOV";
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
		// uploader = new YoukuUploader(client_id, client_secret);
		// result = uploader.upload(params, uploadInfo, filename, true); //
		// 第四个参数：boolean类型（true：显示进度
		// false：不显示进度）
		// System.out.print(result); // 返回视频id
	}

	public static void get(String clientId) {
		// 创建HttpClient实例
		HttpClient httpclient = new DefaultHttpClient();
		// 创建Get方法实例
		HttpGet httpgets = new HttpGet("https://openapi.youku.com/v2/oauth2/authorize?client_id=" + clientId
				+ "&response_type=code&redirect_uri=x");
		HttpResponse response;
		try {
			response = httpclient.execute(httpgets);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instreams = entity.getContent();
				String str = convertStreamToString(instreams);
				System.out.println("Do something");
				System.out.println(str);
				// Do not need the rest
				httpgets.abort();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}
