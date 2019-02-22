package com.milestone.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.milestone.db.entity.Objective;
import com.milestone.db.entity.User;

@Repository
public interface ObjectiveDAO {
	int deleteByPrimaryKey(String objectiveId);

	int insert(Objective record);

	int insertSelective(Objective record);

	Objective selectByPrimaryKey(String objectiveId);

	int updateByPrimaryKeySelective(Objective record);

	int updateByPrimaryKey(Objective record);

	List<Objective> searchMyTargetByUid(String userId);

	User selectPersonalInfoByUid(String userId);

	List<Objective> selectEmphasizeInfoByUid(String userId);

	List<Objective> selectStandardInfoByUid(String userId);

	List<Objective> searchMyMilestoneByUidAndTitleContent(
			@Param("userId") String userId,
			@Param("objectiveTitle") String objectiveTitle);
}