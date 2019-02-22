package com.milestone.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.milestone.db.entity.Objective;
import com.milestone.db.entity.User;
import com.milestone.service.MainPageService;

/**  
* <p>Title: MainPageController</p>  
* <p>Description: 后台首页相关操作请求处理Controller类</p>  
* @author WangTianci  
* @date 2018年5月10日  
*/
@Controller
@RequestMapping("/logic")
public class MainPageController {
	@Autowired
	private MainPageService mainPageService;

	/**  
	 * <p>Title: searchMyTarget</p>  
	 * <p>Description: 后台首页我的目标分页查询请求</p> 
	 * @param HttpServletRequest,HttpServletResponse
	 * @return List<Objective>
	 * @throws   
	 */
	@RequestMapping("/searchMyTarget.do")
	@ResponseBody
	public List<Objective> searchMyTarget(String mark,
			HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		List<Objective> listObjective = mainPageService.searchMyTarget(
				user.getUserId(), mark);
		return listObjective;
	}

	/**  
	 * <p>Title: searchMyMilestoneInfo</p>  
	 * <p>Description: 后台首页里程碑中分页查询请求</p> 
	 * @param String objectiveTitle,HttpServletRequest,HttpServletResponse
	 * @return List<Objective>
	 * @throws   
	 */
	@RequestMapping("/searchMyMilestoneInfo.do")
	@ResponseBody
	public List<Objective> searchMyMilestoneInfo(String objectiveTitle,
			HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		List<Objective> listObjective = mainPageService.searchMyMilestoneInfo(
				user.getUserId(), objectiveTitle);
		return listObjective;
	}

	/**  
	 * <p>Title: selectPersonalInfo</p>  
	 * <p>Description: 后台首页个人中心当前用户个人信息展示请求</p> 
	 * @param HttpServletRequest,HttpServletResponse
	 * @return User
	 * @throws   
	 */
	@RequestMapping("/selectPersonalInfo.do")
	@ResponseBody
	public User selectPersonalInfo(HttpServletRequest request,
			HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		return mainPageService.selectPersonalInfo(user.getUserId());
	}

	/**  
	 * <p>Title: savePersonalInfo</p>  
	 * <p>Description: 后台首页个人中心保存个人变更信息</p> 
	 * @param User
	 * @return boolean
	 * @throws   
	 */
	@RequestMapping("/savePersonalInfo.do")
	@ResponseBody
	public boolean savePersonalInfo(User user) {

		return mainPageService.savePersonalInfo(user);
	}

	/**  
	 * <p>Title: createTarget</p>  
	 * <p>Description: 后台首页创建目标确认创建请求</p> 
	 * @param Objective,HttpServletRequest,HttpServletResponse
	 * @return boolean
	 * @throws   
	 */
	@RequestMapping("/createTarget.do")
	@ResponseBody
	public boolean createTarget(Objective objective,
			HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		objective.setObjectiveId(UUID.randomUUID().toString());
		objective.setObjectiveUid(user.getUserId());
		return mainPageService.createTarget(objective);
	}

	/**  
	 * <p>Title: updateObjectiveTableInfo</p>  
	 * <p>Description: 更新Objective数据库表字段的请求</p> 
	 * @param Objective,HttpServletRequest,HttpServletResponse
	 * @return boolean
	 * @throws   
	 */
	@RequestMapping("/updateObjectiveTableInfo.do")
	@ResponseBody
	public boolean updateObjectiveTableInfo(Objective objective,
			HttpServletRequest request, HttpServletResponse response) {
		return mainPageService.updateObjectiveTableInfo(objective);
	}

	/**  
	 * <p>Title: updateObjectiveTableInfo</p>  
	 * <p>Description: 删除Objective数据库表字段的请求</p> 
	 * @param Objective,HttpServletRequest,HttpServletResponse
	 * @return boolean
	 * @throws   
	 */
	@RequestMapping("/deleteObjectiveTableInfo.do")
	@ResponseBody
	public boolean deleteObjectiveTableInfo(Objective objective,
			HttpServletRequest request, HttpServletResponse response) {
		return mainPageService.deleteObjectiveTableInfo(objective);
	}

	/**  
	 * <p>Title: selectObjectiveInfoById</p>  
	 * <p>Description: 后台首页编辑目标确认修改请求</p> 
	 * @param String objectiveId
	 * @return Objective
	 * @throws   
	 */
	@RequestMapping("/selectObjectiveInfoById.do")
	@ResponseBody
	public Objective selectObjectiveInfoById(String objectiveId) {
		return mainPageService.selectObjectiveInfoById(objectiveId);
	}
}
