package com.milestone.service.impl;

import java.util.UUID;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milestone.db.dao.UserDAO;
import com.milestone.db.entity.User;
import com.milestone.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDao;

	@Override
	public User loginUser(User user) {
		User u = userDao.selectByName(user.getUserName());
		if (u != null) {
			if (u.getUserPassword().equals(user.getUserPassword())) {
				return u;
			}
		}
		return null;
	}

	@Override
	public Integer registerUser(User u) {
		User user = null;
		try {
			user = userDao.selectByName(u.getUserName());
			if (user.getUserName().equals(u.getUserName())) {
				return 4;
			}
		} catch (TooManyResultsException e) {
			return 4;
		} catch (NullPointerException e) {
			u.setUserId(UUID.randomUUID().toString());
			int i = userDao.insert(u);
			return i;
		}
		return 0;
	}

	@Override
	public Integer validateEmail(String mail) {
		User user = null;
		try {
			user = userDao.selectByEmail(mail);
			if (user.getUserMail().equals(mail)) {
				return 1;
			}
		} catch (TooManyResultsException e) {
			return 4;
		} catch (NullPointerException e) {
			return 4;
		}
		return 0;
	}
}
