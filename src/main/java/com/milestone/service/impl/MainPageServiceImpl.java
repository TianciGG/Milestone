package com.milestone.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.milestone.db.dao.ObjectiveDAO;
import com.milestone.db.dao.UserDAO;
import com.milestone.db.entity.Objective;
import com.milestone.db.entity.User;
import com.milestone.service.MainPageService;

@Service
public class MainPageServiceImpl implements MainPageService {
	@Resource
	private ObjectiveDAO objectiveDao;

	@Resource
	private UserDAO userDao;

	private List<Objective> validateOvertime(List<Objective> listObjective) {
		Date nowDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		List<Objective> newListObjective = new ArrayList<Objective>();
		for (Objective objective : listObjective) {
			String finishTimeString = objective.getObjectiveFinishdatetime();
			Date finishTime = null;
			try {
				finishTime = dateFormat.parse(finishTimeString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (nowDate.getTime() >= finishTime.getTime()) {
				newListObjective.add(objective);
			} else {
				continue;
			}
		}
		return newListObjective;
	}

	private List<Objective> validateNotOutTime(List<Objective> listObjective) {
		Date nowDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		List<Objective> newListObjective = new ArrayList<Objective>();
		for (Objective objective : listObjective) {
			String finishTimeString = objective.getObjectiveFinishdatetime();
			Date finishTime = null;
			try {
				finishTime = dateFormat.parse(finishTimeString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (nowDate.getTime() < finishTime.getTime()) {
				newListObjective.add(objective);
			} else {
				continue;
			}
		}
		return newListObjective;
	}

	private List<Objective> countDown(List<Objective> listObjective) {
		Date nowDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date finishTime = null;
		List<Objective> newListObjective = new ArrayList<Objective>();
		for (Objective objective : listObjective) {
			String finishTimeString = objective.getObjectiveFinishdatetime();
			try {
				finishTime = dateFormat.parse(finishTimeString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			long diff = finishTime.getTime() - nowDate.getTime();// 这样得到的差值是微秒级别
			long days = diff / (1000 * 60 * 60 * 24);
			long hours = (diff - days * (1000 * 60 * 60 * 24))
					/ (1000 * 60 * 60);
			long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours
					* (1000 * 60 * 60))
					/ (1000 * 60);
			// System.out.println("" + days + "天" + hours + "小时" + minutes +
			// "分");
			String daysString = Long.toString(days);
			String hoursString = Long.toString(hours);
			String minutesString = Long.toString(minutes);
			objective.setDays(daysString);
			objective.setHours(hoursString);
			objective.setMinutes(minutesString);
			newListObjective.add(objective);
		}
		return newListObjective;
	}

	@Override
	public List<Objective> searchMyTarget(String userId, String mark) {
		if ("1".equals(mark)) {
			return countDown(objectiveDao.searchMyTargetByUid(userId));
		} else if ("2".equals(mark)) {
			List<Objective> listObjective = countDown(objectiveDao
					.searchMyTargetByUid(userId));
			return validateOvertime(listObjective);
		} else if ("3".equals(mark)) {
			List<Objective> listObjective = countDown(objectiveDao
					.selectEmphasizeInfoByUid(userId));
			return validateNotOutTime(listObjective);
		} else if ("4".equals(mark)) {
			List<Objective> listObjective = countDown(objectiveDao
					.selectStandardInfoByUid(userId));
			return validateNotOutTime(listObjective);
		} else {
			return null;
		}
	}

	@Override
	public User selectPersonalInfo(String userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	@Override
	public boolean savePersonalInfo(User user) {
		return userDao.updateByPrimaryKey(user) > 0 ? true : false;
	}

	@Override
	public boolean createTarget(Objective objective) {
		objective.setObjectiveStatus("0");
		String finishTimeString = null;
		if (objective.getObjectiveFinishdatetime() != null
				&& objective.getObjectiveFinishdatetime().length() == 16) {
			finishTimeString = objective.getObjectiveFinishdatetime() + ":00";
		}
		objective.setObjectiveFinishdatetime(finishTimeString);
		Date nowDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		// Date finishTime = null;
		try {
			String emphasize = objective.getObjectiveEmphasize();
			if (emphasize == null || "".equals(emphasize)) {
				objective.setObjectiveEmphasize("0");
			}
			// finishTime = dateFormat.parse(finishTimeString);
		} catch (NullPointerException e) {
			objective.setObjectiveEmphasize("0");
		}
		/*
		 * long diff = finishTime.getTime() - nowDate.getTime();// 这样得到的差值是微秒级别
		 * long days = diff / (1000 * 60 * 60 * 24);
		 * 
		 * long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 *
		 * 60); long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours
		 * (1000 * 60 * 60)) / (1000 * 60); System.out.println("" + days + "天" +
		 * hours + "小时" + minutes + "分");
		 */
		String nowDateString = dateFormat.format(nowDate);
		objective.setObjectiveBegindatetime(nowDateString);
		return objectiveDao.insertSelective(objective) > 0 ? true : false;
	}

	@Override
	public boolean updateObjectiveTableInfo(Objective objective) {
		if (objective.getObjectiveFinishdatetime() != null
				&& objective.getObjectiveFinishdatetime().length() == 16) {
			// System.out.println(objective.getObjectiveFinishdatetime().length());
			String finishTimeString = objective.getObjectiveFinishdatetime()
					+ ":00";
			objective.setObjectiveFinishdatetime(finishTimeString);
		}
		if ("1".equals(objective.getObjectiveStatus())) {
			Date nowDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String nowDateString = dateFormat.format(nowDate);
			objective.setObjectiveEnddatetime(nowDateString);
		}
		return objectiveDao.updateByPrimaryKeySelective(objective) > 0 ? true
				: false;
	}

	@Override
	public boolean deleteObjectiveTableInfo(Objective objective) {
		return objectiveDao.deleteByPrimaryKey(objective.getObjectiveId()) > 0 ? true
				: false;
	}

	@Override
	public Objective selectObjectiveInfoById(String objectiveId) {
		return objectiveDao.selectByPrimaryKey(objectiveId);
	}

	@Override
	public List<Objective> searchMyMilestoneInfo(String userId,
			String objectiveTitle) {
		return objectiveDao.searchMyMilestoneByUidAndTitleContent(userId,
				objectiveTitle);
	}

}
