package com.icaikee.wrap.biz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AddressConfig {

	@Value("#{configProperties['imgrepo.address.save']}")
	private String saveAddress;

	@Value("#{configProperties['imgrepo.address.read']}")
	private String readAddress;

	@Value("#{configProperties['imgrepo.index.address.save']}")
	private String indexSaveAddress;

	@Value("#{configProperties['imgrepo.index.address.read']}")
	private String indexReadAddress;

	@Value("#{configProperties['imgrepo.video.index.address.save']}")
	private String videoIndexSaveAddress;

	@Value("#{configProperties['imgrepo.video.index.address.read']}")
	private String videoIndexReadAddress;

	@Value("#{configProperties['imgrepo.rvideo.index.address.save']}")
	private String rvideoIndexSaveAddress;

	@Value("#{configProperties['imgrepo.rvideo.index.address.read']}")
	private String rvideoIndexReadAddress;

	@Value("#{configProperties['imgrepo.blog.index.address.save']}")
	private String blogIndexSaveAddress;

	@Value("#{configProperties['imgrepo.blog.index.address.read']}")
	private String blogIndexReadAddress;

	@Value("#{configProperties['imgrepo.software.address.save']}")
	private String softwareSaveAddress;

	@Value("#{configProperties['imgrepo.software.address.read']}")
	private String softwareReadAddress;

	public String getSaveAddress() {
		return saveAddress;
	}

	public void setSaveAddress(String saveAddress) {
		this.saveAddress = saveAddress;
	}

	public String getReadAddress() {
		return readAddress;
	}

	public void setReadAddress(String readAddress) {
		this.readAddress = readAddress;
	}

	public String getIndexSaveAddress() {
		return indexSaveAddress;
	}

	public void setIndexSaveAddress(String indexSaveAddress) {
		this.indexSaveAddress = indexSaveAddress;
	}

	public String getIndexReadAddress() {
		return indexReadAddress;
	}

	public void setIndexReadAddress(String indexReadAddress) {
		this.indexReadAddress = indexReadAddress;
	}

	public String getVideoIndexSaveAddress() {
		return videoIndexSaveAddress;
	}

	public void setVideoIndexSaveAddress(String videoIndexSaveAddress) {
		this.videoIndexSaveAddress = videoIndexSaveAddress;
	}

	public String getVideoIndexReadAddress() {
		return videoIndexReadAddress;
	}

	public void setVideoIndexReadAddress(String videoIndexReadAddress) {
		this.videoIndexReadAddress = videoIndexReadAddress;
	}

	public String getRvideoIndexSaveAddress() {
		return rvideoIndexSaveAddress;
	}

	public void setRvideoIndexSaveAddress(String rvideoIndexSaveAddress) {
		this.rvideoIndexSaveAddress = rvideoIndexSaveAddress;
	}

	public String getRvideoIndexReadAddress() {
		return rvideoIndexReadAddress;
	}

	public void setRvideoIndexReadAddress(String rvideoIndexReadAddress) {
		this.rvideoIndexReadAddress = rvideoIndexReadAddress;
	}

	public String getBlogIndexSaveAddress() {
		return blogIndexSaveAddress;
	}

	public void setBlogIndexSaveAddress(String blogIndexSaveAddress) {
		this.blogIndexSaveAddress = blogIndexSaveAddress;
	}

	public String getBlogIndexReadAddress() {
		return blogIndexReadAddress;
	}

	public void setBlogIndexReadAddress(String blogIndexReadAddress) {
		this.blogIndexReadAddress = blogIndexReadAddress;
	}

	public String getSoftwareSaveAddress() {
		return softwareSaveAddress;
	}

	public void setSoftwareSaveAddress(String softwareSaveAddress) {
		this.softwareSaveAddress = softwareSaveAddress;
	}

	public String getSoftwareReadAddress() {
		return softwareReadAddress;
	}

	public void setSoftwareReadAddress(String softwareReadAddress) {
		this.softwareReadAddress = softwareReadAddress;
	}

}
