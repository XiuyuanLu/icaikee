package com.icaikee.wrap.biz.chapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icaikee.wrap.biz.chapter.model.Chapter;
import com.icaikee.wrap.db.hibernate.HibernateDao;

@Service
public class ChapterService {

	@Autowired
	private HibernateDao dao;

	public List<Chapter> getChapters(String kind) {
		if (kind == null || kind == "")
			return null;
		return dao.find(Chapter.class, "select x from Chapter x where x.chapterKind=?", kind);
	}

}
