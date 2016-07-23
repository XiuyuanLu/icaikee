package com.icaikee.wrap.biz.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icaikee.wrap.biz.user.model.User;
import com.icaikee.wrap.db.hibernate.HibernateDao;
import com.icaikee.wrap.web.controller.WebConstants;

@Service
public class LoginService {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private HibernateDao dao;

	public String login(String username, String password) {
		User user = dao.findUnique(User.class, "select x from User x where x.username=? and x.password=?", username,
				password);
		if (user == null)
			return WebConstants.FAILURE;
		return WebConstants.SUCCESS;
	}

}
