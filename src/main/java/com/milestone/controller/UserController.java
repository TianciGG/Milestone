package com.milestone.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.milestone.db.entity.ReturnEntity;
import com.milestone.db.entity.User;
import com.milestone.service.UserService;

/**  
* <p>Title: UserController</p>  
* <p>Description: 用户相关操作请求处理Controller类</p>  
* @author WangTianci  
* @date 2018年5月9日  
*/
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**  
	 * <p>Title: loginUser</p>  
	 * <p>Description: 用户登录请求</p> 
	 * @param HttpServletRequest,HttpServletResponse,User,String remFlag
	 * @return ReturnEntity
	 * @throws   
	 */
	@RequestMapping("/loginUser.do")
	@ResponseBody
	public ReturnEntity loginUser(HttpServletRequest request,
			HttpServletResponse response, User user, String remFlag) {
		ReturnEntity result = new ReturnEntity();
		User u = null;
		if (user != null) {
			u = userService.loginUser(user);
		}
		if (u != null) {
			if ("1".equals(remFlag)) { // "1"表示用户勾选记住密码
				String loginInfo = u.getUserName();
				Cookie userCookie = new Cookie("loginInfo", loginInfo);

				userCookie.setMaxAge(30 * 24 * 60 * 60); // 存活期为一个月 30*24*60*60
				userCookie.setPath("/");
				response.addCookie(userCookie);
			} else {
				Cookie[] cookies = request.getCookies();
				if (null == cookies) {
					System.out.println("没有cookie==============");
				} else {
					String loginInfo = "loginInfo";
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals(loginInfo)) {
							cookie.setValue(null);
							cookie.setMaxAge(0);// 立即销毁cookie
							cookie.setPath("/");
							System.out.println("被删除的cookie名字为:"
									+ cookie.getName());
							response.addCookie(cookie);
							break;
						}
					}
				}
			}
			request.getSession().setAttribute("user", u);
			result.setObj(u);
			result.setStatus("200");
		} else {
			result.setObj(null);
			result.setStatus("500");
		}
		return result;
	}

	/**  
	 * <p>Title: registerUser</p>  
	 * <p>Description: 用户注册请求</p> 
	 * @param User
	 * @return	ReturnEntity
	 * @throws   
	 */
	@RequestMapping("/registerUser.do")
	@ResponseBody
	public ReturnEntity registerUser(User u) {
		ReturnEntity result = new ReturnEntity();
		Integer i = 0;
		if (u != null) {
			i = userService.registerUser(u);
			result.setObj(i);
			result.setMsg("注册成功");
			if (i == 4) {
				result.setMsg("账号已存在");
			}
			result.setStatus("200");
		} else {
			result.setMsg("注册失败");
			result.setStatus("500");
		}
		return result;
	}

	/**  
	 * <p>Title: validateEmail</p>  
	 * <p>Description: 验证邮箱请求</p> 
	 * @param 
	 * @return
	 * @throws   
	 */
	@RequestMapping("/validateEmail.do")
	@ResponseBody
	public ReturnEntity validateEmail(String mail) {
		ReturnEntity result = new ReturnEntity();
		Integer i = 0;
		if (mail != null) {
			i = userService.validateEmail(mail);
			result.setObj(i);
			result.setMsg("发送邮件成功，请耐心等待并关注个人邮箱！");
			if (i == 4) {
				result.setMsg("发送邮件失败!");
			}
			result.setStatus("200");
		} else {
			result.setMsg("发送邮件失败!");
			result.setStatus("500");
		}
		return result;
	}
}
