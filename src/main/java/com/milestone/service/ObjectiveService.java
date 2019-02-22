package com.milestone.service;

import com.milestone.db.entity.Objective;

public interface ObjectiveService {

	Objective selectByUserId(String userId);
	
	int insertSelective(Objective objective);
	int updateByPrimaryKeySelective(Objective objective);
}
