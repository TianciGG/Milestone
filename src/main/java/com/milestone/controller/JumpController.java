package com.milestone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**  
* <p>Title: JumpController</p>  
* <p>Description:项目跳转请求处理Controller类 </p>  
* @author WangTianci  
* @date 2018年5月9日  
*/
@Controller
public class JumpController {

	/**  
	* <p>Title: toRegister</p>  
	* <p>Description: 跳转到注册页面的请求</p> 
	* @param 
	* @return String
	* @throws  
	*/
	@RequestMapping(value = "goToRegisterPage.do", method = RequestMethod.GET)
	public String toRegister() {
		return "register";
	}

	/**  
	* <p>Title: toRevisePwd</p>  
	* <p>Description: 跳转到密码修改页面的请求</p> 
	* @param
	* @return String
	* @throws   
	*/
	@RequestMapping(value = "goToRevisePwdPage.do", method = RequestMethod.GET)
	public String toRevisePwd() {
		return "revisePwd";
	}

	/**  
	* <p>Title: toMain</p>  
	* <p>Description: 跳转到后台主页的请求</p> 
	* @param
	* @return String
	* @throws   
	*/
	@RequestMapping(value = "goToMainPage.do", method = RequestMethod.GET)
	public String toMain() {
		return "main";
	}

}
