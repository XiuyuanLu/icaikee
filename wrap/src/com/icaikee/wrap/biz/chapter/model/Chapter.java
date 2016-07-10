package com.icaikee.wrap.biz.chapter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wrap_chapter_info")
public class Chapter {

	public final static String CARTOON = "cartoon";
	public final static String VIDEO = "video";
	public final static String FINTHREE = "finThree";

	@Id
	@Column(name = "CHAPTER_ID")
	private String chapterId;

	@Column(name = "CHAPTER_KIND")
	private String chapterKind;

	@Column(name = "CHAPTER_NAME")
	private String chapterName;

	public String getChapterId() {
		return chapterId;
	}

	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterKind() {
		return chapterKind;
	}

	public void setChapterKind(String chapterKind) {
		this.chapterKind = chapterKind;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

}
