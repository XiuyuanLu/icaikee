package com.icaikee.wrap.biz.teaching.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WRAP_VIDEO_INFO")
public class Video {

	@Column(name = "VIDEO_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int videoId;

	@Id
	@Column(name = "VIDEO_NAME")
	private String videoName;

	@Column(name = "VIDEO_URL")
	private String videoUrl;

	@Column(name = "VIDEO_DESCRIPTION")
	private String videoDescription;

	@Column(name = "VIDEO_AUTHOR")
	private String videoAuthor;

	@Column(name = "VIDEO_INDEX_URL")
	private String videoIndexUrl;

	@Column(name = "VIDEO_UPLOAD_TIME")
	private Date videoUploadTime;

	@Column(name = "VIDEO_ACCESS_TIME")
	private int videoAccessTime;

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVideoDescription() {
		return videoDescription;
	}

	public void setVideoDescription(String videoDescription) {
		this.videoDescription = videoDescription;
	}

	public String getVideoAuthor() {
		return videoAuthor;
	}

	public void setVideoAuthor(String videoAuthor) {
		this.videoAuthor = videoAuthor;
	}

	public String getVideoIndexUrl() {
		return videoIndexUrl;
	}

	public void setVideoIndexUrl(String videoIndexUrl) {
		this.videoIndexUrl = videoIndexUrl;
	}

	public Date getVideoUploadTime() {
		return videoUploadTime;
	}

	public void setVideoUploadTime(Date videoUploadTime) {
		this.videoUploadTime = videoUploadTime;
	}

	public int getVideoAccessTime() {
		return videoAccessTime;
	}

	public void setVideoAccessTime(int videoAccessTime) {
		this.videoAccessTime = videoAccessTime;
	}

}
