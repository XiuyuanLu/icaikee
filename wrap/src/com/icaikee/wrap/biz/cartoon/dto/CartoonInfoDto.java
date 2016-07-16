package com.icaikee.wrap.biz.cartoon.dto;

public class CartoonInfoDto {

	private String cartoonName;

	private String chapterId;

	private String url;

	private String date;

	private String author;

	public CartoonInfoDto() {

	}

	public CartoonInfoDto(String chapterId, String cartoonName, String url) {
		this.chapterId = chapterId;
		this.cartoonName = cartoonName;
		this.url = url;
	}

	public String getCartoonName() {
		return cartoonName;
	}

	public void setCartoonName(String cartoonName) {
		this.cartoonName = cartoonName;
	}

	public String getChapterId() {
		return chapterId;
	}

	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
