package com.milestone.service;

import java.util.List;

import com.milestone.db.entity.Objective;
import com.milestone.db.entity.User;

public interface MainPageService {

	List<Objective> searchMyTarget(String userId, String mark);

	User selectPersonalInfo(String userId);

	boolean savePersonalInfo(User user);

	boolean createTarget(Objective objective);

	boolean updateObjectiveTableInfo(Objective objective);

	boolean deleteObjectiveTableInfo(Objective objective);

	Objective selectObjectiveInfoById(String objectiveId);

	List<Objective> searchMyMilestoneInfo(String userId, String objectiveTitle);

}
