package com.icaikee.wrap.biz.review.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WRAP_REVIEW_BLOG")
public class ReviewBlog {

	@Id
	@Column(name = "BLOG_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blogId;

	@Column(name = "BLOG_TITLE")
	private String blogTitle;

	@Column(name = "BLOG_AUTHOR")
	private String blogAuthor;

	@Column(name = "BLOG_CONTENT")
	private String blogContent;

	@Column(name = "BLOG_ACCESS_TIME")
	private int blogAccessTime;

	@Column(name = "BLOG_UPDATE_TIME")
	private Date blogUpdateTime;

	@Column(name = "BLOG_COVER_URL")
	private String blogCoverUrl;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogAuthor() {
		return blogAuthor;
	}

	public void setBlogAuthor(String blogAuthor) {
		this.blogAuthor = blogAuthor;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public int getBlogAccessTime() {
		return blogAccessTime;
	}

	public void setBlogAccessTime(int blogAccessTime) {
		this.blogAccessTime = blogAccessTime;
	}

	public Date getBlogUpdateTime() {
		return blogUpdateTime;
	}

	public void setBlogUpdateTime(Date blogUpdateTime) {
		this.blogUpdateTime = blogUpdateTime;
	}

	public String getBlogCoverUrl() {
		return blogCoverUrl;
	}

	public void setBlogCoverUrl(String blogCoverUrl) {
		this.blogCoverUrl = blogCoverUrl;
	}

}
