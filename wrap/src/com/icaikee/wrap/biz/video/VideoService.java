package com.icaikee.wrap.biz.video;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import com.youku.uploader.YoukuUploader;

public class VideoService {

	private static YoukuUploader uploader;

	public void toYouku(MultipartFile video) {
		String client_id = "XXXX";
		String client_secret = "XXXX";
		String username = "��ͮ2012";
		String password = "zho";
		String result = "";
		String access_token = "";
		HashMap<String, String> params, uploadInfo;
		String filename = "���յ�43��.wmv";
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
		uploader = new YoukuUploader(client_id, client_secret);
		result = uploader.upload(params, uploadInfo, filename, true); // ���ĸ�������boolean���ͣ�true����ʾ����
																		// false������ʾ���ȣ�
		System.out.print(result); // ������Ƶid
	}

}
