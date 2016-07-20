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
		String filename = "C:\\Users\\����\\Desktop\\MVI_1159.MOV";
		params = new HashMap<String, String>();
		params.put("username", username);
		params.put("password", password);
		params.put("access_token", access_token);
		uploadInfo = new HashMap<String, String>();
		uploadInfo.put("file_name", filename); // ָ�����ļ���
		uploadInfo.put("title", "��׼�����43��"); // ָ��������
		uploadInfo.put("tags", "���� ����"); // ָ��������
		uploadInfo.put("public_type", "all"); // ��Ƶ�������ͣ�all��������Ĭ�ϣ���friend�������ѣ�password����Ҫ����������ܹۿ���
		// uploadInfo.put("watch_password", "123456");
		// //���룬��public_typeΪpasswordʱ������
		// uploader = new YoukuUploader(client_id, client_secret);
		// result = uploader.upload(params, uploadInfo, filename, true); //
		// ���ĸ�������boolean���ͣ�true����ʾ����
		// false������ʾ���ȣ�
		// System.out.print(result); // ������Ƶid
	}

	public static void get(String clientId) {
		// ����HttpClientʵ��
		HttpClient httpclient = new DefaultHttpClient();
		// ����Get����ʵ��
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
