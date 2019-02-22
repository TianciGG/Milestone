package com.milestone.db.dao;

import org.springframework.stereotype.Repository;

import com.milestone.db.entity.User;

@Repository
public interface UserDAO {
	int deleteByPrimaryKey(String userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String userId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User selectByName(String userName);

	User selectByEmail(String mail);
}