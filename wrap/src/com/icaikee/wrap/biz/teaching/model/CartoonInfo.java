package com.icaikee.wrap.biz.teaching.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WRAP_CARTOON_INFO")
public class CartoonInfo {

	@Column(name = "CARTOON_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartoonId;

	@Id
	@Column(name = "CARTOON_CHAPTER_ID")
	private String cartoonChapterId;

	@Column(name = "CARTOON_NAME")
	private String cartoonName;

	@Column(name = "CARTOON_URL")
	private String cartoonUrl;

	@Column(name = "CARTOON_AUTHOR")
	private String cartoonAuthor;

	@Column(name = "CARTOON_INDEX_URL")
	private String cartoonIndexUrl;

	@Column(name = "CARTOON_DESCRIPTION")
	private String cartoonDescription;

	@Column(name = "CARTOON_UPLOAD_TIME")
	private Date cartoonUpdateTime;

	@Column(name = "CARTOON_ACCESS_TIME")
	private int cartoonAccessTime;

	public int getCartoonId() {
		return cartoonId;
	}

	public void setCartoonId(int cartoonId) {
		this.cartoonId = cartoonId;
	}

	public String getCartoonChapterId() {
		return cartoonChapterId;
	}

	public void setCartoonChapterId(String cartoonChapterId) {
		this.cartoonChapterId = cartoonChapterId;
	}

	public String getCartoonName() {
		return cartoonName;
	}

	public void setCartoonName(String cartoonName) {
		this.cartoonName = cartoonName;
	}

	public String getCartoonUrl() {
		return cartoonUrl;
	}

	public void setCartoonUrl(String cartoonUrl) {
		this.cartoonUrl = cartoonUrl;
	}

	public String getCartoonAuthor() {
		return cartoonAuthor;
	}

	public void setCartoonAuthor(String cartoonAuthor) {
		this.cartoonAuthor = cartoonAuthor;
	}

	public String getCartoonIndexUrl() {
		return cartoonIndexUrl;
	}

	public void setCartoonIndexUrl(String cartoonIndexUrl) {
		this.cartoonIndexUrl = cartoonIndexUrl;
	}

	public String getCartoonDescription() {
		return cartoonDescription;
	}

	public void setCartoonDescription(String cartoonDescription) {
		this.cartoonDescription = cartoonDescription;
	}

	public Date getCartoonUpdateTime() {
		return cartoonUpdateTime;
	}

	public void setCartoonUpdateTime(Date cartoonUpdateTime) {
		this.cartoonUpdateTime = cartoonUpdateTime;
	}

	public int getCartoonAccessTime() {
		return cartoonAccessTime;
	}

	public void setCartoonAccessTime(int cartoonAccessTime) {
		this.cartoonAccessTime = cartoonAccessTime;
	}

}
