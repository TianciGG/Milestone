package com.milestone.service;

import com.milestone.db.entity.User;

public interface UserService {
	public User loginUser(User user);

	public Integer registerUser(User u);

	public Integer validateEmail(String mail);
}
